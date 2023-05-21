package Controller;

import Model.GameDB;
import java.util.HashMap;

public class Room
{
    private int roomId;
    private String roomName;
    private String roomDescription;
    private HashMap<String, Item> items = new HashMap<String, Item>();
    private HashMap<String, Exit> exits = new HashMap<String, Exit>();

    private GameDB gameDB;

    public Room(int roomId, String roomName, String roomDescription)
    {
        gameDB = new GameDB();
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomDescription = roomDescription;

        initItems(items);
        initExits(exits);
    }

    public int getRoomId(){ return roomId; }
    public void setRoomId(int roomId){ this.roomId = roomId; }
    public String getRoomName(){ return roomName; }
    public void setRoomName(String roomName){ this.roomName = roomName; }
    public String getRoomDescription(){ return roomDescription; }
    public void setRoomDescription(String roomDescription){ this.roomDescription = roomDescription; }


    private void initItems(HashMap<String, Item> items)
    {
        for(Item item : gameDB.getItemDB().getItems())
        {
            if(item.getItemLocation() == roomId)
            {
                items.put(item.getItemName(), item);
            }
        }
    }

    private void initExits(HashMap<String, Exit> exits)
    {
        // TODO -> Finish this method
    }
}

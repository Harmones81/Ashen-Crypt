package Controller;

import Model.GameDB;
import java.util.ArrayList;

public class Room
{
    private int roomId;
    private String roomName;
    private String roomDescription;
    private boolean visited;
    private ArrayList<Item> items = new ArrayList<Item>();
    private ArrayList<Exit> exits = new ArrayList<Exit>();
    private GameDB gameDB;

    public Room()
    {
        gameDB = GameDB.getInstance();
        visited = false;

        initItems(items);
    }

    public Room(int roomId, String roomName, String roomDescription)
    {
        gameDB = GameDB.getInstance();
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        visited = false;

        initItems(items);
    }

    public int getRoomId(){ return roomId; }
    public void setRoomId(int roomId){ this.roomId = roomId; }
    public String getRoomName(){ return roomName; }
    public void setRoomName(String roomName){ this.roomName = roomName; }
    public String getRoomDescription(){ return roomDescription; }
    public void setRoomDescription(String roomDescription){ this.roomDescription = roomDescription; }
    public boolean getVisitation(){ return visited; }
    public void setVisited(boolean visited){ this.visited = visited; }

    public void addItem(Item item){ items.add(item); }
    public void addExit(Exit exit){ exits.add(exit); }
    public void removeItem(Item item){ items.remove(item); }

    private void initItems(ArrayList<Item> items)
    {
        for(Item item : gameDB.getItemDB().getItems())
        {
            if(item.getItemLocation() == roomId)
            {
                items.add(item);
            }
        }
    }
}

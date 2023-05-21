package Controller;

import java.util.HashMap;

public class Room
{
    private int roomId;
    private String roomName;
    private String roomDescription;
    private HashMap<String, Item> items = new HashMap<String, Item>();
    private HashMap<String, Exit> exits = new HashMap<String, Exit>();

    public Room(int roomId, String roomName, String roomDescription)
    {
        this.roomId = roomId;
        this.roomName = roomName;
        this.roomDescription = roomDescription;

        setItems(items);
        setExits(exits);
    }

    public void setItems(HashMap<String, Item> items)
    {

    }

    public void setExits(HashMap<String, Exit> exits)
    {

    }
}

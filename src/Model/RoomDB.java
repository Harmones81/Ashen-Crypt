package Model;

import Controller.Room;
import java.util.ArrayList;

public class RoomDB
{
    private static RoomDB instance;

    private ArrayList<Room> rooms;

    public static RoomDB getInstance()
    {
        if(instance == null)
        {
            instance = new RoomDB();
        }

        return instance;
    }

    public RoomDB()
    {
        rooms = new ArrayList<Room>();
        readRooms();
    }

    private void readRooms()
    {

    }

    public Room getRoom(int roomId)
    {
        return null;
    }

    public Room getRoom(String roomName)
    {
        return null;
    }

    public ArrayList<Room> getRooms(){ return rooms; }
}

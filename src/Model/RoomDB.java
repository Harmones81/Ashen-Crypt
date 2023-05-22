package Model;

import Controller.Exit;
import Controller.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDB extends DB
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

    public Room getRoom(int roomId) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        Room rm = new Room();
        String sql = "Select * from Room WHERE roomNumber = " + roomId;
        ResultSet rs = sdb.queryDB(sql);

        if (rs.next())
        {
            rm.setRoomId(rs.getInt("roomNumber"));
            rm.setRoomName(rs.getString("roomName"));
            rm.setRoomDescription(rs.getString("roomDescription"));
            rm.setVisited(rs.getBoolean("visited"));
            buildExits(rm);
        }
        else
        {
            throw new SQLException("Room " + roomId + " not found");
        }

        sdb.close();

        return rm;
    }

    public Room getRoom(String roomName) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        Room rm = new Room();
        String sql = "Select * from Room WHERE roomName = " + roomName;
        ResultSet rs = sdb.queryDB(sql);

        if (rs.next())
        {
            rm.setRoomId(rs.getInt("roomNumber"));
            rm.setRoomName(rs.getString("roomName"));
            rm.setRoomDescription(rs.getString("roomDescription"));
            rm.setVisited(rs.getBoolean("visited"));
            buildExits(rm);
        }
        else
        {
            throw new SQLException("Room " + roomName + " not found");
        }

        sdb.close();

        return rm;
    }

    private void buildExits(Room room) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        String sql = "Select * from Room WHERE roomNumber = " + room.getRoomId();
        ResultSet rs = sdb.queryDB(sql);

        if(rs.next())
        {
            String exits = rs.getString("roomExits");
            String[] parts = exits.split(", ");

            for(String part : parts)
            {
                String[] data = part.split(" ");

                String direction = data[0];
                int destination = Integer.parseInt(data[1]);

                Exit exit = new Exit(destination, direction);
                room.addExit(exit);
            }
        }
    }

    public ArrayList<Room> getRooms(){ return rooms; }

    //updates room based on if it is visited or not
    public void updateRoom(Room room) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        String sql = "UPDATE ROOM SET visited = 1 WHERE roomNumber = " + room.getRoomId();
        sdb.updateDB(sql);
        sdb.close();
    }

    //Was the room visited or not?
    public int isVisited(int roomID) throws SQLException, ClassNotFoundException
    {
        int visitedNum = 0;
        SQLiteDB sdb = new SQLiteDB();
        String sql = "SELECT visited FROM ROOM WHERE roomNumber = " + roomID;
        ResultSet rs = sdb.queryDB(sql);

        while (rs.next())
        {
            visitedNum = rs.getInt("visited");
        }

        sdb.close();

        return visitedNum;
    }
}

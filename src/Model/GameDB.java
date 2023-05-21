package Model;

public class GameDB
{
    private final RoomDB roomDB;
    private final ItemDB itemDB;

    public GameDB()
    {
        roomDB = new RoomDB();
        itemDB = new ItemDB();
    }

    public RoomDB getRoomDB(){ return roomDB; }
    public ItemDB getItemDB(){ return itemDB; }
}

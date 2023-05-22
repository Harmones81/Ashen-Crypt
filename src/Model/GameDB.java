package Model;

public class GameDB
{
    private final RoomDB roomDB;
    private final ItemDB itemDB;
    private static GameDB instance;
    public static GameDB getInstance()
    {
        if(instance == null)
        {
            instance = new GameDB();
        }

        return instance;
    }

    public GameDB()
    {
        roomDB = RoomDB.getInstance();
        itemDB = ItemDB.getInstance();
    }

    public RoomDB getRoomDB(){ return roomDB; }
    public ItemDB getItemDB(){ return itemDB; }
}

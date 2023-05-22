package Model;

import Controller.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDB
{
    private static ItemDB instance;

    private ArrayList<Item> items;

    public static ItemDB getInstance()
    {
        if(instance == null)
        {
            instance = new ItemDB();
        }

        return instance;
    }

    public ItemDB()
    {
        items = new ArrayList<Item>();
        readItems();
    }

    private void readItems()
    {

    }

    public Item getItem(int itemId) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        Item itm = new Item();
        String sql = "Select * from Item WHERE itemNumber = " + itemId;
        ResultSet rs = sdb.queryDB(sql);

        if (rs.next())
        {
            itm.setItemId(rs.getInt("itemNumber"));
            itm.setItemName(rs.getString("itemName"));
            itm.setItemLocation(rs.getInt("itemLocation"));
            itm.setItemDescription(rs.getString("itemDescription"));
        }
        else
        {
            throw new SQLException("Item " + itemId + " not found");
        }

        sdb.close();

        return itm;
    }

    public Item getItem(String itemName) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        Item itm = new Item();
        String sql = "Select * from Item WHERE itemName = " + itemName;
        ResultSet rs = sdb.queryDB(sql);

        if (rs.next())
        {
            itm.setItemId(rs.getInt("itemNumber"));
            itm.setItemName(rs.getString("itemName"));
            itm.setItemLocation(rs.getInt("itemLocation"));
            itm.setItemDescription(rs.getString("itemDescription"));
        }
        else
        {
            throw new SQLException("Item " + itemName + " not found");
        }

        sdb.close();

        return itm;
    }

    public ArrayList<Item> getItems(){ return items; }
}

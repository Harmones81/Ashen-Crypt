package Model;

import Controller.Item;
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

    public Item getItem(int itemId)
    {
        return null;
    }

    public Item getItem(String itemName)
    {
        return null;
    }

    public ArrayList<Item> getItems(){ return items; }
}

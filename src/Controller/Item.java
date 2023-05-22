package Controller;

public class Item
{
    private int itemId;
    private int itemLocation;
    private String itemName;
    private String itemDescription;

    public Item()
    {

    }

    public Item(int itemId, int itemLocation, String itemName, String itemDescription)
    {
        this.itemId = itemId;
        this.itemLocation = itemLocation;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public int getItemId(){ return itemId; }
    public void setItemId(int itemId){ this.itemId = itemId; }
    public int getItemLocation(){ return itemLocation; }
    public void setItemLocation(int itemLocation){ this.itemLocation = itemLocation; }
    public String getItemName(){ return itemName; }
    public void setItemName(String itemName){ this.itemName = itemName; }
    public String getItemDescription(){ return itemDescription; }
    public void setItemDescription(String itemDescription){ this.itemDescription = itemDescription; }
}

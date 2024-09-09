import java.util.HashMap;
/**
 * Write a description of class Room here.
 * 
 * @author (Casey Braun) 
 * @version (11-23-15)
 */
public class Room
{
    private String description;
    private Item item;
    private HashMap<String, Room> roomList;
    private boolean monsterStatus;
    
    public Room (String pDescription) 
    {
        description = pDescription;
        item = null;
        roomList = new HashMap<String, Room>();
        monsterStatus = false;
    }
    
    public Room (String pDescription, boolean status)
    {
        description = pDescription;
        item = null;
        roomList = new HashMap<String, Room>();
        monsterStatus = status;
    }
    
    public Room (String pDescription, boolean status, Item pItem)
    {
        description = pDescription;
        item = pItem;
        roomList = new HashMap<String, Room>();
        monsterStatus = status;
    }
    
    public boolean getMonsterStatus()
    {
        return monsterStatus;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public Item getItem()
    {
        return item;
    }
    
    public void addItem (Item i) 
    {
        item = i;
    }
        
    public boolean hasItem () 
    {
        if (item != null)
            return true;
        else
            return false;
    }
    
    public void addNeighbor (String pDirection, Room r)
    {
        roomList.put(pDirection, r);
    }
    
    public Room getNeighbor (String pDirection)
    {
        Room ret = roomList.get(pDirection);
        return ret;
    }
    
    public Item removeItem () 
    {
        Item get = item;
        item = null;
        return get;
    }
    
    public String getLongDescription () 
    {
        String longDesc = "You are " + description + "\n";
        if (item != null)
            longDesc += " You see " + item.getDesc() + "\n";
        return longDesc; 
    }
    
    public void setStatusFalse()
    {
        monsterStatus = false;
    }
}


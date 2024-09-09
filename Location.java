import java.util.HashMap;
/**
 * Write a description of class Room here.
 * 
 * @author (Casey Braun) 
 * @version (4/16/17)
 */
public class Location
{
    /**description of the current location */
    private String description;
    /**items*/
    private Item item;
    /**a list of all adjacent locations */
    private HashMap<String, Location> roomList;
    /**checks the monster status if defeated or not*/
    private boolean monsterStatus;
    
      /*************************
     *  constructor that is passed the description. The location’s item is set to null
     *************************/
    public Location (String pDescription) 
    {
        description = pDescription;
        item = null;
        roomList = new HashMap<String, Location>();
        monsterStatus = false;
    }
    

    
      /*************************
     *   an alternative constructor that is passed the description and the item. 
     *************************/
    public Location (String pDescription, boolean status, Item pItem)
    {
        description = pDescription;
        item = pItem;
        roomList = new HashMap<String, Location>();
        monsterStatus = status;
    }
    
      /*************************
     * @return return the status of enmey
     *************************/
    public boolean getMonsterStatus()
    {
        return monsterStatus;
    }
    
      /*************************
     * @return return the location's description.
     *************************/
    public String getDescription()
    {
        return description;
    }
    
      /*************************
     *  @return return the location's item.
     *************************/
    public Item getItem()
    {
        return item;
    }
    
      /*************************
     *   @param add the provided item to the location
     *************************/
    public void addItem (Item i) 
    {
        item = i;
    }
    
      /*************************
     *  @param return true if the location has an item
     *************************/
    public boolean hasItem () 
    {
      return item !=null;
    }
    
      /*************************
     *  @param add the provided location and corresponding direction 
     *************************/
    public void addNeighbor (String pDirection, Location r)
    {
        roomList.put(pDirection, r);
    }
    
      /*************************
     *  @return return the adjacent location in the requested direction
     *************************/
    public Location getNeighbor (String pDirection)
    {
        Location ret = roomList.get(pDirection);
        return ret;
    }
    
      /*************************
     *  @param remove and return the location’s item
     *************************/
    public Item removeItem () 
    {
        Item get = item;
        item = null;
        return get;
    }
    
      /*************************
     *  @return return a String that begins with “You are” followed by the location description
     *************************/
    public String getLongDescription () 
    {
        String longDesc = "You are " + description + "\n";
        if (item != null)
            longDesc += " You see " + item.getDesc() + "\n";
        return longDesc; 
    }
    
      /*************************
     *  @param used to keep track of if the bosses for each planet are alive or dead
     *************************/
    public void setStatusFalse()
    {
        monsterStatus = false;
    }
}


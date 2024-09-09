
/**
 * maintain information about an item including: a one-word name (String), 
 * a longer description of the item (String), a weight (int) and whether it is edible (boolean)
 * @author (Casey Braun)
 * @version (4/9/17)
 */
public class Item
{
    /**short description of the item*/
    private String name;
    /**longer description of the item */
    private String description;
    /**weight of item*/
    private int weight;
    /**are you able to eat the item*/
    private boolean edible;
  
    /*************************
     *  constructor that initializes all of the instance variables to the provided values
     *  @param n name of item
     *  @param d description
     *  @param e is edible or not
     *************************/
    public Item (String n, String d, int w, boolean e)
    {
        name = n;
        description = d;
        weight = w;
        edible = e;
    }
 
     /*************************
     * @return name
     *************************/
    public String getName()
    {
        return name;
    }
    
     /*************************
     * @return description
     *************************/
    public String getDesc()
    {
        return description;
    }
    
     /*************************
     * @return weight
     *************************/
    public int getWeight()
    {
        return weight;
    }
    
     /*************************
     * @return edible
     *************************/
    public boolean getEdible()
    {
        return edible;
    }
    
     /*************************
     * @return name
     *************************/
    public void setName(String n)
    {
        name = n;
    }
    
     /*************************
     *  
     * @param sets description
     *************************/
    public void setDesc(String ln)
    {
        description = ln;
    }
    
     /*************************
     * @param sets weight 
     *************************/
    public void setWeight(int w)
    {
        weight = w;
    }
    
     /*************************
     * @param e sets edible
     *************************/
    public void setEdible(boolean e)
    {
        edible = e;
    }
    
     /*************************
     *   @param true if the item is edible.  Otherwise, return false.
     *************************/
    public boolean isEdible()
    {
        if (edible == true)
            return true;
        else
            return false;
    }
}
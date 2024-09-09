
/**
 * Write a description of class Item here.
 *
 * @author (Casey Braun)
 * @version (11-22-15)
 */
public class Item
{

    private String name;
    private String description;
    private int weight;
    private boolean edible;
    //initialize instance variables.
    public Item (String n, String d, int w, boolean e)
    {
        name = n;
        description = d;
        weight = w;
        edible = e;
    }
    //get and setters
    public String getName()
    {
        return name;
    }
    
    public String getDesc()
    {
        return description;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public boolean getEdible()
    {
        return edible;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setDesc(String ln)
    {
        description = ln;
    }
    
    public void setWeight(int w)
    {
        weight = w;
    }
    
    public void setEdible(boolean e)
    {
        edible = e;
    }
    // return true if the item is edible.  Otherwise, return false.
    public boolean isEdible()
    {
        if (edible == true)
            return true;
        else
            return false;
    }
}
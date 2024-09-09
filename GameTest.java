
/**
 * automatically play a game until the player wins and also demonstrates all game methods work
 * 
 * @author Casey Braun
 * @version 4/18/19
 */
public class GameTest
{

    public static void main (String args[]){

        System.out.println("****************g test****************");
        int errors=0;
        Game g = new Game();
        //taris
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());
        
        g.spareLight();
        System.out.println(g.getMessage());
        
        g.drop("Credits");   
        System.out.println(g.getMessage());
        //danttonie
        g.move("north");   
        System.out.println(g.getMessage());
        //tatoonie
        g.move("north");   
        System.out.println(g.getMessage());
        //illum
        g.move("north");   
        System.out.println(g.getMessage());
   
        g.pickup();
        System.out.println(g.getMessage());
        g.move("west");   
        //to heavy
         System.out.println(g.getMessage());  
        g.pickup();
         System.out.println(g.getMessage());
        g.move("west");   
        System.out.println(g.getMessage());
   
        g.pickup();
         System.out.println(g.getMessage());
        g.move("west");   
        System.out.println(g.getMessage());
        g.pickup();

        System.out.println(g.getMessage());
        g.move("north");
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage()); 
        g.spareLight();
        System.out.println(g.getMessage());        
        g.move("east");
        System.out.println(g.getMessage()); 
        g.spareLight();
        System.out.println(g.getMessage());        
        g.move("east");
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());          
        g.spareLight();
        System.out.println(g.getMessage());        
        g.move("east");
        System.out.println(g.getMessage());          
        g.spareLight();
        System.out.println(g.getMessage());
        g.move("south");
        System.out.println(g.getMessage());          
        g.spareLight();
        System.out.println(g.getMessage());
        g.move("east");
        System.out.println(g.getMessage());
        g.pickup();
        System.out.println(g.getMessage());          
        //final planet
        g.spareLight();
        System.out.println(g.getMessage()); 
        if(g.gameOver()){ 
            System.out.println(g.getMessage());

        }
    }
}
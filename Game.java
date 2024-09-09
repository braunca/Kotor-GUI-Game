
import java.util.ArrayList;
/**
 * responsible for keeping track of the player’s items and the current location
 * 
 * @author (Casey Braun) 
 * @version (4/9/17)
 */
public class Game
{
    
    private ArrayList<Item> bag;
    private String currentMessage;
    private Location currentRoom;
 
    /**items on planets*/
    private Item mandorlianAmor;
    private Item jediHolcron ;
    private Item sithHolcron;
    private Item krayttDragonSkull;
    private Item credits;
    private Item cake;
    private Item medkit;
    private Item forgeMap;

  
    /**rooms(planets)*/
    private Location onderon;
    private Location llum;
    private Location korriban;
    private Location tatooine;
    private Location taris;
    private Location kashyyyk;
    private Location manaan;
    private Location dantooine;
    
    /**killing target or sparing them, light or dark side wich will add to the counter */
    private int killed;
    private int spared;
     /************************* 
     *  Instantiate the ArrayList of Items
     *************************/
    public Game()
    {
        setWelcomeMessage();               
        createWorld();
        currentRoom = taris;
        bag = new ArrayList<Item>();
        killed = 0;
        spared = 0;
    }

     /*************************
     * @return current mesage
     *************************/
    public String getMessage () 
    {
        return currentMessage;
    }
    
     /*************************
     * @return current room
     *************************/
    public Location getRoom()
    {
        return currentRoom;
    }
     /*************************
     * 
     *************************/
   public String checkForBlock()
    {
        if (currentRoom == taris && currentRoom.getMonsterStatus() == true)
            return "taris";
        else if (currentRoom == dantooine && currentRoom.getMonsterStatus() == true)
            return "dantooine";
        else if (currentRoom == kashyyyk && currentRoom.getMonsterStatus() == true)
            return "kashyyyk";
        else if (currentRoom == manaan && currentRoom.getMonsterStatus() == true)
            return "manaan";
        else if (currentRoom == onderon && currentRoom.getMonsterStatus() == true)
            return "onderon";
        else if (currentRoom == llum && currentRoom.getMonsterStatus() == true)
            return "llum";
        else if (currentRoom == tatooine && currentRoom.getMonsterStatus() == true)
            return "tatooine";
        else if (currentRoom == korriban && currentRoom.getMonsterStatus() == true)
            return "korriban";
        else 
            return null;
    }

     /*************************
     * @param creates the the items and puts the items in the rooms created
     *************************/
    private void createWorld()
    {
        //the items, mandorlianAmor will be too heavy, cake will be able to eat
        mandorlianAmor = new Item("Mandorlian Amor", " amor that looks like it will protect you from some damage\n but force wielders have a hard time using their abilties. \n", 51, false); //this item will be too heavy
        jediHolcron = new Item("Jedi Holcron", " a small cube\n that if touched helps you learn knowledge of the jedi ways. \n", 2, false);
        sithHolcron = new Item("Sith Holcron", " a small cube\n that if touched helps you learn knowledge of the sith ways. \n", 2, false);
        krayttDragonSkull = new Item("Kraytt dragon skull", " a skull from a dead Kraytt dragon ,\n can either  used as a trophy or maybe sold for credits.\n", 7, false);
        credits = new Item("Credits", " credits which are the from of currency in the galaxy.\n", 4, false);
        medkit = new Item("Medkit", "a small medkit that heals you of some damage.\n", 1, false);
        forgeMap = new Item("Forge Map", "a imcomplete map of a unknown weapon.\n", 1, false);
        cake = new Item("Forest-honey cake"," a cake you were given as a gift\n",3,true);
       
        //the planets,(the trues set monster status to true which allow a boss to be on the planet)
        onderon = new Location("on Onderon which, is located in a region of space known as the Inner Rim.\n Planet Onderon is located in the Japreal System. \nOnderon has one sun and four moons.\n The major species found on Onderon are Human. \nIts terrain is mostly made up of jungles and seas. \n The greatest interest in Onderon is in its moon Dxun and its largest city Iziz. \n Onderon has Galactic Republic and New Republic affiliation. .\n", true , mandorlianAmor);
        llum = new Location(" on Ilum ,which was an arctic planet located in the Unknown Regions.[1] It was used by the Jedi Order for The Gathering, a rite of passage in which Jedi younglings must find and harvest kyber crystals for their lightsabers.\n", true,jediHolcron);
        korriban = new Location("on Korriban .It is located in a region of space known as the Outer Rim Territories.\n Planet Korriban is located in the Horuset system. Korriban has one sun.\n The major species found on Korriban are Human (Sith).\n The planetary population of Korriban was 25,000 before the Jedi Civil War. Korriban has Sith affiliation.\n", true, sithHolcron);
        tatooine = new Location(" on Tatooine. A dusty, desert area with a small mining settlement run by Czerka Corp.\n It is inhabitied with humans and aliens,\n as well as the natural population of Jawas, Sand People and a Krayt Dragon.\n", true, krayttDragonSkull);
        taris = new Location("on Taris. A strange world, divided very clearly into the Upper City,\n Lower City and Undercity. Each level is very different from each other,\n from the people you meet to the actual setting.\n  Your ship was attacked by the sith, many of your fellow crew members died \nhowever many also got into the escape pods and landed on Taris.\n", true,credits);
        kashyyyk = new Location("on Kashyyyk home to the Wookiees. A rich and fertile forest land,\n where the locals live in trees because of the dangers that lurk on the forest floor.\n", true, cake);
        manaan = new Location("on Manaan. A water world, with only the city of Ahto as a place for outsiders to stay.\n It houses the native fish people, the Selkath who try to remain neutral in the war between the Sith and the Republic. \n", true, medkit);
        dantooine = new Location(" on Dantooine which is 45,000 light years away from Core.\n It is located in a region of space known as the Outer Rim Territories. Planet Dantooine is located in the Dantooine System. Dantooine has one sun and two moons. The major species found on Dantooine are Dantari. The planetary population of Dantooine is 2,000,000.\n The native language spoken is called Dantarian. \nThe surface of Dantooine is about 70% water.\nIts terrain is mostly made up of grasslands and steppes.\n A Jedi base resides here.\n", true,forgeMap);
       
        //adding whats next to each planet
        taris.addNeighbor("north", dantooine);
        dantooine.addNeighbor("north", tatooine);
        dantooine.addNeighbor("east", kashyyyk);
        kashyyyk.addNeighbor("west", dantooine);
        kashyyyk.addNeighbor("east", manaan);
        manaan.addNeighbor("west", kashyyyk);
        manaan.addNeighbor("east", onderon);
        onderon.addNeighbor("west", manaan);
        onderon.addNeighbor("east", llum);
        llum.addNeighbor("west", onderon);
        llum.addNeighbor("south",tatooine);
        tatooine.addNeighbor("north",llum);
        tatooine.addNeighbor("east",korriban);
        korriban.addNeighbor("west",tatooine);
        
    }

      /*************************
     * Sets a welcome message
     *************************/
    private void setWelcomeMessage() 
    {
        currentMessage = "Welcome to Star Wars Knights of the Old Republic(KOTOR)\n you shall be traveling the galaxy in your adventure,\n facing unknown enemies and trying to find a mystery that has been lost to many. \n";
    }

      /*************************
     * @param checks if there is a item with same as what was put into name
     *************************/
    private Item checkForItem (String name) 
    {
        for (int i = 0; i < bag.size(); i++)
        {
            if (bag.get(i).getName() == name)
                return bag.get(i);
        }
        return null;
    }
    //give a message for hint 
      /*************************
     * @param is info on what your suppose to do
     *************************/
    public void help () 
    {
        currentMessage="Your goal is to goal is to go each planet until you reach the end, whih requires you to have one item for the final battle";
    }
    //look around the room
      /*************************
     * @param looks at the room(planet and gives info about it
     *************************/
    public void look () 
    {
        currentMessage =  currentRoom.getLongDescription();
    }

     /*************************
     *  @param updates the current location with the neighbor in the requested location, if not say can not go that way
     *************************/
    public void move (String direction) 
    {
        Location nextRoom = currentRoom.getNeighbor(direction);
        //if room is null cant go that direction
        if (nextRoom == null)
            currentMessage = "You can't go in that direction\n";
        else
        {
            //you move to the next room that you picked
            currentRoom = nextRoom;
            currentMessage = currentRoom.getLongDescription();
        }     
    }
    //list of items
      /*************************
     * @param gives a list of items in bag
     *************************/
    public void list () 
    {
        currentMessage = "Items: \n";
        //if bag size is 0 you have no items
        if (bag.size() == 0)
            currentMessage = "You have no items!\n";
        else
        //shows list of items
            for (Item it : bag)
                currentMessage += (it.getName() + "\n");
    }
    //pickups items
      /*************************
     * @param pick up item in room if something is there
     *************************/
    public void pickup () 
    {
        //if the weight is less than 51 pickup item
        if (currentRoom.getItem() != null && currentRoom.getItem().getWeight() < 51)
        {
            currentMessage = ("You picked up the " + currentRoom.getItem().getName() + "!\n");
            bag.add(currentRoom.removeItem());
        }
        //if item is greater or equal to item it will be too heavy
        else if (currentRoom.getItem() != null && currentRoom.getItem().getWeight() >= 51)
            currentMessage = "The " + currentRoom.getItem().getName() + "is too heavy to carry!\n";
        else
            currentMessage = "There is no item in this room.\n";
    }
    //drops items
      /*************************
     * @param drops item and removes from bag if have item
     *************************/
    public void drop (String item) 
    {
        Item i = checkForItem(item);
        if (i == null)
            currentMessage = "You don't have that item.\n";
        else 
        {
            bag.remove(i);
            currentRoom.addItem(i);
            currentMessage = "You dropped the " + i.getName() + ".\n";
        }
    }
    //eats/use items
      /*************************
     * @param eat item if able, if not bring message cant do that, or bring message up if item is not there
     *************************/
    public void eat (String item) 
    {
       
        Item i = checkForItem(item);
        if (i == null)
            currentMessage = "You don't have that item.\n";
        else if (i.isEdible() == false)
            currentMessage = "You can't eat that item or use it.\n";
        else
        {
            bag.remove(i);
            currentMessage = "You eat/use the " + i.getName();
        }
    }
    
    //attack the enemy also dark side
      /*************************
     * @param results of dark side button, if enough spared or kill will get a special message for the greater one
     *************************/
    public void attackDark ()
    {
        if (currentRoom == taris && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "Governor: My master shall reward me with my own lightsaber after I kill you. \n After a ferious battle the governor falls onto the ground dead.\n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == dantooine && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "Sith Spy: The star forge sercets can not be known to the Jedi, die Jedi. \n You strike the sith down after a ferious battle when he falls onto the ground defeated, killing him.\n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == kashyyyk && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "The crazy wookie attacks you protecting it hostages. \n As the wookie is choking you to death you stab it in the chest with your lightsaber, killing the wookie and saving the hostages..\n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == manaan && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "Sith Lord: You tried to hide from me and now you will die. \n In the battle you use death life on a wounded soldier to heal yourself allowing you to kill the sith lord.\n";
            currentRoom.setStatusFalse();
           
       
        }
        else if (currentRoom == onderon && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "You train with the mandalorians and go off to battle to save the queen from a general that is revolting. \n After the battle is over you order  the death the general that started the revolt. \n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == llum && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "In search for the source of energy coming from the planet you find a cave full of tribemen, however they attack when they spot you. After killing some of them you decide to destory the cave killing all the tribemen.";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == tatooine && currentRoom.getMonsterStatus() == true)
        {
            killed++;
            currentMessage = "Calo Nord: There is a bounty on your head and more importantly you escaped Taris and left me to die, this time I'm prepared, boys lets get him... \n After killing Calo and most of his men, one surrenders however you still strike them down.\n";
            currentRoom.setStatusFalse();
        }
        //need to have a medkit to finish the game
        else if (currentRoom == korriban && currentRoom.getMonsterStatus() == true && bag.contains(medkit))
        {
            //if you killed is less than 4 you get a light side message
            if (killed < 4)
            {
                currentMessage = "Darth Baras: I see through you Jedi, you can't hide your true self. Now die!\n You barley defeat the sith in battle,killing him and collsape on the from the battle. Your friends take you away to safety.";
                bag.remove(jediHolcron);
                currentRoom.setStatusFalse();
            }
            //if killed is greater or equal to 4 you get a dark side message
            else if (killed >= 4)
            {
                currentMessage = "Jedi Master:I've been watching you and you have fallen to the dark side, if continued to live you will destory the jedi and the republic! \nYou kill the jedi master, his body disppearing as you strike him down.\n";
                bag.remove(sithHolcron);
                currentRoom.setStatusFalse();
            }
            bag.remove(medkit);
           
        }else{
            currentMessage = "There's no one to attack!\n";
        }
    }
   
      /*************************
     * @param results of light side button, if enough spared or kill will get a special message for the greater one
     *************************/
    public void spareLight ()
    {
        if (currentRoom == taris && currentRoom.getMonsterStatus() == true)
        {
            spared++;
            currentMessage = "Governor: My master shall reward me with my own lightsaber after I kill you. \n After a ferious battle the governor falls onto the ground, however you spare his life as you walk away you hear him yelling at  you before he passes out.\n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == dantooine && currentRoom.getMonsterStatus() == true)
        {
            spared++;
            currentMessage = "Sith Spy: The star forge sercets can not be known to the Jedi, die Jedi. \n You capture the sith down after a ferious battle, to be questioned by the Jedi Masters. \n";
            currentRoom.setStatusFalse();
 
        }
        else if (currentRoom == kashyyyk && currentRoom.getMonsterStatus() == true)
        {
            currentMessage = "The crazy wookie attacks you protecting it hostages. \n As the wookie is attcking  you, you use force push to knock it out and restrain it, lets the hostages take it.\n";;
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == manaan && currentRoom.getMonsterStatus() == true )
        {
            spared++;
            currentMessage = "Sith Lord: You tried to hide from me and now you will die. \n In the battle you use statis freezing the sith lord, however the area start to collaspe and he is crushed to death, however you and the soldier escapes.\n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == onderon && currentRoom.getMonsterStatus() == true)
        {
            spared++;
            currentMessage = "You train with the mandalorians and go off to battle to save the queen from a general that is revolting. \n After the battle is over you order the soldiers to take the general into prison. \n";
            currentRoom.setStatusFalse();
        }
        else if (currentRoom == llum && currentRoom.getMonsterStatus() == true )
        {
            spared++;
            currentMessage ="In search for the source of energy coming from the planet you find a cave full of tribemen, however they attack when they spot you. After killing some of them you decide to leave as quickly as possible";
            currentRoom.setStatusFalse();
           
        }
        else if (currentRoom == tatooine && currentRoom.getMonsterStatus() == true)
        {
            spared++;
            currentMessage =  "Calo Nord: There is a bounty on your head and more importantly you escaped Taris and left me to die, this time I'm prepared, boys lets get him... \n After killing Calo and most of his men, one surrenders and you let them run away. \n";
            currentRoom.setStatusFalse();

        }
         //need to have a medkit to finish the game
        else if (currentRoom == korriban && currentRoom.getMonsterStatus() == true && bag.contains(medkit))
        {
            //if you have less than 4 kill you get a light side message
            if (killed < 4)
            {
                currentMessage = "Darth Baras: I see through you Jedi, you can't hide your true self. Now die!\n You barley defeat the sith in battle,killing him and collsape on the from the battle. Your friends take you away to safety.";
                bag.remove(jediHolcron);
                currentRoom.setStatusFalse();
            }
            //if you have  4 kill or more you get a dark side message
            else if (killed >= 4)
            {
                currentMessage= "Jedi Master:I've been watching you and you have fallen to the dark side, if continued to live you will destory the jedi and the republic! \nYou kill the jedi master, his body disppearing as you strike him down.\n";
                bag.remove(sithHolcron);
                currentRoom.setStatusFalse();
            }
            bag.remove(medkit);
            
        }
        else
        {
            currentMessage = "There's nothing here.\n";
        }
    }
    
      /*************************
     * @param game is over if reach korriban, and remove the boss, will show ending messaging if true
     *************************/
    public boolean gameOver () 
    {
        if (currentRoom == korriban && currentRoom.getMonsterStatus() == false)
        {
            currentMessage = "\nYou travel to the star forge and destory it so the sith empire can not use it. You learn of a unknown threat outside of the galaxy \n and go in search of it and try to stop it, leaving your friends and allies to rebuild the Republic.\n :::::::::::::::You Win::::::::::::::: \n";
            return true;
        }
        else
            return false;
    }
  /*************************
     *@param if new game is pressed from the GUI this will reset everything 
     *************************/
    public void newGame(){
       
        setWelcomeMessage();               
        createWorld();
        currentRoom = taris;
        bag = new ArrayList<Item>();
        killed = 0;
        spared = 0;
     
    }
}

import java.util.ArrayList;
/**
 * Write a description of class Game here.
 * 
 * @author (Casey Braun) 
 * @version (12-10-15)
 */
public class Game
{
    private ArrayList<Item> bag;
    private String currentMessage;
    private Room currentRoom;
    //items
    private Item mandorlianAmor;
    private Item jediHolcron ;
    private Item sithHolcron;
    private Item krayttDragonSkull;
    private Item credits;
    private Item trophy;
    private Item medkit;
    private Item forgeMap;
    //rooms
    private Room onderon;
    private Room llum;
    private Room korriban;
    private Room tatooine;
    private Room taris;
    private Room kashyyyk;
    private Room manaan;
    private Room dantooine;
    //killing target or sparing them, light or dark side
    private int killed;
    private int spared;
    //contrustor
    public Game()
    {
        createRooms();
        bag = new ArrayList<Item>();
        currentRoom = taris;
        setWelcomeMessage();
        killed = 0;
        spared = 0;
    }

    public String getMessage () 
    {
        return currentMessage;
    }
    
    public Room getRoom()
    {
        return currentRoom;
    }
    
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

//creates the the items and puts the items in the rooms created
    private void createRooms ()
    {
        mandorlianAmor = new Item("Mandorlian Amor", " amor that looks like it will protect you from some damage. \n", 25, false);
        jediHolcron = new Item("Jedi Holcron", " a small cube that if touched helps you learn knowledge of the jedi ways. \n", 2, false);
        sithHolcron = new Item("Sith Holcron", " a small cube that if touched helps you learn knowledge of the sith ways. \n", 2, false);
        krayttDragonSkull = new Item("Kraytt dragon skull", " a skull from a Kraytt dragon you killed, can either  used as a trophy or maybe sold for credits.\n", 7, false);
        credits = new Item("Credits", " credits which are the from of currency in the galaxy.\n", 4, false);
        medkit = new Item("Medkit", "ya small medkit that heals you of some damage.\n", 1, true);
        forgeMap = new Item("Forge Map", "a imcomplete map of a unknown weapon.\n", 1, false);
       
        onderon = new Room("Onderon is located in a region of space known as the Inner Rim. Planet Onderon is located in the Japreal System. Onderon has one sun and four moons. The major species found on Onderon are Human. Its terrain is mostly made up of jungles and seas. The greatest interest in Onderon is in its moon Dxun and its largest city Iziz. Onderon has Galactic Republic and New Republic affiliation. .\n", true , mandorlianAmor);
        llum = new Room("Ilum was an arctic planet located in the Unknown Regions.[1] It was used by the Jedi Order for The Gathering, a rite of passage in which Jedi younglings must find and harvest kyber crystals for their lightsabers.\n", true,jediHolcron);
        korriban = new Room("Korriban It is located in a region of space known as the Outer Rim Territories. Planet Korriban is located in the Horuset system. Korriban has one sun. The major species found on Korriban are Human (Sith). The planetary population of Korriban was 25,000 before the Jedi Civil War. Korriban has Sith affiliation.\n", true, sithHolcron);
        tatooine = new Room("A dusty, desert area with a small mining settlement run by Czerka Corp. It is inhabitied with humans and aliens, as well as the natural population of Jawas, Sand People and a Krayt Dragon.\n", true, krayttDragonSkull);
        taris = new Room("“ A strange world, divided very clearly into the Upper City, Lower City and Undercity. Each level is very different from each other, from the people you meet to the actual setting.\n", true,credits);
        kashyyyk = new Room("to the native Wookiees. A rich and fertile forest land, where the locals live in trees because of the dangers that lurk on the forest floor.\n", true, trophy);
        manaan = new Room("A water world, with only the city of Ahto as a place for outsiders to stay. It houses the native fish people, the Selkath who try to remain neutral in the war between the Sith and the Republic. \n", true, medkit);
        dantooine = new Room("Dantooine is 45,000 light years away from Core. It is located in a region of space known as the Outer Rim Territories. Planet Dantooine is located in the Dantooine System. Dantooine has one sun and two moons. The major species found on Dantooine are Dantari. The planetary population of Dantooine is 2,000,000. The native language spoken is called Dantarian. The surface of Dantooine is about 70% water. Its terrain is mostly made up of grasslands and steppes. A Jedi base resides here.\n", true,forgeMap);
       
        
        taris.addNeighbor("north", dantooine);
        dantooine.addNeighbor("north", tatooine);
        dantooine.addNeighbor("east", kashyyyk);
        kashyyyk.addNeighbor("west", dantooine);
        kashyyyk.addNeighbor("east", manaan);
        manaan.addNeighbor("west", kashyyyk);
        manaan.addNeighbor("east", manaan);
        onderon.addNeighbor("west", manaan);
        onderon.addNeighbor("east", llum);
        llum.addNeighbor("west", onderon);
        llum.addNeighbor("south",tatooine);
        tatooine.addNeighbor("north",llum);
        tatooine.addNeighbor("east",korriban);
        korriban.addNeighbor("west",tatooine);
        
    }

    private void setWelcomeMessage () 
    {
        currentMessage = "Welcome to Star Wars Knights of the Old Republic(KOTOR) you shall be traveling the galaxy in your adventure, facing unknown enemies and trying to find a mystery that has been lost to many. \n";
    }

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
    public void help () 
    {
        currentMessage="Your goal is to goal is to go each planet until you reach the end, whih requires you to have one item for the final battle";
    }
    //look around the room
    public void look () 
    {
        currentMessage =  currentRoom.getLongDescription();
    }
    //moving
    public void move (String direction) 
    {
        Room nextRoom = currentRoom.getNeighbor(direction);
        if (nextRoom == null)
            currentMessage = "You can't go in that direction\n";
        else
        {
            currentRoom = nextRoom;
            currentMessage = currentRoom.getLongDescription();
        }     
    }
    //list of items
    public void list () 
    {
        currentMessage = "Items: \n";
        if (bag.size() == 0)
            currentMessage = "You have no items!\n";
        else
            for (Item it : bag)
                currentMessage += (it.getName() + "\n");
    }
    //pickups items
    public void pickup () 
    {
        if (currentRoom.getItem() != null && currentRoom.getItem().getWeight() < 51)
        {
            currentMessage = ("You picked up the " + currentRoom.getItem().getName() + "!\n");
            bag.add(currentRoom.removeItem());
        }
        else if (currentRoom.getItem() != null && currentRoom.getItem().getWeight() >= 51)
            currentMessage = "The " + currentRoom.getItem().getName() + "is too heavy to carry!\n";
        else
            currentMessage = "There is no item in this room.\n";
    }
    //drops items
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
        else if (currentRoom == korriban && currentRoom.getMonsterStatus() == true)
        {
            if (killed < 4)
            {
                currentMessage = "Darth Baras: I see through you Jedi, you can't hide your true self. Now die!\n You barley defeat the sith in battle,killing him and collsape on the from the battle. Your friends take you away to safety.";
                bag.remove(jediHolcron);
            }
            else if (killed >= 4)
            {
                currentMessage = "Jedi Master:I've been watching you and you have fallen to the dark side, if continued to live you will destory the jedi and the republic! \nYou kill the jedi master, his body disppearing as you strike him down.\n";
                bag.remove(sithHolcron);
            }
            bag.remove(medkit);
           
        }else{
            currentMessage = "There's no one to attack!\n";
        }
    }
    //save a target also light side
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
        

        }
        else if (currentRoom == korriban && currentRoom.getMonsterStatus() == true && bag.contains(medkit))
        {
            if (killed < 4)
            {
                currentMessage = "Darth Baras: I see through you Jedi, you can't hide your true self. Now die!\n You barley defeat the sith in battle,killing him and collsape on the from the battle. Your friends take you away to safety.";
                bag.remove(jediHolcron);
            }
            else if (killed >= 4)
            {
                currentMessage= "Jedi Master:I've been watching you and you have fallen to the dark side, if continued to live you will destory the jedi and the republic! \nYou kill the jedi master, his body disppearing as you strike him down.\n";
                bag.remove(sithHolcron);
            }
            bag.remove(medkit);
           
        }
        else
        {
            currentMessage = "There's nothing here.\n";
        }
    }
    
    public boolean gameOver () 
    {
        if (currentRoom == korriban && currentRoom.getMonsterStatus() == false)
        {
            currentMessage = "You travel to the star forge and destory it so the sith empire can not use it. You learn of a unknown threat outside of the galaxy and go in search of it and try to stop it, leaving your friends and allies to rebuild the Republic.:You Win: \n";
            return true;
        }
        else
            return false;
    }
}
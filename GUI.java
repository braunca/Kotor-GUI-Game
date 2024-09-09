import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.text.DefaultCaret;
/*************************************************************
 * allows the game to be created with buttons and text
 * @author Casey Braun
 * @version 4/18/17
 ************************************************************/
public class GUI extends JFrame implements ActionListener{
    /** the analyzer that does all the real work */
    private Game play;
    //define  buttons
    JButton helpButton, pickUpButton, dropButton, eatButton, lookButton, listButton, attackButton, spareButton, northButton, southButton, eastButton, westButton;

    /** Results */
    JTextArea results;
    JLabel Direction; 
    JLabel Actions;    
  
    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem newGame;  
    boolean over;

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Swtor");
        gui.pack();
        gui.setVisible(true);
    }

    
    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public GUI(){
        play = new Game();
        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area to span one column and 11 rows
        results = new JTextArea(40,100);
        JScrollPane scrollPane = new JScrollPane(results);
        loc.gridx = 1;
        loc.gridy = 0;       
        loc.gridheight = 11;  
        loc.insets.top = 5;
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 30;
        add(scrollPane, loc);
        loc = new GridBagConstraints();

         DefaultCaret caret = (DefaultCaret) results.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        //create and display buttons
        helpButton = new JButton("Help"); 
        loc.gridx = 3;
        loc.gridy = 1;
        loc.insets.top = 60;
        add(helpButton, loc);
        loc = new GridBagConstraints();

        pickUpButton = new JButton("Pick Up");
        loc.gridx = 6;
        loc.gridy = 1;
        loc.insets.top = 60;
        add(pickUpButton, loc);
        loc = new GridBagConstraints();

        dropButton = new JButton("Drop");
        loc.gridx = 3;
        loc.gridy = 2;
        add(dropButton, loc);
        loc = new GridBagConstraints();

        eatButton = new JButton("Eat");
        loc.gridx = 6;
        loc.gridy = 2;
        add(eatButton, loc);
        loc = new GridBagConstraints();

        lookButton = new JButton("Look");
        loc.gridx = 3;
        loc.gridy = 3;
        add(lookButton, loc);
        loc = new GridBagConstraints();

        listButton = new JButton("List Items");
        loc.gridx = 6;
        loc.gridy = 3;
        add(listButton, loc);
        loc = new GridBagConstraints();

        attackButton = new JButton("Dark Side");
        loc.gridx = 3;
        loc.gridy = 4;
        add(attackButton, loc);
        loc = new GridBagConstraints();

        spareButton = new JButton("Light Side");
        loc.gridx = 6;
        loc.gridy = 4;
        add(spareButton, loc);
        loc = new GridBagConstraints();

        northButton = new JButton("North");
        loc.gridx = 2;
        loc.gridy = 10;
        add(northButton, loc);

        southButton = new JButton("South");
        loc.gridx = 5;
        loc.gridy = 10;
        add(southButton, loc);

        eastButton = new JButton("East");
        loc.gridx = 4;
        loc.gridy = 10;
        add(eastButton, loc);

        westButton = new JButton("West");
        loc.gridx = 3;
        loc.gridy = 10;
        add(westButton, loc);
        
        
        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newGame = new JMenuItem("New Game");
        fileMenu.add(quitItem);
        fileMenu.add(newGame);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        //register the listeners for the buttons
        helpButton.addActionListener(this);
        pickUpButton.addActionListener(this);
        dropButton.addActionListener(this);
        eatButton.addActionListener(this);
        lookButton.addActionListener(this);
        listButton.addActionListener(this);
        attackButton.addActionListener(this);
        spareButton.addActionListener(this);
        northButton.addActionListener(this);
        southButton.addActionListener(this);
        eastButton.addActionListener(this);
        westButton.addActionListener(this);      
        quitItem.addActionListener(this);
        newGame.addActionListener(this);
     

        results.append(play.getMessage());    
    }
  
     /*****************************************************************
     * @param blocks directions and if game is won all buttons become disabled
     ****************************************************************/  
    public void blocked()
    {
        if (play.checkForBlock() == "taris")
            southButton.setEnabled(false);
        else if (play.checkForBlock() == "dantoonie")
            westButton.setEnabled(false);
        else if (play.checkForBlock() == "")
            eastButton.setEnabled(false);
        else if (play.checkForBlock() == "kashyyyk")
            northButton.setEnabled(false);      
        else if (play.checkForBlock() == "manaan")
            northButton.setEnabled(false);
        else if (play.checkForBlock() == "onderon")
            northButton.setEnabled(false);
        else if (play.checkForBlock() == "llum")
            northButton.setEnabled(false);
           
            else if(play.gameOver() == true)
            {
             //disables buttons if win
            northButton.setEnabled(false);
            southButton.setEnabled(false);
            eastButton.setEnabled(false);
            westButton.setEnabled(false);
            helpButton.setEnabled(false);
            pickUpButton.setEnabled(false);
            dropButton.setEnabled(false);
            eatButton.setEnabled(false);
            lookButton.setEnabled(false);
            listButton.setEnabled(false);
            attackButton.setEnabled(false);
            spareButton.setEnabled(false);
            }
        else 
        {
            northButton.setEnabled(true);
            southButton.setEnabled(true);
            eastButton.setEnabled(true);
            westButton.setEnabled(true);
            helpButton.setEnabled(true);
            pickUpButton.setEnabled(true);
            dropButton.setEnabled(true);
            eatButton.setEnabled(true);
            lookButton.setEnabled(true);
            listButton.setEnabled(true);
            attackButton.setEnabled(true);
            spareButton.setEnabled(true);
        }

    }

    /*****************************************************************
     * This method is called when any button is clicked
     * @param e the event that was clicked
     ****************************************************************/       
    public void actionPerformed(ActionEvent e){
        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();
        if(buttonPressed == helpButton){
           play.help();
            over = play.gameOver();
        }
        else if(buttonPressed == pickUpButton){
            play.pickup();
            over = play.gameOver();
        }
        else if(buttonPressed == dropButton){
            String argument = JOptionPane.showInputDialog ("What will you drop?"); 
            play.drop(argument);
            over = play.gameOver();
        }
        else if(buttonPressed == eatButton){
            String argument = JOptionPane.showInputDialog ("What will you eat?"); 
            play.eat(argument);
            over = play.gameOver();
        }
        else if(buttonPressed == lookButton){
            play.look();
            over = play.gameOver();
        }
        else if(buttonPressed == listButton){
            play.list();
            over = play.gameOver();
        }
        else if(buttonPressed == attackButton){
           play.attackDark();
            over = play.gameOver();
        }
        else if(buttonPressed == spareButton){
            play.spareLight();
            over = play.gameOver();
        }
        else if(buttonPressed == northButton){
            play.move("north");
            over = play.gameOver();
        }
        else  if(buttonPressed == southButton){
            play.move("south");
            over = play.gameOver();
        }
        else if(buttonPressed == eastButton){
            play.move("east");
            over = play.gameOver();
        }
        else if(buttonPressed == quitItem)
        {
            //exit out game if exit is clicked
            System.exit(1);
        }         
         else if(buttonPressed == newGame)
        {
            //starts new game
           play.newGame();
        } 
        else if(buttonPressed == westButton){
            play.move("west");
            over = play.gameOver();
        }
        results.append(play.getMessage());
        blocked();
    }
}

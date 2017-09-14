
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class is used to play the Troll Slayer Game in MULTIPLAYER MODE allowing
 * up to two users to play the game at once. The first player can move to hit
 * and shoot the target by clicking the mouse. Second player can move the target
 * using the up, down, left and right keys on the keyboard.
 * 
 * Make a new JPanel in mp anc call this method into it, put the samebackground
 * you want in this method imagePanel and add all the components.
 * 
 */


public class mp extends JPanel {

    public ImagePanel mp;
    TransparentButton multi = new TransparentButton (""), 
                         sp = new TransparentButton (""), 
                       dino = new TransparentButton (""), 
                       lool = new TransparentButton ("");
    TransparentButtonHandler handlerB = new TransparentButtonHandler ();    
    JButton Start;
    JLabel NameLabel, NameLabel2;
    JTextField Name, Name2;
    static String p1, p2;
    
    
    
    /**
     * Constructor method of multiplayer method mode object class.
     */
    public JPanel mp ()
    {
        multi.setEnabled (true);
        sp.setEnabled (true);

        multi.addActionListener (handlerB);                                             // Adding Buttons to ButtonHandler
        sp.addActionListener (handlerB);
        dino.addActionListener (handlerB);
        lool.addActionListener (handlerB);

        mp = new ImagePanel (new ImageIcon ("Images/multiscreen.jpg").getImage ());        // Setting properties of Main mp Panel  
        mp.setLayout (null);                                                             
        mp.setFocusable (true);
        mp.setOpaque (false);
        mp.setVisible (true);
        
        Start = new JButton ();                                                          // Creating and adding visual components
        Start.addActionListener (handlerB);
       
        
        Start.setText ("Go");                                                            // Displays text on screen
        
        NameLabel = new JLabel();                                                       // Display players' current scores
        NameLabel.setFont(new Font("Sans Serif", Font.BOLD, 12));
        NameLabel.setForeground(Color.WHITE);
        NameLabel.setText ("Player 1: ");
        
        Name = new JTextField ();
       
        NameLabel2 = new JLabel ();
        NameLabel2.setFont(new Font("Sans Serif", Font.BOLD, 12));
        NameLabel2.setForeground(Color.WHITE);
        NameLabel2.setText ("Player 2: ");
        Name2 = new JTextField ();

        addStuff ();                                                                      // adds multiple components onto container
        
        return mp;
    }

    
    /**
     * Adds multiple components onto a container
     * calling addComponenent method.
     */
    private void addStuff()
    {
        addComponent (mp, sp, 25, 275, 320, 52);
        addComponent (mp, multi , 95, 350, 320, 52);
    }

    
    /**
     * Adds a specified component onto a container object at 
     * a set of co-ordinates and dimensions.
     * 
     * @param Container container object componenent is added to
     * @param int x x co-ordinate
     * @param int y y co-ordinate
     * @param int width width of component being added
     * @param int height height of component being added
     */
    private void addComponent(Container container,Component c,int x,int y,int width,int height) 
    { 
        c.setBounds (x, y, width, height);
        container.add (c);
    } 
    
        
    /**
     * This class handles the events by the buttons. It executes 
     * the appropriate code based on the utton clicked
     */

    private  class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            if (event.getSource () == multi)                                                         // Play button is Pressed, execute  
            {
                mp.removeAll ();
                mp.revalidate ();
                mp.update (new ImageIcon ("Images/mainScreen_bgMP2.jpg").getImage());
                
                addComponent (mp, NameLabel, 300,190,100,28);                                         //  adds components onto mp container
                addComponent (mp, Name, 350,190,100,28);
                addComponent (mp, NameLabel2, 300,300,100,28);
                addComponent (mp, Name2, 350,300,100,28);
                addComponent (mp, Start, 450,245,60,28);
                
                mp.updateUI ();
                Menu.mp = true;
                repaint ();
            }

            else if (event.getSource () == sp)                                                        // If the mp button (multiplayer) is pressed, execute
            {
                mp.removeAll ();
                mp.revalidate ();
                mp.update (new ImageIcon ("Images/mainScreen_bgMP.jpg").getImage());
                addComponent (mp, NameLabel, 300,190,100,28);
                addComponent (mp, Name, 350,190,100,28);
                addComponent (mp, Start, 450,245,60,28);
                mp.updateUI ();
                Menu.mp = false;
                repaint ();
            }
            
            else if (event.getSource () == Start)                                                     // If Start button is pressed, execute a game round
            {
                if (Name.getText().equals("") || Name2.getText().equals("") && Menu.mp == false) {}
                else{
                    p1 = Name.getText ();
                    p2 = Name2.getText ();
                    
                    mp.removeAll ();
                    mp.revalidate ();
                    
                    JPanel game = new Game();
                    
                    addComponent (mp, game , 0,0,800,600);
                    Menu.count.start ();
                    
                    game.setFocusable (true);
                    game.requestFocusInWindow ();
                }
                
                if (Name.getText().equals("") && Menu.mp == true) {}
                else{
                    p1 = Name.getText ();
                    
                    mp.removeAll ();
                    mp.revalidate ();
                    
                    JPanel game = new Game ();
                    
                    addComponent(mp, game, 0, 0, 800, 600);
                    
                    Menu.count.start ();
                    
                    game.setFocusable (true);
                    game.requestFocusInWindow ();
                }
            }
        
        }
    }
    
    
}
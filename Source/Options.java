import  sun.audio.*;    
import  java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class constructs an Options menu screen in which the user can set
 * and switch the target character within the game.
 */


public class Options extends JPanel {
    public ImagePanel options;
    public static String image= "Images/troll1.gif";
    
    TransparentButton troll = new TransparentButton (""), 
                        fly = new TransparentButton (""), 
                       dino = new TransparentButton (""), 
                       lool = new TransparentButton ("");
    TransparentButtonHandler handlerB = new TransparentButtonHandler (); 

    private String background;
    JLabel trolL, flY, dinO, looL , aK, Mouse, character, player1, player2;
    
    
    
    /**
     * Constructs the Options menu screen with visual components
     * and functionality added to each.
     */
    public JPanel Options ()
    {
        troll.setEnabled (true);
        fly.setEnabled (true);
        dino.setEnabled (true);
        lool.setEnabled (true);

        troll.addActionListener (handlerB);                                             // Adding Buttons to ButtonHandler
        fly.addActionListener (handlerB);
        dino.addActionListener (handlerB);
        lool.addActionListener (handlerB);
        
        ImageIcon troll1 = new ImageIcon ("Images/troll100.gif");
        ImageIcon fly1 = new ImageIcon ("Images/fly100.gif");
        ImageIcon dino1 = new ImageIcon ("Images/niptor.gif");
        ImageIcon lool1 = new ImageIcon ("Images/dance100.gif");
        ImageIcon ak = new ImageIcon ("Images/ak.png");
        ImageIcon mouse = new ImageIcon ("Images/mouse.png");

        trolL = new JLabel (troll1);
        flY = new JLabel (fly1);
        dinO = new JLabel (dino1);
        looL = new JLabel (lool1);
        aK = new JLabel (ak);
        Mouse = new JLabel (mouse);
        player1 = new JLabel ("Player 1");
        player2 = new JLabel ("Player 2");
        character = new JLabel ("Choose a character, then press play:");

        background = "Images/mainScreen_bg2.jpg";                                         // Setting properties of Main options Panel  
        options = new ImagePanel (new ImageIcon(background).getImage());
        options.setLayout (null);
        options.setFocusable (true);
        options.setOpaque (false);
        options.setVisible (true);
        
        addStuff ();                                                                      // adding componene
        
        return options;
    }

    /**
     * Adds multiple components onto a container
     * calling addComponenent method.
     */
    private void addStuff ()
    { 
        addComponent (options, character, 20, 50, 300, 20);
        addComponent (options, troll, 30, 95, 100, 100);
        addComponent (options, fly, 209 , 95, 100, 100);
        addComponent (options, dino, 585, 95, 100, 100);
        addComponent (options, lool, 393 , 95, 100, 100);
        addComponent (options, trolL, 30, 95, 100, 100);
        addComponent (options, flY, 209, 95, 100, 100);
        addComponent (options, dinO, 585, 95, 100, 100);
        addComponent (options, looL, 393, 95, 100, 100);
        addComponent (options, player2, 400, 250, 300, 20);
        addComponent (options, aK, 400 ,250, 300, 198);
        addComponent (options, player1, 20, 250, 200, 20);
        addComponent (options, Mouse, 30, 250, 200, 200);
    }

    /**
     * Adds multiple components onto a container
     * calling addComponenent method.
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
            if (event.getSource () == troll)                                            // Play Button is Pressed, Execute
            {
                image = "Images/troll1.gif";
                try {
                    InputStream in = new FileInputStream ("Audio/not.wav");
                    AudioStream as = new AudioStream (in);
                    AudioPlayer.player.start (as); 
                }catch (Exception lol) {}
            }

            else if (event.getSource () == fly)                                          // If the Options Buttons is Pressed, Execute
            {
                image = "Images/fly.gif";
                try {
                    InputStream in = new FileInputStream("Audio/not.wav");
                    AudioStream as = new AudioStream(in);
                    AudioPlayer.player.start(as); 
                } 
                catch (Exception lol) {}
            }

            else if (event.getSource () == dino)                                         // If the Exit Button is Pressed
            {
                image = "Images/niptor.gif";
                try {
                    InputStream in = new FileInputStream("Audio/not.wav");
                    AudioStream as = new AudioStream(in);
                    AudioPlayer.player.start(as); 
                }
                catch (Exception lol) {}
            }

            else if (event.getSource () == lool)                                         // If The Experts Button is Pressed
            {
                image = "Images/dance1.gif";
                try {
                    InputStream in = new FileInputStream("Audio/not.wav");
                    AudioStream as = new AudioStream(in);
                    AudioPlayer.player.start(as); 
                }
                catch (Exception lol) {}
            }
        }
    }
}
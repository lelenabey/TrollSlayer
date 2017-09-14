import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Menu extends JPanel {
    public ImagePanel menu;
    public JPanel canvas;
    static public int t = 30;
    static public Timer count;
    TransparentButtonHandler handlerB = new TransparentButtonHandler (); 
    TransparentButton playB = new TransparentButton (""), 
                   optionsB = new TransparentButton ("                                                 "), 
                      exitB = new TransparentButton ("                                                   "), 
                     scoreB = new TransparentButton ("                                                  ");
    boolean ingame = false;
    static public boolean mp = false;
    static JLabel playL = new JLabel ("Play"), 
               optionsL = new JLabel ("Options"), 
                  exitL = new JLabel ("Exit"), 
               expertsL = new JLabel ("About the Experts");
    private String background;
    public BorderLayout layout = new BorderLayout();                                    // Layout type of the GUI
    ScoreManager scr = new ScoreManager();

    
    /**
     * Menu object constructor class
     * 
     * @return Menu
     */
    public JPanel Menu ()
    {
        playB.setEnabled (true);                                                            // Enable buttons
        optionsB.setEnabled (true);
        exitB.setEnabled (true);
        scoreB.setEnabled (true);

        playB.addActionListener (handlerB);                                                 // Adding Buttons to ButtonHandler
        optionsB.addActionListener (handlerB);
        exitB.addActionListener (handlerB);
        scoreB.addActionListener (handlerB);

        background = "Images/mainScreen_bg copy.jpg";                                       // Setting properties of main Menu Panel
        menu = new ImagePanel(new ImageIcon(background).getImage());
        canvas = new JPanel();

        canvas.setLayout (layout);
        canvas.setVisible (true);
        canvas.setFocusable (true);

        menu.setOpaque (false);
        menu.setVisible (true);

        addStuff ();                                                                         // Adding Components (Buttons and Labels) to ImagePanel
        addComponent (canvas,menu,0,0,800,600);

        count = new Timer (1000, time);

        return canvas;                                                                      // Return statement
    }

    /**
     * Method for adding specified components onto a container object
     * of the GUI menus for the game program.
     */
    private void addStuff()
    { 
        addComponent (canvas, playB, 10, 525, 178, 52);
        addComponent (canvas, optionsB, 189, 525, 178, 52);
        addComponent (canvas, exitB, 567, 525, 178, 52);
        addComponent (canvas, scoreB, 378, 525, 178, 52);
    }

    /**
     * Adds a specified component onto a container object at 
     * a set of co-ordinates and dimensions.
     * 
     * @param Container container   Container that a Component is added to
     * @param int x                 An x co-ordinate
     * @param int y                 A y co-ordinate
     * @param int width             Width of component being added to container
     * @param int height            Height of component being added to container
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
    ActionListener time = new ActionListener () {
            public void actionPerformed (ActionEvent evt) {
                t--;
                if ( t<= -5)
                {
                    canvas.removeAll ();
                    canvas.revalidate ();

                    addStuff ();
                    addComponent (canvas, menu, 0, 0, 800, 600);

                    repaint ();

                    count.stop ();
                    
                    t = 30;
                    try {
                        scr.write ();
                    }
                    catch (Exception lol) {}
                }
            }
        };
   
    /**
     * This class handles the events by the buttons. Executes the appropriate code based on the button clicked
     */    
    private  class TransparentButtonHandler implements ActionListener 
    {
        public void actionPerformed (ActionEvent event) 
        {       
            
            if (event.getSource () == playB)                                            // Play Button is Pressed, Execute
            {
                canvas.removeAll ();
                canvas.revalidate ();
                
                mp mp = new mp();
                
                addComponent (canvas, mp.mp (), 0, 0, 800, 600);
                
                repaint();
            }

            else if (event.getSource () == optionsB)                                    // If the Options buttons is pressed, execute
            {
                canvas.removeAll ();
                canvas.revalidate ();
                
                Options options = new Options();
               
                addStuff ();
                addComponent (canvas,options.Options (), 0, 0, 800, 600);

                repaint ();
            }

            else if (event.getSource () == exitB)                                        // If the Exit button is pressed
            {
                menu.update (new ImageIcon ("Images/mainScreen_bg4.jpg").getImage());
                menu.updateUI ();
                
                System.exit (0);                                                         // Exit Game
            }
           
            else if (event.getSource () == scoreB)                                       // If The Experts button is pressed
            {
                canvas.removeAll ();
                canvas.revalidate ();
                
                Score score = new Score ();
                
                addStuff ();
                addComponent (canvas,score.Score (), 0, 0, 800, 600);
                
                repaint ();
            }
        }
    }
}
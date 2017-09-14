import java.io.*;
import javax.swing.JFrame;
import sun.audio.*;

/**
 * This class constructs a Troll Slayer game object, to begin
 * running the entire application for playing and viewing.
 */
public class TrollSlayer extends JFrame {
    /**
     * Creates new Troll Slayer game object.
     */
    public TrollSlayer () {
        Menu menu = new Menu();                                                 // creates new menu object that acts as a main screen that can
                                                                                // access multiple other menus within the game
        add(menu.Menu());                                                       

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setTitle ("Troll Slayer");                                               // sets properties of JFrame
        setSize (800, 600);
        setLocationRelativeTo (null);
        setResizable (false);
        setVisible (true);
    }

    
    /**
     * Calls for a new instance of Troll Slayer object.
     * 
     * @param String[]args 
     */
    public static void main (String[] args)throws IOException {
        TrollSlayer game = new TrollSlayer ();
    }
} 
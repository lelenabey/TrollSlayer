import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 * This class is a JPanel that displays the top ranking players with the best 5
 * scores in the game Troll Slayer.
 */


public class Score extends JPanel {
    public ImagePanel score;
    private String background;
    static public JTable Highscore;

    /**
     * Constructor method for Score class.
     */
    public JPanel Score ()
    {
        Highscore = new JTable(6,2);                            // Adding Buttons to ButtonHandler
        
        background = "Images/mainScreen_bg32.jpg";               // Setting properties of Main score Panel  
        score = new ImagePanel (new ImageIcon(background).getImage());
        
        score.setLayout (null);
        score.setFocusable(true);
        score.setOpaque (false);
        score.setVisible (true);
        
        addStuff();                                     // Adding Components (Buttons and Labels) to ImagePanel
                                                        
        return score;
    }

    /**
     * Method for adding specified components onto a container object
     * of the GUI menus for the game program.
     */
    private void addStuff()
    { 
        Highscore.setRowHeight(45);
        Highscore.setValueAt("Name",0,0);
        Highscore.setValueAt("Score",0,1);
        
        ScoreManager print = new ScoreManager();
        
        try{
            print.read ();
        }
        catch (Exception lol){}
        
        Highscore.setAutoCreateRowSorter(true);
        
        addComponent(score, Highscore, 125, 75, 400, 260);
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
// 
//     public void read() throws IOException
//     {
//         int line=0;
//         String ScoreTab[][] = new String [line][2];
//          
//         BufferedReader in = new BufferedReader (new FileReader ("H_Score.txt"));
//         BufferedReader in2 = new BufferedReader (new FileReader ("H_Name.txt"));
//         
//         while(in.readLine()!=null && in2.readLine()!=null)
//         {
//             line++;
//         }
//         
//         in.close();
//         in2.close();
// 
//         String names[] = new String[line];
//         String scores[] = new String[line];
// 
//         BufferedReader in3 = new BufferedReader (new FileReader ("H_Score.txt"));
//         BufferedReader in4 = new BufferedReader (new FileReader ("H_Name.txt"));
//         
//         for(int x=0;x<line;x++)
//         {               
//             scores[x] = in3.readLine();
//             names[x]=in4.readLine();
//         }
//         
//         in3.close();
//         in4.close();
//         
//         for(int z=0;z<line;z++)
//         {               
//             ScoreTab[z][0] = names[z];
//             ScoreTab[z][1] = scores[z];
//         }
// 
//         for (int i=0;i<line-1;++i)                                   
//         {
//             for (int j=0;j<=line-2;++j)
//             {
// 
//                 int value1 = Integer.parseInt(ScoreTab[j][1]);
//                 int value2 = Integer.parseInt(ScoreTab[j+1][1]);
//                 if (value1<value2)
// 
//                 {
//                     for (int x=0; x<=3; x++)
//                     {
//                         String temp = ScoreTab[j][x];
//                         ScoreTab[j][x]=ScoreTab[j+1][x];
//                         ScoreTab[j+1][x]=temp;
//                     }
//                 }
//             }
//         }
// 
//         for(int z=0;z<line;z++)
//         {  
//             System.out.println(ScoreTab[z][0] + " " + ScoreTab[z][1]);
//             Highscore.setValueAt(ScoreTab[z][0],z+1,0);
//             Highscore.setValueAt(ScoreTab[z][1],z+1,1); 
//         }
//     }
}
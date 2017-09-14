import java.io.*;
import java.util.*;

public class ScoreManager
{
    public void write()throws IOException
    {
        PrintWriter out = new PrintWriter ( new FileWriter ("Player/Name.txt",true));
        PrintWriter out2 = new PrintWriter ( new FileWriter ("Player/Score.txt",true));
        if(Menu.mp==true)
        {
            out.println(mp.p1);
            out2.println(Game.score);
            out.println(mp.p2);
            out2.println(Game.score2);
        }
        else{
            out.println(mp.p1);
            out2.println(Game.score);
        }
        out.close();
        out2.close();
    }


    public void read() throws IOException
    {
        BufferedReader in = new BufferedReader (new FileReader ("Player/Score.txt"));
        BufferedReader in2 = new BufferedReader (new FileReader ("Player/Name.txt"));
        int line=0;
        while(in.readLine()!=null && in2.readLine()!=null)
        {
            line++;
        }
        in.close();
        in2.close();

        String names[] = new String[line];
        String scores[] = new String[line];

        BufferedReader in3 = new BufferedReader (new FileReader ("Player/Score.txt"));
        BufferedReader in4 = new BufferedReader (new FileReader ("Player/Name.txt"));
        for(int x=0;x<line;x++)
        {               
            scores[x] = in3.readLine();
            names[x]=in4.readLine();
        }
        in3.close();
        in4.close();

        String ScoreTab[][] = new String [line][line];
        for(int z=0;z<line;z++)
        {               
            ScoreTab[z][0] = names[z];
            ScoreTab[z][1] = scores[z];
        }

        for (int i=0;i<line-1;++i)                                   
        {
            for (int j=0;j<=line-2;++j)
            {
                int value1 = Integer.parseInt(ScoreTab[j][1]);
                int value2 = Integer.parseInt(ScoreTab[j+1][1]);
                if (value1<value2)
                {
                    for (int x=0; x<2; x++)
                    {
                        String temp = ScoreTab[j][x];
                        ScoreTab[j][x]=ScoreTab[j+1][x];
                        ScoreTab[j+1][x]=temp;
                    }
                }
            }
        }

        for(int z=0;z<line;z++)
        {  
            Score.Highscore.setValueAt(ScoreTab[z][0],z+1,0);
            Score.Highscore.setValueAt(ScoreTab[z][1],z+1,1); 
        }

    }
}

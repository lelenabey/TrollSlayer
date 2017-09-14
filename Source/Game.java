import java.awt.*; import java.awt.event.*; import java.io.*; import javax.swing.*; import sun.audio.*;    
public class Game extends JPanel implements ActionListener,MouseMotionListener,MouseListener {
    private final int WIDTH = 800, HEIGHT = 600, RAND_POS = 500;
    private int DELAY = 40, x = 200, y = 200, dots, cx , sc = 10, cy, type, DOT_SIZE = 20;
    static int score =0 , score2 = 0;
    private String scoreDisplay , msg;
    private boolean left = false, down = false, right = false, up = false;
    final Point hotspot = new Point(0, 0);
    private Timer timer;
    private Image Target, troll, infoBar;
    private AudioStream as;
    public Game() {
        addKeyListener (new TAdapter ());
        setBackground (Color.white);
        Toolkit tool = Toolkit.getDefaultToolkit ();
        ImageIcon iia = new ImageIcon (this.getClass ().getResource ("Images/crosshair.png"));
        Target = iia.getImage ();
        troll = tool.getImage (Options.image);
        this.setCursor (getToolkit ().createCustomCursor (Target, hotspot, "lol"));
        setFocusable (true);
        addMouseMotionListener (this);
        addMouseListener (this);
        initGame ();
    }    

    public void initGame () {
        locateTarget ();
        timer = new Timer (DELAY, this);
        timer.start ();
    }

    public void paint (Graphics g) {
        super.paint (g);
        if (Menu.t>0) {
            if (Menu.mp == true){
                scoreDisplay = mp.p1+"'s Score: " + score + "        " + mp.p2 + "'s Score: " + score2 + "       Time: " + Menu.t;
            }
            else {
                scoreDisplay = "Score: " + score + "    Time: " + Menu.t;
            }
            Font small = new Font ("Helvetica", Font.BOLD, 14);
            FontMetrics metr = this.getFontMetrics (small);
            g.setColor (Color.black);
            g.setFont (small);
            g.drawString (scoreDisplay, (3),11);
            g.drawImage (troll, x, y, 100, 100, this);
            Toolkit.getDefaultToolkit ().sync();
            g.dispose ();
        } 
        else {gameOver (g); }
    }

    public void gameOver (Graphics g) {
        if (Menu.mp == true){ msg = "Game Over, " + mp.p1 + "'s Score: " + score + "  " + mp.p2 + "'s Score: " + score2;       }
        else { msg = "Game Over, Score: " + score; }
        Font small = new Font ("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics (small);
        g.drawImage (troll, (WIDTH - metr.stringWidth (msg))/ 2, HEIGHT/ 2, 400, 400, this);
        g.setColor (Color.black);
        g.setFont (small);
        g.drawString (msg, (WIDTH - metr.stringWidth (msg))/ 2,HEIGHT/ 2);   
    }

    public void checkTarget () {
        if ((cx >= x) && (cy >= y)&&(cx <= x+100) && (cy <= y+100)) {
            locateTarget();
            score+=10;
            DELAY-=5;
            DOT_SIZE+=2;
            try{
                InputStream in = new FileInputStream("Audio/raygun.wav");
                as = new AudioStream(in);
                AudioPlayer.player.start(as); 
            }catch(Exception lol){}
        }
        else { score2 += sc; }
    }

    public void move() {
        if (left)  {    
            x -= DOT_SIZE;   }
        if (right) {    
            x += DOT_SIZE;   }
        if (up)    {    
            y -= DOT_SIZE;   }
        if (down)  {    
            y += DOT_SIZE;   }
    }

    public void checkCollision() {
        if (y > HEIGHT-100) {
            down= false; up = true; 
        }
        if (y < 0) {
            up = false; down= true; 
        }
        if (x > WIDTH-100) {
            right= false; left = true; 
        }
        if (x < 0) {
            left= false; right = true; 
        }
    }

    public void locateTarget () {
        int r = (int) (Math.random() * RAND_POS); 
        x = r;
        r = (int) (Math.random() * RAND_POS);
        y = r;
    }

    public void actionPerformed(ActionEvent e) {
        if (Menu.t > 0) {
            checkCollision();
            move();
        }
        repaint();
    }

    public void mouseMoved(MouseEvent e) {
        cx = e.getX();
        cy = e.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent e) {  
        checkTarget();
        sc = 1;
    }

    public void mouseClicked(MouseEvent f) {
        checkTarget();
        sc = 10;
        changedir();
    }

    public void changedir() {
        int rnd = (int) (1+Math.random() * 4);
        if(rnd ==1 && Menu.mp== false){
            left = true;
            up = false;
            down = false;
            right = false;
        }
        else if(rnd ==2 && Menu.mp== false)
        {
            right = true;
            up = false;
            down = false;
            left = false;
        }
        else if(rnd ==3 && Menu.mp== false)
        {
            up = true;
            right = false;
            left = false;
            down = false;
        }
        else if(rnd ==4 && Menu.mp== false)
        {
            down = true;
            right = false;
            left = false;
            up = false;
        }
    }

    public void mouseExited(MouseEvent e)   {  
        Menu.count.stop();  }

    public void mouseEntered(MouseEvent f)  {  
        Menu.count.start();   }

    public void mousePressed(MouseEvent f)  {}

    public void mouseReleased(MouseEvent f) {}
    private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && Menu.mp== true) {
                left = true;
                up = false;
                down = false;
                right = false;
            }
            if ((key == KeyEvent.VK_RIGHT)&& Menu.mp== true ) {
                right = true;
                up = false;
                down = false;
                left = false;
            }
            if ((key == KeyEvent.VK_UP)&& Menu.mp== true ) {
                up = true;
                right = false;
                left = false;
                down = false;
            }
            if ((key == KeyEvent.VK_DOWN)&& Menu.mp== true) {
                down = true;
                right = false;
                left = false;
                up = false;
            }
        }

        public void keyReleased (KeyEvent e) { 
            right = false;
            left = false;
            up = false;
            down = false;
        }
    }
}
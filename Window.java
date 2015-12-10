
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Window extends JPanel implements ActionListener,KeyListener
{   
    BufferedImage sub; 
    
    public Window()
    {
        
       
        
        setPreferredSize(new Dimension(800,600));
        
        setBackground(Color.white);
        JFrame frame = new JFrame("SubFill");      
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        
        try {
            File sumF = new File("EmptySub.png");
            if(sumF != null)
                System.out.println("file works");
            sub = ImageIO.read(sumF);
        } catch (Exception e) {
            System.out.println("ff");
            e.printStackTrace();
        }
   
        Timer t = new Timer(5, this);
        t.start();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }
    
    public void update()
    {
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
        
        g.setColor(Color.CYAN.darker());
        g.fillRect(147, 110, 49, 20);
        g.fillRect(197, 110, 65, 20);
        g.fillRect(197, 131, 65, 18);
        g.fillRect(263, 131, 68, 18);
        g.fillRect(263, 110, 68, 20);
         if(sub != null)
        {
            g.drawImage(sub,0,0,null);
        }
        update();
    }

    public void keyTyped(KeyEvent input) {
        char key = input.getKeyChar();
        if (key == 27) System.exit(0);
        
        
    }
     
    public void keyPressed(KeyEvent key) {
        process(key.getKeyCode(), true); 
    }

    public void keyReleased(KeyEvent key) {
        
    }
    
    public void process(int keycode, boolean pressed)
    {       
    }
    
    public void draw(Graphics g)
    {
       
    }
    
    public void mouseMoved(MouseEvent mouse)
    {
       
    }
    
    public static void main(String[] args)
    {
        new Window();
    }
}
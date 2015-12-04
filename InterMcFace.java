import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class InterMcFace extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{   

    WeaponInterface Wep = new WeaponInterface();
    Ship shp = new Ship(100,100);
    Radar radar = new Radar(shp,659,437);
    BufferedImage img = null;
    public InterMcFace()
    {
        setPreferredSize(new Dimension(1920,1080));
        
        setBackground(Color.BLUE.darker());
        
        JFrame frame = new JFrame("InterMcFramealoo");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setUndecorated(true);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
       
        try {
            img = ImageIO.read(new File("InterfaceLayout.png"));
        } catch (Exception e) {
        }
        
        Timer t = new Timer(5, this);
        t.start();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }
    
    public void mouseClicked(MouseEvent mouse) 
    {
        
    }

    public void mousePressed(MouseEvent mouse) {}

    public void mouseReleased(MouseEvent mouse) 
    {
        Point m = mouse.getPoint();
        System.out.println(m.getX() + ", " + m.getY());
        if(radar.getBounds().contains(m))
        {
            radar.click(m.x,m.y);
        }
        repaint();
    }

    public void mouseEntered(MouseEvent mouse) {}

    public void mouseExited(MouseEvent mouse) {}

    public void mouseDragged(MouseEvent mouse) {}
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g)
    {
        g.drawImage(img,0,0,null);
        g.drawImage(radar.getImage(), 659, 437, null);
        //g.setColor(Color.GREEN.darker());
        //g.drawRect(659, 437, 600, 600);
        //g.drawImage(Wep.getImage(), 20, 350, null);
        
    }
    
    public void mouseMoved(MouseEvent mouse)
    {
       
    }
    
    public static void main(String[] args)
    {
        new InterMcFace();
    }
}
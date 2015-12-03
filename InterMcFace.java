import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class InterMcFace extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{   
<<<<<<< HEAD
    MapInterface Map = new MapInterface();
    WeaponInterface Wep = new WeaponInterface();
=======
    Ship shp = new Ship(100,100);
    MapInterface Map = new MapInterface(shp);
>>>>>>> df2304e5838f904672622a8a39ebb80f559eb704
    public InterMcFace()
    {
        setPreferredSize(new Dimension(1920,1080));
        
        setBackground(Color.BLUE.darker());
        
        JFrame frame = new JFrame("InterMcFramealoo");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setUndecorated(true);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
       
        
        Timer t = new Timer(5, this);
        t.start();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }
    
    public void mouseClicked(MouseEvent mouse) 
    {
        Point m = mouse.getPoint();
        if((m.getX() > 660 && m.getX() < 600+660 && m.getY() > 350 && m.getY() < 600+350)){
            Map.Clicked(mouse);
        }
        return;
    }

    public void mousePressed(MouseEvent mouse) {}

    public void mouseReleased(MouseEvent mouse) {}

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
        g.drawImage(Map.getImage(), 660, 350, null);
        g.drawImage(Wep.getImage(), 20, 350, null);
    }
    
    public void mouseMoved(MouseEvent mouse)
    {
       
    }
    
    public static void main(String[] args)
    {
        new InterMcFace();
    }
}
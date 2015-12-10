package SubFill;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;

public class Window extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener
{
    BufferedImage img = null;

    public Window()
    {
        setPreferredSize(new Dimension(800,600));

        setBackground(Color.BLUE.darker());

        JFrame frame = new JFrame("ghc");
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setUndecorated(true);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);

        try {
            img = ImageIO.read(new File("EmptySub.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Timer t = new Timer(5, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae)
    {
        repaint();
    }

    public void mouseClicked(MouseEvent mouse){}

    public void mousePressed(MouseEvent mouse) {}

    public void mouseReleased(MouseEvent mouse){}

    public void mouseEntered(MouseEvent mouse) {}

    public void mouseExited(MouseEvent mouse) {}

    public void mouseDragged(MouseEvent mouse) {}

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

    public void keyTyped(KeyEvent input) {
        char key = input.getKeyChar();
        if (key == 27) System.exit(0);
    }

    public void keyPressed(KeyEvent txt) {}

    public void keyReleased(KeyEvent txt) {}

    public void draw(Graphics g)
    {
        g.drawImage(img,0,0,null);
    }

    public void mouseMoved(MouseEvent mouse){}

    public static void main(String[] args)
    {
        new Window();
    } 
}

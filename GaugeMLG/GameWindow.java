import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JPanel implements ActionListener, KeyListener
{   
    int value = 0;
    int angle = 270;
    int difx;
    int dify;
    
    boolean up = false;
    boolean down = false;
    public GameWindow()
    {
        setPreferredSize(new Dimension(800,600));
        setBackground(Color.GRAY);
        
        JFrame frame = new JFrame("a frame");
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        addKeyListener(this);
        
        
        
        
        Timer t = new Timer(5, this);
        t.start();
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        update();
        repaint();
        
    }
    
    public void update()
    {
        value+=5;
        if(value>360)value=0;
        //System.out.println(value);
        difx = (int)(Math.cos((Math.toRadians((angle-value))))*170);
        dify = (int)(Math.sin((Math.toRadians((angle-value))))*170);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(200,100,400,400);
        
        g.setColor(Color.GRAY.darker());
        g.fillOval(205,105,390,390);
        
        g.setColor(Color.BLACK);
        System.out.println(difx);
        g.drawLine(400,300,400+difx,130-dify+170);
    }
    
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        char c = e.getKeyChar();
    }
    public void keyTyped(KeyEvent e){}
    
    
    public static void main(String[] args)
    {
        new GameWindow();
    }
}
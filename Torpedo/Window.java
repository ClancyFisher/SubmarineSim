package Torpedo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class Window extends JPanel implements ActionListener,KeyListener
{   
    
    
    Ship ship = new Ship();
    
    double sx = 100, sy = 100;
    double vx = .1, vy = 0;
    
    double txone = 400 , tyone = 300 , txtwo = 400, tytwo = 305;
    double txone2 = 400 , tyone2 = 300 , txtwo2 = 400, tytwo2 = 305;
    double txone3 = 400 , tyone3 = 300 , txtwo3 = 400, tytwo3 = 305;
    double txone4 = 400 , tyone4 = 300 , txtwo4 = 400, tytwo4 = 305;
    
    boolean torp = false;
    
  
    boolean hit = false;
    
    boolean[] keys = new boolean[5];
    static final int ONE = 1;
    static final int TWO = 2;
    static final int THREE = 3;
    static final int FOUR = 4;
    
    public Window()
    {
        
       
        
        setPreferredSize(new Dimension(800,600));
        
        setBackground(Color.BLUE.darker());
        JFrame frame = new JFrame("Torpedo");      
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(this);
        
   
        Timer t = new Timer(5, this);
        t.start();
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        repaint();
    }
    public void update()
    {
        
        
        sx += vx;
        sy += vy;
        
      
       
        if(keys[ONE]) 
        {
            tyone -= .1;
            tytwo -= .1;
        
        } 
        
        if(keys[TWO]) 
        {
            tyone2 -= .1;
            tytwo2 -= .1;
        
        } 
        
        if(keys[THREE]) 
        {
            tyone3 -= .1;
            tytwo3 -= .1;
        
        } 
        
        if(keys[FOUR]) 
        {
            tyone4 -= .1;
            tytwo4 -= .1;
        
        } 
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
        
        
        
        
        if(keys[ONE]) 
        {
            g.setColor(Color.GREEN);
            g.drawLine((int)txone, (int)tyone, (int)txtwo, (int)tytwo);
            System.out.println("Fired Tube One");
        }
        
        if(keys[TWO]) 
        {
            g.setColor(Color.GREEN);
            g.drawLine((int)txone2, (int)tyone2, (int)txtwo2, (int)tytwo2);
            System.out.println("Fired Tube Two");
        }
        
        if(keys[THREE]) 
        {
            g.setColor(Color.GREEN);
            g.drawLine((int)txone3, (int)tyone3, (int)txtwo3, (int)tytwo3);
            System.out.println("Fired Tube Three");
        }
        
        if(keys[FOUR]) 
        {
            g.setColor(Color.GREEN);
            g.drawLine((int)txone4, (int)tyone4, (int)txtwo4, (int)tytwo4);
            System.out.println("Fired Tube Four");
        }
        
        if (tytwo < 110)
        {
            if(tytwo > 100){
                if(txtwo > (int)sx && txtwo < (int)sx + 20){
                    g.setColor(Color.BLUE.darker());
                    System.out.println("HIT");
                    hit = true;
                }
            }
        }
        
        if (tytwo2 < 110)
        {
            if(tytwo2 > 100){
                if(txtwo2 > (int)sx && txtwo2 < (int)sx + 20){
                    g.setColor(Color.BLUE.darker());
                    System.out.println("HIT");
                    hit = true;
                }
            }
        }
        
        if (tytwo3 < 110)
        {
            if(tytwo3 > 100){
                if(txtwo3 > (int)sx && txtwo3 < (int)sx + 20){
                    g.setColor(Color.BLUE.darker());
                    System.out.println("HIT");
                    hit = true;
                }
            }
        }
        
        if (tytwo4 < 110)
        {
            if(tytwo4 > 100){
                if(txtwo4 > (int)sx && txtwo4 < (int)sx + 20){
                    g.setColor(Color.BLUE.darker());
                    
                    System.out.println("HIT");
                    hit = true;
                }
            }
        }
        
        
        if(!hit){
            ship.drawShip(g, (int)sx, (int)sy);
        }
        
        if(hit){
            g.setColor(Color.WHITE);
            g.fillOval(385, 100, 30, 30);
        }
        //System.out.println(sy);
        g.setColor(Color.GREEN);
        g.fillOval(395, 295, 10, 10);
        g.setColor(Color.BLACK);
       
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
        switch(keycode)
        {
            case 49:
            keys[ONE] = pressed;
            break;
            case 50:
            keys[TWO] = pressed;
            break;
            case 51:
            keys[THREE] = pressed;
            break;
            case 52:
            keys[FOUR] = pressed;
            break;
        }
    }
    public void draw(Graphics g){}
    public void mouseMoved(MouseEvent mouse)
    {
       
    }
    
    public static void main(String[] args)
    {
        new Window();
    }
}
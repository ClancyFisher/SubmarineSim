package Torpedo;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Ship
{
    
    public Ship()
    { 
    }  
    
    public void drawShip(Graphics g, int sx, int sy){
        g.setColor(Color.RED);
        g.fillRect(sx, sy, 20, 10);
    }
    public void update(int sy)
    {
        
    }
}
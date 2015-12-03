import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.awt.event.*;
public class WeaponInterface{
    
    public WeaponInterface(){
       
    }
    public BufferedImage getImage(){
        BufferedImage image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK.brighter());
        g.fillRect(0,0,600,600);
        return image;
    }
    public void DragonWithAids(MouseEvent mouse)
    {
        System.out.println(mouse.getPoint());
        
    }   
   
}
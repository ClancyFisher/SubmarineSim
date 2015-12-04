import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class MapInterface
{
    Ship shp;
    
    Point mouse = new Point();
    Radar radar;
    
    public MapInterface(Ship shp){
        this.shp = shp;
        things.add(t);
        things.add(h);
        radar = new Radar(shp, things, 660, 437);
    }
    public void Clicked(MouseEvent e){
        radar.click(e.getX(), e.getY());
        
    }
    public BufferedImage getImage(){
        BufferedImage image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        
        radar.render(g);
        return image;
    }
}
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class MapInterface
{
    Thing t = new Thing(400,400);
    Thing h = new Thing(250,300);
    ArrayList<Thing> things = new ArrayList<Thing>();
    Point mouse = new Point();
    int shipX = 150;
    int shipY = 0;
    public MapInterface(){
        things.add(t);
        things.add(h);
    }
    public void Clicked(MouseEvent e){
        int x = (int)Math.round(e.getPoint().getX()) - 660 - shipX;
        int y = (int)Math.round(e.getPoint().getY()) - 380 - shipY;
        Point alpha = new Point(x,y);
        mouse = alpha;
        for(Thing h : things){
            Point beta = h.getPoint();
            double distX = Math.pow(beta.getX() - alpha.getX(),2);
            double distY = Math.pow(beta.getY() - alpha.getY(),2);
            double dist = Math.sqrt(distX - distY);
            if(dist < 25){
                h.press();
                for(Thing r : things){
                    if(r != h)
                        r.selected = false;
                }
            }
        }
    }
    public BufferedImage getImage(){
        BufferedImage image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLACK.brighter());
        g.fillRect(0,0,600,600);
        for(Thing h : things){
            g.setColor(Color.GREEN.darker());
            Point p = h.getPoint();
            int thingX = (int)Math.round(p.getX())-5 + shipX;
            int thingY = (int)Math.round(p.getY())-5 + shipY;
            g.fillOval(thingX,thingY,10,10);
            if(h.isSelected()){
                g.setColor(Color.CYAN);
                g.drawOval(thingX - 5,thingY - 5,20,20);
            }
        }
        return image;
    }
}
import java.awt.*;
import java.util.*;

public class Radar
{
    Ship ship;
    Thing t = new Thing(400,400);
    Thing h = new Thing(250,300);
    ArrayList<Thing> things = new ArrayList<Thing>();
    int x, y;
    
    public Radar(Ship s, int locx, int locy)
    {
        this.ship = s;
        this.things = t;
        this.x = locx;
        this.y = locy;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 600, 600);
    }
    
    public void click(int x, int y)
    {
        int cx = x - this.x;
        int cy = y - this.y;
        Point alpha = new Point(cx,cy);
        
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
    
    public void render(Graphics g)
    {
        g.setColor(new Color(0,32,0));
        g.fillRect(0,0,600,600);
        for(Thing h : things){
            g.setColor(Color.GREEN.darker());
            Point p = h.getPoint();
            int thingX = (int)Math.round(p.getX())-5 + ship.getX();
            int thingY = (int)Math.round(p.getY())-5 + ship.getY();
            g.fillOval(thingX,thingY,10,10);
            if(h.isSelected()){
                g.setColor(Color.CYAN);
                g.drawOval(thingX - 5,thingY - 5,20,20);
            }
        }
    }
    
}

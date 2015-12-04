import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Radar
{
    Ship ship;
    Thing t = new Thing(100,150);
    Thing h = new Thing(250,200);
    Thing m = new Thing(-50,-50);
    ArrayList<Thing> things = new ArrayList<Thing>();
    int x, y;
    Point last = new Point(-1,-1);
    
    public Radar(Ship s, int locx, int locy)
    {
        this.ship = s;
        this.x = locx;
        this.y = locy;
        things.add(t);
        things.add(h);
        things.add(m);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 600, 600);
    }
    
    public void click(int x, int y)
    {
        last = new Point(x-this.x, y-this.y);
        System.out.println(last.x + ", " + last.y + ":radar");
        for(Thing h : things){
            Point beta = h.getPoint();
            double distX = Math.pow(beta.getX() - (last.x - 300),2);
            double distY = Math.pow(beta.getY() - (last.y - 300),2);
            double dist = Math.sqrt(distX - distY);
            if(dist < 10){
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
        g.setColor(new Color(0,22,0));
        g.fillRect(0,0,600,600);
        int cx = 300;
        int cy = 300;
        for(Thing h : things){
            g.setColor(Color.GREEN.darker());
            Point p = h.getPoint();
            int thingX = (int)Math.round(p.getX())-5 + cx;
            int thingY = (int)Math.round(p.getY())-5 + cy;
            g.fillOval(thingX,thingY,10,10);
            g.drawString(thingX + ", " + thingY, thingX-20,thingY-10);
            if(h.isSelected()){
                g.setColor(Color.GREEN);
                g.drawOval(thingX - 5,thingY - 5,20,20);
            }
        }
        
        g.setColor(Color.GREEN);
        if(last.x >= 0)
        {
            g.drawLine(last.x - 15, last.y, last.x + 15, last.y);
            g.drawLine(last.x, last.y - 15, last.x, last.y + 15);
        }
    }
    public BufferedImage getImage(){
        BufferedImage image = new BufferedImage(600,600,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        
        render(g);
        return image;
    }
}

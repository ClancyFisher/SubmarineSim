
import java.awt.*;
public class Thing{
    Point loc;
    boolean selected;
    public Thing(int x, int y){
        loc = new Point(x,y);
    }
    public Point getPoint(){
        return loc;
    }
    public void press(){
        selected = !selected;
    }
    public boolean isSelected(){
        return selected;
    }
}
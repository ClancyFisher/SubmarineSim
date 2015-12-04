import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class MapInterface
{
    Ship shp;
    Radar radar;
    
    public MapInterface(Ship shp){
        radar = new Radar(shp, 660, 437);
    }
    public void Clicked(MouseEvent e){
        radar.click(e.getX(), e.getY());
        
    }
    
}
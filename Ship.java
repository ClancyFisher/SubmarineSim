
public class Ship
{
    double xLoc, yLoc, xVel, yVel;
    public Ship(int x, int y)
    {
        xLoc = x;
        yLoc = y;
        xVel = 0;
        yVel = 0;
    }
    public int getX(){
        return (int)Math.round(xLoc);
    }
    public int getY(){
        return (int)Math.round(yLoc);
    }
    public void update(){
        xVel *= .9;
        yVel *= .9;
        if(xVel < .1)
            xVel = 0;
        if(yVel < .1)
            yVel = 0;
        xLoc += xVel;
        yLoc += yVel;
    }
}
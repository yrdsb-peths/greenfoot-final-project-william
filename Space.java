import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Space extends World
{
    public int shot = 1;
    
    Counter score = new Counter("Scores: ");
    
    Counter live = new Counter("Lives: ");

    
    public Space()
    {    
        super(100, 100, 5); 
        addObject(new Spaceship(), 50, 85);
        addObject(score, 15, 90);
        addObject(live, 95, 90);
        live.add(1);
    }
    
    public void ShootSet(int arg)
    {
        shot = arg;
    }
    public boolean CanShoot()
    {
        if(shot == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void die()
    {
        live.subtract(1);
        if(live.getValue() == 0)
        {
            gameOver();
        }   
    }
    public void gameOver()
    {
        addObject(new Scoreboard(score.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    public void addPoints(int pts)
    {
    score.add(pts);
    }
}

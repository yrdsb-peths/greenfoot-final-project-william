import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Space extends World
{
    public int shot = 1;
    
    public Space()
    {    
        
        super(100, 100, 5); 
        addObject(new Spaceship(), 50, 85);
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
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Space extends World
{
    public int shot = 1;
    
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(100, 100, 5); 
        addObject(new Spaceship(), 50, 90);
    }
    
    public void ShootSet(int arg)
    {
        shot = arg;
    }
}

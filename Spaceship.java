import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spaceship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spaceship extends Actor
{
    
    public void act()
    {
        int x = getX();
        if(Greenfoot.isKeyDown("d"))
        {
            x = x + 1;
            setLocation(x, getY());
        }
        if(Greenfoot.isKeyDown("a"))
        {
            x = x - 1;
            setLocation(x, getY());
        }
    }
}

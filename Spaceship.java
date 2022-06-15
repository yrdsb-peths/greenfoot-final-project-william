import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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
        List bullets = getNeighbours(3, false, Alien_bullet.class);
        if(!bullets.isEmpty())
        {
            Actor b = (Actor) bullets.get(0);
            if(b instanceof Alien_bullet)
            {
                destroy();
            }
        } 
        else 
        {
            processKeys();
        }
    }
    private void processKeys()
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
        if(Greenfoot.isKeyDown("w") && ((Space) getWorld()).CanShoot())
        {
            getWorld().addObject(new shipBullet(), getX()+1, getY()-7);
            ((Space) getWorld()).ShootSet(0);
            Greenfoot.playSound("gun_shoot.wav");
        }
    }
    private void destroy()
    {
        ((Space)getWorld()).die();
    }
}

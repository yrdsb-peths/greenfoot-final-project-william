import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Alien1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien1 extends Actor
{
    public int dir = 1; //1 = left 2 = right
    
    public int movetimer = 0; //timer value to move at cetain intervals
    
    public int shouldMove = 0; //weather or not they should move
    
    public int shouldCar = 0;
    
    public GreenfootImage img1; //1st animation
    
    public GreenfootImage img2; //2nd animation
    
    public int shoot; //variable to determine if wea should shoot or not. starting chance is 2%
    
    public int chance = 1; //chance to shoot, starts at 2%
    
    public Alien1()
    {
        img1 = getImage();
        img2 = new GreenfootImage("Alien1_animation2");
    }
    public void act()
    {
        //
    }
    
    public void destroy()
    {
        ((Space) getWorld()).addPoints(10);
        ((Space) getWorld()).invaders--;
        if(((Space)getWorld()).invaders <= 0)
        {
           ((Space)getWorld()).populate();
           ((Space)getWorld()).invaders = 50;
        }
        getWorld().removeObject(this);
    }
    public void move()
    {
        //
    }
    private void carridgeRight()
    {
        setLocation(getX(), getY() + 5);
        dir = 2;
        chance = chance + 1;
        if(getY() > 60)
        {
            ((Space)getWorld()).gameOver();
        }
    }
    private void carridgeLeft()
    {
        setLocation(getX(), getY() + 5);
        dir = 1;
        chance = chance + 1;
    }
    private void carridgeAlliesRight()
    {
        List allies = getWorld().getObjects(Alien1.class);
        Iterator i = allies.iterator();
        while(i.hasNext())
        {
            Alien1 a = (Alien1) i.next();
            if(a != this)
            {
                a.carridgeRight();
                a.setLocation(a.getX(), a.getY());
                a.shouldMove = 0;
                a.movetimer = 0;
                if(getImage() != a.getImage())
                {
                    setImage(a.getImage());
                }
            }
        }
    }
    private void carridgeAlliesLeft()
    {
        List allies = getWorld().getObjects(Alien1.class);
        Iterator i = allies.iterator();
        while(i.hasNext())
        {
            Alien1 a = (Alien1) i.next();
            if(a != this)
            {
                a.carridgeLeft();
                a.setLocation(a.getX(), a.getY());
                a.shouldMove = 0;
                a.movetimer = 0;
                if(getImage() != a.getImage())
                {
                    setImage(a.getImage());
                }
            }
        }
    }
}

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
        img2 = new GreenfootImage("Alien1_animation2.png");
    }
    public void act()
    {
        List bullets = getNeighbours(3, false, shipBullet.class); //new list with all Pbullets within 2 uinits adjacent to the enemy
       if (!bullets.isEmpty()) { //is there is one (there will only be one, since only one bullet on screen at a time)
       Actor b = (Actor) bullets.get(0); //gets the first object in the list
       if (b instanceof shipBullet) { //just an extra check to make sure its a player bullet
           ((Space) getWorld()).ShootSet(1); //allow us to fire again
           getWorld().removeObject(b); //remobe the bullet
           destroy(); //call the destroy funcrtion
       }
       } else {
           shoot();
           move();    //if we are still alive move
       }
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
    public void shoot()
    {
        if(shouldMove == 1)
        {
            shoot = Greenfoot.getRandomNumber(100);
            if(shoot <= chance)
            {
                getWorld().addObject(new Alien_bullet(), getX(), getY() + 5);
            }
        }
    }
    public void move()
    {
        if(dir == 1 && shouldCar == 1)
        {
            if(getX() + 5 >= getWorld().getWidth())
            {
                carridgeRight();
                carridgeAlliesRight();
                movetimer = 0;
                shouldMove = 0;
            }
        } else if(dir == 2 && shouldCar == 1)
        {
            if(getX() - 5 <= 0)
            {
                carridgeLeft();
                carridgeAlliesLeft();
                movetimer = 0;
                shouldMove = 0;
            }
        }
        if(dir == 1 && shouldMove == 1)
        {
            if(getImage() == img1)
            {
                setImage(img2);
            }
            else
            {
                setImage(img1);
            }
            setLocation(getX() + 5, getY());
            shouldMove = 0;
        } else if(dir == 2 && shouldMove == 1)
        {
            if(getImage() == img1)
            {
                setImage(img2);
            } else
            {
                setImage(img1);
            }
            setLocation(getX() - 5, getY());
            shouldMove = 0;
        } else if(shouldMove == 0)
        {
            movetimer++;
            if(movetimer == 24)
            {
                shouldCar = 1;
            } else if(movetimer == 25)
            {
                shouldMove = 1;
                shouldCar = 0;
                movetimer = 0;
            }
        }
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

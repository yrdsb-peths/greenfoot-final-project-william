import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Space extends World
{
    public int shot = 1;
    
    public int invaders = 50;
    
    Counter score = new Counter("Scores: ");
    
    Counter live = new Counter("Lives: ");

    
    public Space()
    {    
        super(100, 100, 5); 
        addObject(new Spaceship(), 50, 85);
        addObject(score, 15, 90);
        addObject(live, 95, 90);
        live.add(1);
        populate();
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
    public void populate()
    {
        //first row of aliens
        Alien1[] enemies1 = new Alien1[21];
        for(int i = 0; i < 10; i++)
        {
            enemies1[i] = new Alien1();
            addObject(enemies1[i], (i*5)+5, 10);
        }
        
        //2nd row of aliens
        for(int i = 0; i < 10; i++ )
        {
            enemies1[i] = new Alien1();
            addObject(enemies1[i], (i*5)+5, 15);
        }
        
        //3rd row of aliens
        Alien2[] enemies2 = new Alien2[21];
        for(int i = 0; i < 10; i++)
        {
            enemies2[i] = new Alien2();
            addObject(enemies2[i], (i*5)+5, 20);
        }
        
        //4th row of aliens
        for(int i = 0; i < 10; i++)
        {
            enemies2[i] = new Alien2();
            addObject(enemies2[i], (i*5)+5, 25);
        }
        
        //5th row
        for(int i = 0; i < 10; i++)
        {
            enemies2[i] = new Alien2();
            addObject(enemies2[i], (i*5)+5, 30);
        }
    }
}

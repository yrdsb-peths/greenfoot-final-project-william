import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Alien_bullet extends Actor
{
    private GreenfootImage img1;
    
    public Alien_bullet()
    {
        img1 = getImage();
    }
    
    public void act()
    {
        int y = getY();
        y = y + 1;
        setLocation(getX(), y);
        
        if(getY() + 5 == getWorld().getHeight())
        {
            destroy();
        }
    }
    private void destroy()
    {
        getWorld().removeObject(this);
    }
}

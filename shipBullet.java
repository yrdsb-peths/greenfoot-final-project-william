import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class shipBullet extends Actor
{
    private Spaceship ship;
    public void act()
    {
        int y = getY();
        y = y - 2;
        setLocation(getX(), y);
        
        if(getY() == 0)
        {
            destroy();
        }
    }
    
    private void destroy()
    {
        ((Space) getWorld()).ShootSet(1);
        getWorld().removeObject(this);
    }
}

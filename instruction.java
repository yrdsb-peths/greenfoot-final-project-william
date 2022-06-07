import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class instruction extends World
{
    Label startingLabel = new Label("press <space> to start", 30);
    Label instruction1 = new Label("1. press 'a' or 'd' to move left and right", 30);
    Label instruction2 = new Label("2. press 'w' to shoot", 30);
    Label instruction3 = new Label("Have fun ;)", 30);
    public instruction()
    {    
        super(600, 340, 1);
        addObject(startingLabel, 300, 290);
        addObject(instruction1, 225, 50);
        addObject(instruction2, 127, 100);
        addObject(instruction3, 300, 250);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            Space gameWorld = new Space();
            Greenfoot.setWorld(gameWorld);
        }
    }
}

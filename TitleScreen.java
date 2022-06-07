import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    Label titleLabel = new Label("Alien pew pew", 60);
    Label startingLabel = new Label("press <i> to go to instruction", 40);
    
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 340, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        addObject(startingLabel, 300, 245);
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("i"))
        {
            instruction gameWorld = new instruction();
            Greenfoot.setWorld(gameWorld);
        }
    }
}

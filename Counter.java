import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Counter extends Actor
{
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;
    
    public Counter()
    {
        this("");
    }
    
    public Counter(String prefix)
    {
        text = prefix;
        stringLength = (text.length() + 2) * 16;
        
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.WHITE);
        
        updateImage();
    }
    public void act()
    {
        if(value < target)
        {
            value++;
            updateImage();
        }
        else if(value > target)
        {
            value--;
            updateImage();
        }
    }
    public void add(int score)
    {
        target += score;
    }
    public void subtract(int score)
    {
    target -= score;
    }
    public int getValue()
    {
        return value;
    }
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}

import mayflower.*;
public class Lose extends World
{
    /**
     * Constructor for objects of class Lose
     */
    public Lose()
    {
        Mayflower.playMusic("sounds/lose.mp3");
        //showText("YOU LOSE!!",10,30,Color.WHITE);
        setBackground("lose.png");
    }

    public void act()
    {
        
    }
}

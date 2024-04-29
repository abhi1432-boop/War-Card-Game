import mayflower.*;

public class MyMayflower extends Mayflower 
{
    //Constructor
    public MyMayflower()
    {
        //Create a window with 1080x1080 resolution
        super("WarGame", 1040, 1040);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        SpecialFont.setFont();
        Mayflower.setFullScreen(false);
        World w =  new Map();
        Mayflower.setWorld(w);
    }
}

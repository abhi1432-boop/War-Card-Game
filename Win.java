import mayflower.*;
public class Win extends World{
    public Win() {
        Mayflower.playMusic("sounds/win.mp3");
        showText("YOU",0,0,Color.WHITE);
        showText("WON",0,0,Color.WHITE);
        setBackground("win.png");
    }
    public void act() {
        //
    }
}
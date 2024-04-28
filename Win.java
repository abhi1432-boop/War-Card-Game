import mayflower.*;
public class Win extends World{
    public Win() {
        Mayflower.playMusic("sounds/win.mp3");
        showText("YOU WON!!",10,30,Color.WHITE);
        setBackground("Solitaire.jpg");
    }
    public void act() {
        //
    }
}
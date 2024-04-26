import mayflower.*;

public class Map extends World {
    private boolean gameStarted = false;
    public Map() {
        // Initialize the player and set the background image

        setBackground("Solitaire.jpg"); 
        showText("Welcome to War! Press Enter to Start!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
    }

    public void act() {
        if(gameStarted == false){

            if(Mayflower.isKeyDown(Keyboard.KEY_ENTER)){
                gameStarted = true;
                showText("", 0, 0);
                Mayflower.setWorld(new DeckWorld());
            }

        }

    }
}

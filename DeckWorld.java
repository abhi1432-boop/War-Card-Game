import mayflower.*;
public class DeckWorld extends World
{
    public Deck deck;
    public DeckWorld()
    {
        deck = new Deck();
        addObject(deck, 400, 400);
        setBackground("Solitaire.jpg");
        showText("Press Space to Begin the Game!", getWidth() / 2 - 220, getHeight() / 2 - 200, Color.WHITE);
    }

    public void act()
    {
        // changes world when user presses space
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            World game = new GameWorld();
            Mayflower.setWorld(game);
        }
    }
}

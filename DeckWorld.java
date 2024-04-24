import mayflower.*;
public class DeckWorld extends World
{
    public Deck deck;
    public DeckWorld()
    {
        deck = new Deck();
        addObject(deck, 700, 600);
        setBackground("Solitaire.jpg");
        showText("Press Space to Draw a Card!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);

    }
    public void act()
    {
        if(Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            World game = new GameWorld();
            Mayflower.setWorld(game);
        }
    }
}

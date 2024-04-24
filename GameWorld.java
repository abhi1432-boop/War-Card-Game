
import mayflower.*;
public class GameWorld extends World
{
     public Card card;
    public GameWorld()
    {
       card = new Card();
       addObject(card, 900, 600);
       setBackground("Solitaire.jpg");
    }
    public void act() {
        // Add game logic here (if any)
        // This method is called on every game loop iteration
    }
}

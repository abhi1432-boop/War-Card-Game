
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
    public void act() 
     {
        
    }
}

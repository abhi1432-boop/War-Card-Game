
import mayflower.*;
public class GameWorld extends World
{
     public Card card;
     public Card2 card2;
    public GameWorld()
    {
       card = new Card();
       card2 = new Card2();
       addObject(card, 700, 600);
       addObject(card2, 200, 100);
       setBackground("Solitaire.jpg");
    }
    public void act() 
     {
        /*if(card.getValue() > card2.getValue())
        {
            showText("You Won!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);

        }
    }*/
}
}

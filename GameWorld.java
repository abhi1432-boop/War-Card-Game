import mayflower.*;
public class GameWorld extends World
{
    public Card card;
    public Card2 card2;
    public Deck deck;
    public Deck deck2;
    public Compare comp;
    public GameWorld()
    {
        card = new Card();
        card2 = new Card2();
        deck = new Deck();
        deck2 = new Deck();
        addObject(card, 600, 600);
        addObject(card2, 200, 100);
        addObject(deck, 600, 90);
        addObject(deck2, 200, 600);
        setBackground("Solitaire.jpg");

    }

    public void act() 
    {

        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            
            if(card.getI() > card2.getJ())
            {
                System.out.println("I: " + card.getI() + " J:" + card2.getJ());
                showText("You Won!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
                card.shuffle(card.getQueue());
                card2.shuffle(card2.getQueue());
            }
            else if(card.getI() < card2.getJ())
            {
                System.out.println("I: " + card.getI() + " J:" + card2.getJ());
                showText("You lost!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
                card.shuffle(card.getQueue());
                card2.shuffle(card2.getQueue());
            }
            else
            {
                showText("Draw!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
                card.shuffle(card.getQueue());
                card2.shuffle(card2.getQueue());
            }
        }

        //if(Mayflower.isKeyDown(Keyboard.KEY_ENTER) && card.getI() != 0 && card2.getJ() != 0)
        //comp.compareValues(card.getI(), card2.getJ());
    }
}


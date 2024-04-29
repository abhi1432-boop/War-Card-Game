import mayflower.*;
import java.util.Collections;

public class GameWorld extends World
{
    public Card card;
    public Card2 card2;
    public Deck deck;
    public Deck deck2;
    private boolean shuffledThisKeyPress;
    private int timer; // Counter for the timer
    private boolean timerExpired;
    int score1 = 0;
    int score2 = 0;
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
        shuffledThisKeyPress = false;
        timer = 0; // Initialize the timer counter
        timerExpired = false;

    }

    public void act() 
    {

        if (!timerExpired) {
            timer++; // Increment the timer counter
            if (timer >= 50) { // Change 300 to adjust the duration (300 frames ~= 5 seconds)
                timerExpired = true;
                shuffleCard();
                shuffleCard2();// Set the timer as expired after 5 seconds
            }
            return; // Don't proceed with the rest of the code until the timer expires
        }
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER) && !shuffledThisKeyPress)
        {

            shuffleCard();
            shuffleCard2();
            int i = card.extractIValue();
            int j = card2.extractJValue();

            if(i > j)
            {
                showText("You Won!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
                score1++;
                updateScore();
                //card.shuffle1(card.getIQueue());
                //card2.shuffle2(card2.getJQueue());
            }
            else if(i < j)
            {
                showText("You lost!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
                score2++;
                updateScore();
                //card.shuffle1(card.getIQueue());
                //card2.shuffle2(card2.getJQueue());
            }
            else
            {
                showText("Draw!", getWidth() / 2 - 300, getHeight() / 2, Color.WHITE);
                //card.shuffle1(card.getIQueue());
                //card2.shuffle2(card2.getJQueue());
            }

            // Set the flag to true to indicate shuffling has occurred
            shuffledThisKeyPress = true;

        }
        else if (!Mayflower.isKeyDown(Keyboard.KEY_ENTER)) {
            // Reset the flag when Enter key is released
            shuffledThisKeyPress = false;
        }

       
    }

    public void shuffleCard()
    {

        card.randomSelect();
        card.shuffle1(card.getIQueue());
        Mayflower.playMusic("sounds/flip.mp3");
        int i = card.extractIValue();
        System.out.println("The i value is: " + i);

    }

    public void shuffleCard2()
    {

        card2.randomSelect();
        card2.shuffle2(card2.getJQueue());
        Mayflower.playMusic("sounds/flip.mp3");
        int j = card2.extractJValue();
        System.out.println("The j value is: " + j);

    }

    public void updateScore()
    {
        removeText(10, 30);
        showText("You: " + score1 + " AI: " + score2, 0, 30, Color.WHITE);
        if(score1 == 10)
        {
            World win = new Win();
            Mayflower.setWorld(win);
        }
        if(score2 == 10)
        {
            World lose = new Lose();
            Mayflower.setWorld(lose);
        }
    }
}


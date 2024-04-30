
import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Card extends Actor
{
    // private MayflowerImage image;
    Queue<String> clubs = new LinkedList<String>();
    Queue<String> diamonds = new LinkedList<String>();
    Queue<String> spades = new LinkedList<String>();
    Queue<String> hearts = new LinkedList<String>();
    Queue<String> kings = new LinkedList<String>();
    Queue<String> queens = new LinkedList<String>();
    Queue<String> aces = new LinkedList<String>();
    Queue<String> jacks = new LinkedList<String>();
    Queue<String> selected = new LinkedList<String>();
    int i = 0;
    int value;
    boolean isTrue = false;
    public int score;
    MayflowerImage king;
    public Card()
    {
        for(i = 2; i < 10; i++)
        {
            clubs.add("Cards/Clubs " + i + ".png");

        }
        for(i = 2; i < 10; i++)
        {
            diamonds.add("Cards/Diamonds " + i + ".png");
        }
        for(i = 2; i < 10; i++)
        {
            spades.add("Cards/Spades " + i + ".png");
        }
        for(i = 2; i < 10; i++)
        {
            hearts.add("Cards/Hearts " + i + ".png");
        }
        for(i = 1; i < 5; i++)
        {
            kings.add("Cards/King " + i + ".png");
        }
        for(i = 1; i < 5; i++)
        {
            queens.add("Cards/Queen " + i + ".png");
        }
        for(i = 1; i < 5; i++)
        {
            aces.add("Cards/Ace " + i + ".png");
        }
        for(i = 1; i < 5; i++)
        {
            jacks.add("Cards/Jack " + i + ".png");
        }
        randomSelect();
        king = new MayflowerImage("Cards/King 1.png");
        king.scale(0.5);
        setImage(king);

    }
    public void act()
    {

        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            //randomSelect();
            //shuffle(selected);
            //MayflowerImage selectedImage = new MayflowerImage(selected.peek());
            //selectedImage.scale(0.5);
            //setImage(selectedImage); 
            if (selected != null && !selected.isEmpty()) {
                MayflowerImage selectedImage = new MayflowerImage(selected.peek());
                selectedImage.scale(0.5);
                setImage(selectedImage); 
            }
            else
            {
                System.out.print("Nothing in queue");
            }
            //Mayflower.playMusic("sounds/flip.mp3");
            //i = extractIValue();
            //System.out.print("The i value is: " + extractIValue());

            //getValue();
        }

    }

    public int getI()
    {
        return i;
    }

    public void randomSelect()
    {
        int random = (int)(Math.random() * 8) + 1;
        if(random == 1)
        {
            selected = clubs;
        }
        else if(random == 2)
        {
            selected = diamonds;
        }
        else if(random == 3)
        {
            selected = spades;
        }
        else if(random == 4)
        {
            selected = hearts;
        }
        else if(random == 5)
        {
            selected = kings;
        }
        else if(random == 6)
        {
            selected = queens;
        }
        else if(random == 7)
        {
            selected = aces;
        }
        else if(random == 8)
        {
            selected = jacks;
        }
    }

    public void shuffle(Queue queue)
    {
        List<String> list = new LinkedList<>(queue);

        Collections.shuffle(list);

        queue.clear();
        queue.addAll(list);

    }

    public int extractIValue() {
        int startIndex = -1; // Initialize the start index of the number
        int endIndex = -1; // Initialize the end index of the number

        // Determine the card type based on the selected queue
        if (selected == clubs) {
            startIndex = selected.peek().indexOf("Clubs") + "Clubs ".length();
        } else if (selected == diamonds) {
            startIndex = selected.peek().indexOf("Diamonds") + "Diamonds ".length();
        } else if (selected == spades) {
            startIndex = selected.peek().indexOf("Spades") + "Spades ".length();
        } else if (selected == hearts) {
            startIndex = selected.peek().indexOf("Hearts") + "Hearts ".length();
        } else if (selected == kings) {
            startIndex = selected.peek().indexOf("King") + "King ".length();
        } else if(selected == queens)
        {
            startIndex = selected.peek().indexOf("Queen") + "Queen ".length();
        }
        else if(selected == aces)
        {
            startIndex = selected.peek().indexOf("Ace") + "Ace ".length();
        }
        else if(selected == jacks)
        {
            startIndex = selected.peek().indexOf("Jack") + "Jack ".length();
        }

        // Find the end index of the number
        endIndex = selected.peek().indexOf(".png");

        // Extract the substring containing the number
        String iValueString = selected.peek().substring(startIndex, endIndex);
        if(selected == kings)
        {
            iValueString = "13";
        }
        else if(selected == queens)
        {
            iValueString = "12";
        }
        else if(selected == jacks)
        {
            iValueString = "11";
        }
        else if(selected == aces)
        {
            iValueString = "14";
        }

        // Convert the substring to an integer and return
        return Integer.parseInt(iValueString);
    }

    public Queue getIQueue()
    {
        return selected;
    }
}

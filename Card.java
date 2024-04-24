
import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Card extends Actor
{
    // instance variables - replace the example below with your own
    private MayflowerImage image;
    Queue<String> clubs = new LinkedList<String>();
    Queue<String> diamonds = new LinkedList<String>();
    Queue<String> spades = new LinkedList<String>();
    Queue<String> hearts = new LinkedList<String>();
    Queue<String> selected;
    public Card()
    {
        // int i = (int)(Math.Random() * 8) + 2;
        for(int i = 2; i < 10; i++)
        {
            clubs.add("Cards/Clubs " + i + ".png");
        }
        for(int i = 2; i < 10; i++)
        {
            diamonds.add("Cards/Diamonds " + i + ".png");
        }
         for(int i = 2; i < 10; i++)
        {
            spades.add("Cards/Spades " + i + ".png");
        }
        for(int i = 2; i < 10; i++)
        {
            hearts.add("Cards/Hearts " + i + ".png");
        }
        randomSelect();
        shuffle(selected);
        setImage(selected.remove());
    }

    public void act()
    {
        
        
    }
    public void randomSelect()
    {
        int random = (int)(Math.random() * 4) + 1;
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
        else
        {
            selected = hearts;
        }
    }
    public void shuffle(Queue queue)
    {
        List<String> list = new LinkedList<>(queue);

        Collections.shuffle(list);

        queue.clear();
        queue.addAll(list);
        
    }
    }

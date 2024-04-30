
import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Card2 extends Card
{
    Queue<String> clubs = new LinkedList<String>();
    Queue<String> diamonds = new LinkedList<String>();
    Queue<String> spades = new LinkedList<String>();
    Queue<String> hearts = new LinkedList<String>();
    Queue<String> kings = new LinkedList<String>();
    Queue<String> queens = new LinkedList<String>();
    Queue<String> aces = new LinkedList<String>();
    Queue<String> jacks = new LinkedList<String>();
    Queue<String> selected = new LinkedList<String>();
    int j = 0;
    int value;
    public int score;
    MayflowerImage king;
    public Card2()
    {
        for(j = 2; j < 10; j++)
        {
            clubs.add("Cards/Clubs " + j + ".png");
        }
        for(j = 2; j < 10; j++)
        {
            diamonds.add("Cards/Diamonds " + j + ".png");
        }
        for(j = 2; j < 10; j++)
        {
            spades.add("Cards/Spades " + j + ".png");
        }
        for(j = 2; j < 10; j++)
        {
            hearts.add("Cards/Hearts " + j + ".png");
        }
        for(j = 1; j < 5; j++)
        {
            kings.add("Cards/King " + j + ".png");
        }
        for(j = 1; j < 5; j++)
        {
            queens.add("Cards/Queen " + j + ".png");
        }
        for(j = 1; j < 5; j++)
        {
            aces.add("Cards/Ace " + j + ".png");
        }
        for(j = 1; j < 5; j++)
        {
            jacks.add("Cards/Jack " + j + ".png");
        }
        randomSelect();
        
        // placeholder image
        king = new MayflowerImage("Cards/King 1.png");
        king.scale(0.5);
        setImage(king);

    }
    public void act()
    {
        // makes sure queue isnt empty
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            if (selected != null && !selected.isEmpty()) 
            {
                MayflowerImage selectedImage = new MayflowerImage(selected.peek());
                selectedImage.scale(0.5);
                setImage(selectedImage); 
            }
            else
            {
                System.out.print("Nothing in queue");
            }
        }

    }

    // same as randomSelect method from card class
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

    public int getJ()
    {
        // returns j value
        return j;
    }

    // same as extractIValue from Card class, but extracts j value
    public int extractJValue() {
        int startIndex = -1; 
        int endIndex = -1; 

        if (selected == clubs) 
        {
            startIndex = selected.peek().indexOf("Clubs") + "Clubs ".length();
        } 
        else if (selected == diamonds) 
        {
            startIndex = selected.peek().indexOf("Diamonds") + "Diamonds ".length();
        } 
        else if (selected == spades) 
        {
            startIndex = selected.peek().indexOf("Spades") + "Spades ".length();
        } 
        else if (selected == hearts) 
        {
            startIndex = selected.peek().indexOf("Hearts") + "Hearts ".length();
        } 
        else if (selected == kings) 
        {
            startIndex = selected.peek().indexOf("King") + "King ".length();
        } 
        else if (selected == queens) 
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

        endIndex = selected.peek().indexOf(".png");

        String jValueString = selected.peek().substring(startIndex, endIndex);
        if(selected == kings)
        {
            jValueString = "13";
        }
        else if(selected == queens)
        {
            jValueString = "12";
        }
        else if(selected == jacks)
        {
            jValueString = "11";
        }
        else if(selected == aces)
        {
            jValueString = "14";
        }

        return Integer.parseInt(jValueString);
    }

    public Queue getJQueue()
    {
        return selected;
    }
}

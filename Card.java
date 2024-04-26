
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
    Queue<String> selected = new LinkedList<String>();
    int i = 0;
    int value;
    boolean isTrue = false;
    public int score;
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
        /*randomSelect();
        shuffle(selected);
        setImage(selected.remove());
         */
        //MayflowerImage selectedImage = new MayflowerImage(selected.peek());
        //selectedImage.scale(0.5);
    }

    public void act()
    {

        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            randomSelect();
            //shuffle(selected);
            MayflowerImage selectedImage = new MayflowerImage(selected.peek());
            selectedImage.scale(0.5);
            setImage(selectedImage); 
            /*    if (selected != null && !selected.isEmpty()) {
            // Call extractIValue() or extractJValue() here
            // This is where you would call getValue() or any other method that depends on selected.peek()
            }*/
            Mayflower.playMusic("sounds/flip.mp3");
            i = extractIValue();
            System.out.print("The i value is: " + extractIValue());
            isTrue = true;
            //getValue();
        }
        houseScoreText();
        guestScoreText();
    }
     public int getI()
    {
        return i;
    }
    public void randomSelect()
    {
        int random = (int)(Math.random() * 6) + 1;
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
        else
        {
            selected = queens;
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
        } else
        {
            startIndex = selected.peek().indexOf("Queen") + "Queen ".length();
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

        // Convert the substring to an integer and return
        return Integer.parseInt(iValueString);
    }

    public void houseScoreText() {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score, 0, 30, Color.WHITE);
    }

    public void guestScoreText() {
        World w = getWorld();
        w.removeText(400, 300);
        w.showText("Score: " + score, 0, 1020, Color.WHITE);
    }
    public Queue getQueue()
    {
        return selected;
    }
}

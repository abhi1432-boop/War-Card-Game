
import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Card2 extends Card
{
    // private MayflowerImage image;
    Queue<String> clubs = new LinkedList<String>();
    Queue<String> diamonds = new LinkedList<String>();
    Queue<String> spades = new LinkedList<String>();
    Queue<String> hearts = new LinkedList<String>();
    Queue<String> kings = new LinkedList<String>();
    Queue<String> queens = new LinkedList<String>();
    Queue<String> selected = new LinkedList<String>();
    int j = 0;
    int value;
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
            /*        if (selected != null && !selected.isEmpty()) {
            extractJValue();
            // This is where you would call getValue() or any other method that depends on selected.peek()
            }*/
            Mayflower.playMusic("sounds/flip.mp3");
            j = extractJValue();
            System.out.println("The j value is: " + extractJValue());
        }

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

    public int getJ()
    {
        return j;
    }

    /*public int getValue()
    {
    if(selected.peek() == "Clubs 2.png" || selected.peek() == "Spades 2.png" || selected.peek() == "Diamonds 2.png" ||selected.peek() == "Hearts 2.png")
    {
    value = 2;

    }
    else if(selected.peek() == "Clubs 3.png"|| selected.peek() == "Spades 3.png" || selected.peek() == "Diamonds 3.png" ||selected.peek() == "Hearts 3.png"){
    value = 3;
    }
    else if(selected.peek() == "Clubs 4.png"|| selected.peek() == "Spades 4.png" || selected.peek() == "Diamonds 4.png" ||selected.peek() == "Hearts 4.png"){
    value = 4;
    }
    else if(selected.peek() == "Clubs 5.png"|| selected.peek() == "Spades 5.png" || selected.peek() == "Diamonds 5.png" ||selected.peek() == "Hearts 5.png"){
    value = 5;
    }
    else if(selected.peek() == "Clubs 6.png"||selected.peek() == "Spades 6.png" || selected.peek() == "Diamonds 6.png" ||selected.peek() == "Hearts 6.png"){
    value = 6;

    }
    else if(selected.peek() == "Clubs 7.png"|| selected.peek() == "Spades 7.png" || selected.peek() == "Diamonds 7.png" ||selected.peek() == "Hearts 7.png"){
    value = 7;

    }
    else if(selected.peek() == "Clubs 8.png"|| selected.peek() == "Spades 8.png" || selected.peek() == "Diamonds 8.png" ||selected.peek() == "Hearts 8.png"){
    value = 8;

    }
    else if(selected.peek() == "Clubs 9.png"|| selected.peek() == "Spades 9.png" || selected.peek() == "Diamonds 9.png" ||selected.peek() == "Hearts 9.png"){
    value = 9;
    }
    else if(selected.peek() == "Kings 1.png"|| selected.peek() == "Kings 2.png" || selected.peek() == "Kings 3.png" ||selected.peek() == "Kings 4.png"){
    value = 13;
    }
    else{
    value = 11;
    }
    return value;
    }*/
    public int extractJValue() {
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
        } else if (selected == queens) {
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

    public Queue getQueue()
    {
        return selected;
    }
}

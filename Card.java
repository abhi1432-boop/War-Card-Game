
import mayflower.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Card extends Compare
{
    // private MayflowerImage image;
    Queue<String> clubs = new LinkedList<String>();
    Queue<String> diamonds = new LinkedList<String>();
    Queue<String> spades = new LinkedList<String>();
    Queue<String> hearts = new LinkedList<String>();
    Queue<String> kings = new LinkedList<String>();
    Queue<String> queens = new LinkedList<String>();
    Queue<String> selected;
    int i = 0;
    int value;
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
            shuffle(selected);
            MayflowerImage selectedImage = new MayflowerImage(selected.peek());
            selectedImage.scale(0.5);
            setImage(selectedImage);  
            //getValue();
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
}

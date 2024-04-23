
import mayflower.*;
public class Card
{
    // instance variables - replace the example below with your own
    private String rank;
    private String suit;
    private MayflowerImage image;

    /**
     * Constructor for objects of class Card
     */
    public Card(String rank, String suit, Mayflower image)
    {
        // initialise instance variables
        this.rank = rank;
        this.suit = suit;
        this.image = image;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public MayflowerImage getImage() {
        return image;
    }
}

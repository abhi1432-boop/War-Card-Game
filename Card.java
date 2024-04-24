import mayflower.*;
public class Card
{
    private String rank;
    private String suit;
    private MayflowerImage image;

    /**
     * Constructor for objects of class Card
     */
    public Card(String rank, String suit, Mayflower image)
    {
        this.rank = rank;
        this.suit = suit;
        image = image;
    }
    
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

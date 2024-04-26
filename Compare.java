
import mayflower.*;
public class Compare extends Actor
{

    public Compare()
    {

    }

    public void act()
    {
       
    }
    public void compareValues(int value1, int value2) {
        if (value1 > value2) {
            System.out.println("Value from Card is greater.");
        } else if (value1 < value2) {
            System.out.println("Value from Card2 is greater.");
        } else {
            System.out.println("Values from Card and Card2 are equal.");
        }
    }
}


import mayflower.*;
public class Compare extends Card2
{

    public Compare()
    {
        
    }

    public void act()
    {
        //compareValues(getI(), getJ());
        
    }
    public void compareValues(int x, int y) {
        if (x == y) {
            System. out.println("Draw!");
        } else if (x < y) {
            System.out.println("You Lost :(");
        } else {
            System.out.println("You Win!");
        }
    }
}

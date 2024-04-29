import java.awt.Font;
import java.io.File;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.FontFormatException;

public class SpecialFont
{
    // instance variables - replace the example below with your own
    public static Font special;

    /**
     * Constructor for objects of class Font
     */
    public SpecialFont()
    {
        //
    }

    public static void setFont()
    {
        try {
            special = Font.createFont(Font.TRUETYPE_FONT, new File("IBMPlexMono-Regular.ttf")).deriveFont(20f);
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment(); 
            genv.registerFont(special);
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }
    }
}

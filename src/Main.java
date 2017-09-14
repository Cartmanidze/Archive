import java.io.IOException;

/**
 * Created by Bezrukov on 14.09.2017.
 */
public class Main {
    public static void main(String[]args)
    {
        FileReader fileReader;

        try {
            fileReader = new FileReader("123.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stanislav on 26.09.2017.
 */
public class Uncompresion {


    FileReader fileReader;
    String string;
    String[] mass;

    public Uncompresion() throws IOException {

        fileReader = new FileReader("output.txt", 1);
        string = fileReader.getString();
        mass = string.split(" ");

        System.out.println(Compresion.charCods);

        Set<Map.Entry<Character, String>> entrySet = Compresion.charCods.entrySet();


        for(String s: mass){

            for (Map.Entry<Character, String> pair : entrySet) {
                if (s.equals(pair.getValue())){
                    System.out.print(pair.getKey());
                }
            }
        }


    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stanislav on 26.09.2017.
 */
public class Uncompresion {



    public Uncompresion() throws IOException {



        byte[] array = Files.readAllBytes(Paths.get("output.txt"));

        Set<Map.Entry<Character, String>> entrySet = Compresion.charCods.entrySet();

        int flag = 0;



        for (int i = 0; i < 10; i++)
        System.out.println(String.format("%7s", Integer.toBinaryString(array[i])).replace(' ', '0'));

        //System.out.println(toBinary(array));

        //System.out.println(String.format("%7s", Integer.toBinaryString(array[0])).replace(' ', '0'));

        char[] chars = toBinary(array).toCharArray();
        String temp = "";
        int i = 0;
        System.out.println(chars[2]);


        while (i < chars.length){
            for (Map.Entry<Character, String> pair : entrySet) {
                if (temp.equals(pair.getValue())) {
                    System.out.print(pair.getKey());
                    temp = "";
                    break;
                    }else {

                    }
                //System.out.println(temp);
            }
            temp += chars[i];
            i++;
        }


    }


    String toBinary( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < bytes.length; i++ )
            sb.append(String.format("%7s", Integer.toBinaryString(bytes[i])).replace(' ', '0'));
        return sb.toString();
    }
}

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

        //System.out.println(String.format("%7s", Integer.toBinaryString(array[0])).replace(' ', '0'));


        for(int i = 0; i < array.length; i++) {

            for (Map.Entry<Character, String> pair : entrySet) {

               /* if (flag == 1){
                    i++;
                }
                if (flag == 2){
                    i += 2;
                }
                String temp1 = String.format("%7s", Integer.toBinaryString(array[i])).replace(' ', '0');
                //System.out.print(temp1);
                String temp2;
                if (temp1.equals(pair.getValue())) {
                    System.out.print(pair.getKey());
                    flag = 0;
                } else {
                    temp2 = String.format("%7s", Integer.toBinaryString(array[i + 1])).replace(' ', '0');
                    temp1 += temp2;
                    flag = 1;
                    if (temp1.equals(pair.getValue())) {
                        System.out.print(pair.getKey());
                    } else {
                        temp2 = String.format("%7s", Integer.toBinaryString(array[i + 2])).replace(' ', '0');
                        temp1 += temp2;
                        flag = 2;
                        if (temp1.equals(pair.getValue())) {
                            System.out.print(pair.getKey());
                        }
                    }
                }*/
            }
        }


    }


    String toBinary( byte[] bytes )
    {
        StringBuilder sb = new StringBuilder(bytes.length * Byte.SIZE);
        for( int i = 0; i < Byte.SIZE * bytes.length; i++ )
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }
}

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by Stanislav on 15.09.2017.
 */
public class Compresion {

    static Map<Character, Long> global;
    static CharFreq charFreq;
    int n = 0;

    public Compresion() {//класс будет отвечать за сжатие


       Iterator<Map.Entry<Character, Long>> itr1 = reverse().iterator();
       Iterator<Map.Entry<Character, Long>> itr2 = reverse().iterator();
           while (itr1.hasNext()) {
               Map.Entry<Character, Long> pair1 = itr1.next();
                Character key1 = pair1.getKey();
                Long value1 = pair1.getValue();


                while (itr2.hasNext()) {
                    Map.Entry<Character, Long> pair2 = itr2.next();
                    Character key2 = pair2.getKey();
                    Long value2 = pair2.getValue();

                   if (value1.equals(value2))n++;
                   if(n>1)
                        System.out.println(itr1.next());



                }

           }
       }

        public static Stream<Map.Entry<Character, Long>> reverse () {

            charFreq = new CharFreq();

            global = charFreq.getGlobal();

           return global.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue()); //Сортировку пренес сюда


       }

    }


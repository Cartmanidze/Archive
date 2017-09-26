import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Stanislav on 14.09.2017.
 */
public class CharFreq {

    Map<Character, Long> global;
    Map<Character, Long> globalSorted;
    FileReader fileReader;

    public List<Map.Entry <Character, Long>> list;

    public CharFreq(/*String s*/) {

        try {
            fileReader = new FileReader("123.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = fileReader.getString();


        global = new HashMap<Character, Long>(); //ГЛОБОЛЬНЫЙ КОНТЕЙНЕР
        mergeMap(global, symbolFreq(s));
        //вывод по возрастанию

        //global.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue()).toArray();

        list = global.entrySet().stream().collect(Collectors.toList());
        //System.out.println( list );

        //new Compresion();


    }

    private static void mergeMap(Map<Character, Long> target, Map<Character, Long> src) { //метод заполнения глобального МЭП
        for (Character c : src.keySet()) {          //пробегаем по всем символам что есть в срц
            if (target.containsKey(c)) {            //если встречается такойже символ прибавляем к нему значение символа срц
                target.put(c, target.get(c) + src.get(c));
            } else {                                // иначе оставляем все как есть
                target.put(c, src.get(c));
            }
        }
    }

    public static Map<Character, Long> symbolFreq(String s) {           //метод счета частоты символов
        Map<Character, Long> map = new HashMap<Character, Long>();
        char[] cars = s.toCharArray();
        for (char c : cars) {                               //пробегаем по массиву символов
            if (map.containsKey(c)) {                       //если встречается символ из МЭП добовляем к его значению 1
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1L);                             // если встречается первый раз устанавливаем значение 1
            }
        }
        return map;
    }

    public Map<Character, Long> getGlobal() {
        return global;
    }//
}

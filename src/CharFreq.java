import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Stanislav on 14.09.2017.
 */
public class CharFreq {

    Map<Character, Long> global;
    FileReader fileReader;

    public CharFreq(/*String s*/) {

        try {
            fileReader = new FileReader("123.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = fileReader.getString();

        System.out.println(s);

        global = new HashMap<Character, Long>(); //ГЛОБОЛЬНЫЙ КОНТЕЙНЕР
        mergeMap(global, symbolFreq(s));
        global.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue())
                .forEach(System.out::println); // или любой другой конечный метод


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
}

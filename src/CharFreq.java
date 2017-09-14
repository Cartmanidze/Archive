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

        System.out.println(global);

    }

    private static void mergeMap(Map<Character, Long> target, Map<Character, Long> src) {
        for (Character c : src.keySet()) {
            if (target.containsKey(c)) {
                target.put(c, target.get(c) + src.get(c));
            } else {
                target.put(c, src.get(c));
            }
        }
    }

    public static Map<Character, Long> symbolFreq(String s) {
        Map<Character, Long> map = new HashMap<Character, Long>();
        char[] cars = s.toCharArray();
        for (char c : cars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1L);
            }
        }
        return map;
    }
}

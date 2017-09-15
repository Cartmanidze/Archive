import java.util.Locale;
import java.util.Map;

/**
 * Created by Stanislav on 15.09.2017.
 */
public class Compresion {

    Map<Character, Long> global;
    CharFreq charFreq;

    public Compresion() {               //класс будет отвечать за сжатие

        charFreq = new CharFreq();

        global = charFreq.getGlobal();

        global.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue()).forEach(System.out::println); //Сортировку пренес сюда



    }
}

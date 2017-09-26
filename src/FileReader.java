import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Stanislav on 14.09.2017.
 */
public class FileReader {
    String fileName;
    List<String> lines;
    String string;

    public FileReader(String fileName) throws IOException {//

        this.fileName = fileName;
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        for(String line: lines){                    //запоминаем данные из файла
            string += line;
        }

    }

    public String getString() {                 // и возвращаем их
        return string;
    }

    public void writer(String text) throws IOException{

        FileWriter writer = new FileWriter(fileName, true);

        writer.write(text);
        writer.append('\n');

        writer.flush();

    }
}

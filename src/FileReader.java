import java.io.*;
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
    FileWriter writer;

    public FileReader(String fileName, int action) throws IOException {//

        this.fileName = fileName;
        if (action == 1) {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

            for (String line : lines) {                    //запоминаем данные из файла
                string += line;
            }
        }
        if (action == 2){
            writer  = new FileWriter(fileName, true);

        }
       //
    }

    public String getString() {                 // и возвращаем их
        return string;
    }

    public void writer(byte text) throws IOException{
        writer.write(text);
        //writer.append('\n');

        writer.flush();

    }
}

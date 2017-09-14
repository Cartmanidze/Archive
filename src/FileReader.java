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

    public FileReader(String fileName) throws IOException {

        this.fileName = fileName;
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);

        int i = 0;
        for(String line: lines){
            /*
            *
            * */
        }

    }

    public List<String> getLines() {
        return lines;
    }
}

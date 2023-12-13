import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {

    public static List<String> readFile(String fileName) {
        try {
            Path path = Paths.get("src/test/resources/" + fileName);
            return Files.readAllLines(path);

        } catch (IOException e) {
            System.out.println("ERRORORORORORORORORO!");
        }

        return null;

    }

}

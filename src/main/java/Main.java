import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {
        Day03 day03 = new Day03(Utils.readFile(Paths.get("src/main/resources/DayThree.txt")));
        System.out.println(day03.summerizeAllPartnerNumbers());
    }


}

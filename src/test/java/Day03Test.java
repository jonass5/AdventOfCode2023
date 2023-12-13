import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Day03Test {


    @Test
    void shouldLoadInputData() {
        //Arrange
        Path path = Paths.get("DayThree.txt");

        //Act
        List<String> inputList = Utils.readFile(path.toFile().getName());


        //Assert
        Assertions.assertThat(inputList).hasSize(10);

    }


}

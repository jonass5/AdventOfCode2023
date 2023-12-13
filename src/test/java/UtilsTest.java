import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UtilsTest {

    @Test
    void shouldLoadInputData() throws IOException {
        //Arrange
        Path path = Paths.get("src/test/resources/Day03Test.txt");

        //Act
        List<String> inputList = Utils.readFile(path);

        //Assert
        Assertions.assertThat(inputList).hasSize(10);
    }

}

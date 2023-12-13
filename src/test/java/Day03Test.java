import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class Day03Test {


    @Test
    void shouldLoadInputData() throws IOException {
        //Arrange
        Path path = Paths.get("src/test/resources/Day03Test.txt");

        //Act
        List<String> inputList = AdventUtils.readFile(path);

        //Assert
        Assertions.assertThat(inputList).hasSize(10);

    }

    @Test
    void isCharacterASymbol_True() throws IOException {
        //Arrange
        char charToCheck = '+';

        //Act
        boolean isSymbol = AdventUtils.isCharacterASymbol(charToCheck);

        //Assert
        Assertions.assertThat(isSymbol).isTrue();
    }

    @Test
    void isCharacterASymbol_False() throws IOException {
        //Arrange
        char charToCheck = '.';

        //Act
        boolean isSymbol = AdventUtils.isCharacterASymbol(charToCheck);

        //Assert
        Assertions.assertThat(isSymbol).isFalse();
    }

    @Test
    void isCharacterASymbol_False2() throws IOException {
        //Arrange
        char charToCheck = '3';

        //Act
        boolean isSymbol = AdventUtils.isCharacterASymbol(charToCheck);

        //Assert
        Assertions.assertThat(isSymbol).isFalse();
    }

    @Test
    void shouldFindAllNumbersInStringLine() throws IOException {
        //Arrange
        Day03 day03 = new Day03();
        String testLine = "........$..388.........152*141..*......73.719...$526....830...759......%......943............541.624.781...*...$150.............966.........";

        //Act
        List<String> resultList = day03.findNumbers(testLine);

        //Assert
        Assertions.assertThat(resultList).hasSize(14);
    }
}

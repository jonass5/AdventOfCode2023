import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


public class Day03Test {

    @Test
    void isCharacterASymbol_True() throws IOException {
        //Arrange
        char charToCheck = '+';
        Day03 day03 = new Day03();

        //Act
        boolean isSymbol = day03.isCharacterASymbol(charToCheck);

        //Assert
        Assertions.assertThat(isSymbol).isTrue();
    }

    @Test
    void isCharacterASymbol_False() throws IOException {
        //Arrange
        char charToCheck = '.';
        Day03 day03 = new Day03();

        //Act
        boolean isSymbol = day03.isCharacterASymbol(charToCheck);

        //Assert
        Assertions.assertThat(isSymbol).isFalse();
    }

    @Test
    void isCharacterASymbol_False2() throws IOException {
        //Arrange
        char charToCheck = '3';
        Day03 day03 = new Day03();

        //Act
        boolean isSymbol = day03.isCharacterASymbol(charToCheck);

        //Assert
        Assertions.assertThat(isSymbol).isFalse();
    }

    @Test
    void isLeft() {
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

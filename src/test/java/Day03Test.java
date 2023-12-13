import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Day03Test {

    @Test
    void isCharacterASymbol_True() throws IOException {

        //Act
        boolean isSymbol = new Day03().isCharacterASymbol('+');

        //Assert
        assertThat(isSymbol).isTrue();
    }

    @Test
    void isCharacterASymbol_False() throws IOException {

        //Act
        boolean isSymbol = new Day03().isCharacterASymbol('.');

        //Assert
        assertThat(isSymbol).isFalse();
    }

    @Test
    void isCharacterASymbol_False2() throws IOException {

        //Act
        boolean isSymbol = new Day03().isCharacterASymbol('3');

        //Assert
        assertThat(isSymbol).isFalse();
    }

    @Test
    void isSymbolLeftToIndex() throws IOException {
        //Arrange
        String line = ".*35..633.";
        int startIndex = 2;

        //Act
        boolean result = new Day03().checkLeft(startIndex, line);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindAllNumbersInStringLine() throws IOException {
        //Arrange
        Day03 day03 = new Day03();
        String testLine = "........$..388.........152*141..*......73.719...$526....830...759......%......943............541.624.781...*...$150.............966.........";

        //Act
        List<String> resultList = day03.findNumbers(testLine);

        //Assert
        assertThat(resultList).hasSize(14);
    }
}

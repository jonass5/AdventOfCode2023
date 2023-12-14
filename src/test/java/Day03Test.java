import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Day03Test {

    List<String> input = Arrays.asList(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598.."
    );

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
        //Act
        boolean result = new Day03().checkLeft(2, ".*35..633.");

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void isSymbolLeftToIndex_OutOfBounce() throws IOException {
        //Act
        boolean result = new Day03().checkLeft(0, "35....633.");

        //Assert
        assertThat(result).isFalse();
    }


    @Test
    void isSymbolRightToIndex() throws IOException {
        //Act
        boolean result = new Day03().checkRight(8, "..35..633*");

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void isSymbolRightToIndex_OutOfBounce() throws IOException {
        //Act
        boolean result = new Day03().checkRight(8, "..35..633");

        //Assert
        assertThat(result).isFalse();
    }


    @Test
    void shouldFindAllNumbersInStringLine() throws IOException {
        //Arrange
        String testLine = "........$..388.........152*141..*......73.719...$526....830...759......%......943............541.624.781...*...$150.............966.........";

        //Act
        List<String> resultList = new Day03().findNumbers(testLine);

        //Assert
        assertThat(resultList).hasSize(14);
    }

    @Test
    void shouldFindSymbolInAdjacentLineNearNumber_True() throws IOException {
        //Arrange
        int lineIndex = 0;
        int startIndex = 0;
        int endIndex = 3;

        //Act
        boolean hasNearSymbol = new Day03().isNearSymbolInAdjacentLine(input, lineIndex, startIndex, endIndex);

        //Assert
        assertThat(hasNearSymbol).isTrue();
    }


    @Test
    void shouldFindSymbolInAdjacentLineNearNumber_False() throws IOException {
        //Arrange
        int lineIndex = 7;
        int startIndex = 7;
        int endIndex = 9;

        //Act
        boolean hasNearSymbol = new Day03().isNearSymbolInAdjacentLine(input, lineIndex, startIndex, endIndex);

        //Assert
        assertThat(hasNearSymbol).isFalse();
    }

    @Test
    void shouldFindSymbolInSameLineNearNumber() throws IOException {
        // act
        boolean result = new Day03().isNearSymbolInSameLine("617*......", 0, 2);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_False_1() throws IOException {
        // arrange
        int lineIndex = 4;
        int startIndex = 0;
        int endIndex = 2;

        // act
        boolean result = new Day03().isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_True() throws IOException {
        // arrange
        int lineIndex = 6;
        int startIndex = 2;
        int endIndex = 4;

        // act
        boolean result = new Day03().isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_False_2() throws IOException {
        // arrange
        int lineIndex = 0;
        int startIndex = 0;
        int endIndex = 2;

        // act
        boolean result = new Day03().isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_False_3() throws IOException {
        // arrange
        int lineIndex = 7;
        int startIndex = 7;
        int endIndex = 9;

        // act
        boolean result = new Day03().isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_False_1() throws IOException {
        // arrange
        int lineIndex = 2;
        int startIndex = 2;
        int endIndex = 3;

        // act
        boolean result = new Day03().isNearSymbolInUnderLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_False_2() throws IOException {
        // arrange
        int lineIndex = 7;
        int startIndex = 7;
        int endIndex = 9;

        // act
        boolean result = new Day03().isNearSymbolInUnderLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_False_3() throws IOException {
        // arrange
        int lineIndex = 9;
        int startIndex = 1;
        int endIndex = 3;

        // act
        boolean result = new Day03().isNearSymbolInUnderLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_True() throws IOException {
        // arrange
        int lineIndex = 2;
        int startIndex = 6;
        int endIndex = 8;

        // act
        boolean result = new Day03().isNearSymbolInUnderLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_True2() throws IOException {
        // arrange
        int lineIndex = 2;
        int startIndex = 6;
        int endIndex = 8;

        // act
        new Day03().DayThree();

        // assert
    }

}

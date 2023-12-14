import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Day03Test {

    private final List<String> input = Arrays.asList(
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

    private final Day03 day03 = new Day03(input);

    @Test
    void isCharacterASymbol_True() {

        //Act
        boolean isSymbol = day03.isCharacterASymbol('+');

        //Assert
        assertThat(isSymbol).isTrue();
    }

    @Test
    void isCharacterASymbol_False() {

        //Act
        boolean isSymbol = day03.isCharacterASymbol('.');

        //Assert
        assertThat(isSymbol).isFalse();
    }

    @Test
    void isCharacterASymbol_False2() {

        //Act
        boolean isSymbol = day03.isCharacterASymbol('3');

        //Assert
        assertThat(isSymbol).isFalse();
    }

    @Test
    void isSymbolLeftToIndex() {
        //Act
        boolean result = day03.checkLeft(2, ".*35..633.");

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void isSymbolLeftToIndex_OutOfBounce() {
        //Act
        boolean result = day03.checkLeft(0, "35....633.");

        //Assert
        assertThat(result).isFalse();
    }


    @Test
    void isSymbolRightToIndex() {
        //Act
        boolean result = day03.checkRight(8, "..35..633*");

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    void isSymbolRightToIndex_OutOfBounce() {
        //Act
        boolean result = day03.checkRight(8, "..35..633");

        //Assert
        assertThat(result).isFalse();
    }


    @Test
    void shouldFindAllNumbersInStringLine() {
        //Arrange
        String testLine = "........$..388.........152*141..*......73.719...$526....830...759......%......943............541.624.781...*...$150.............966.........";

        //Act
        List<String> resultList = day03.findNumbers(testLine);

        //Assert
        assertThat(resultList).hasSize(14);
    }

    @Test
    void shouldFindSymbolInAdjacentLineNearNumber_True() {
        //Arrange
        int lineIndex = 0;
        int startIndex = 0;
        int endIndex = 3;

        //Act
        boolean hasNearSymbol = day03.isNearSymbolInAdjacentLine(input, lineIndex, startIndex, endIndex);

        //Assert
        assertThat(hasNearSymbol).isTrue();
    }


    @Test
    void shouldFindSymbolInAdjacentLineNearNumber_False() {
        //Arrange
        int lineIndex = 7;
        int startIndex = 7;
        int endIndex = 9;

        //Act
        boolean hasNearSymbol = day03.isNearSymbolInAdjacentLine(input, lineIndex, startIndex, endIndex);

        //Assert
        assertThat(hasNearSymbol).isFalse();
    }

    @Test
    void shouldFindSymbolInSameLineNearNumber() {
        // act
        boolean result = day03.isNearSymbolInSameLine("617*......", 0, 2);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_False_1() {
        // arrange
        int lineIndex = 4;
        int startIndex = 0;
        int endIndex = 2;

        // act
        boolean result = day03.isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_True() {
        // arrange
        int lineIndex = 6;
        int startIndex = 2;
        int endIndex = 4;

        // act
        boolean result = day03.isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_False_2() {
        // arrange
        int lineIndex = 0;
        int startIndex = 0;
        int endIndex = 2;

        // act
        boolean result = day03.isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInAboveLineNearNumber_False_3() {
        // arrange
        int lineIndex = 7;
        int startIndex = 7;
        int endIndex = 9;

        // act
        boolean result = day03.isNearSymbolInAboveLine(input, lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_False_1() {
        // arrange
        int lineIndex = 2;
        int startIndex = 2;
        int endIndex = 3;

        // act
        boolean result = day03.isNearSymbolInUnderLine(lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_False_2() {
        // arrange
        int lineIndex = 7;
        int startIndex = 7;
        int endIndex = 9;

        // act
        boolean result = day03.isNearSymbolInUnderLine(lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_False_3() {
        // arrange
        int lineIndex = 9;
        int startIndex = 1;
        int endIndex = 3;

        // act
        boolean result = day03.isNearSymbolInUnderLine(lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isFalse();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_True() {
        // arrange
        int lineIndex = 2;
        int startIndex = 6;
        int endIndex = 8;

        // act
        boolean result = day03.isNearSymbolInUnderLine(lineIndex, startIndex, endIndex);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void shouldFindSymbolInUnderLineNearNumber_True2() {
        // arrange
        int lineIndex = 2;
        int startIndex = 6;
        int endIndex = 8;

        // act
        day03.dayThree();

        // assert
    }

}

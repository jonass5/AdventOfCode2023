import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day06Test {

//    private final List<String> input = Arrays.asList(
//            "Time:      7  15   30",
//            "Distance:  9  40  200"
//    );

    @Test
    void calculateBoatDistance_hold_3() {
        //Arrange
        int time = 7;
        int holdTime = 3;

        //Act
        int result = new Day06().calculateBoatDistance(time, holdTime);

        //Assert
        assertThat(result).isEqualTo(12);
    }

    @Test
    void calculateBoatDistance_hold_7() {
        //Arrange
        int time = 7;
        int holdTime = 7;

        //Act
        int result = new Day06().calculateBoatDistance(time, holdTime);

        //Assert
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculateBoatDistance_hold_0() {
        //Arrange
        int time = 7;
        int holdTime = 0;

        //Act
        int result = new Day06().calculateBoatDistance(time, holdTime);

        //Assert
        assertThat(result).isEqualTo(0);
    }
}

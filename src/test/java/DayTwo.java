import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class DayTwo {

    @Test
    void DayTwo() throws IOException {


        int summary = 0;
        int summaryPart2 = 0;

        List<String> input = Utils.readFile(Paths.get("src/test/resources/DayTwo.txt"));

        for (String line : input) {

            int gameNumber = getGameNumber(line);
            String gameString = getGameString(line);


            if (isGamePossible(gameString)) {
                summary += gameNumber;
            }


            summaryPart2 += powerOfGame(gameString);
        }

        System.out.println(summary);
        System.out.println(summaryPart2);

    }

    private String getGameString(String line) {
        int indexOfDoublePoint = line.indexOf(":");
        return line.substring(indexOfDoublePoint + 2);
    }

    private int powerOfGame(String gameString) {
        int maxRed = 1;
        int maxGreen = 1;
        int maxBlue = 1;

        System.out.println(gameString);

        String[] gameSets = gameString.split(";");

        for (String gameSet : gameSets) {
            String[] differentColors = gameSet.trim().split(",");

            for (String color : differentColors) {
                String trimmedColor = color.trim();

                if (trimmedColor.contains("red")) {
                    int foundNumber = filterNumbers(color);
                    if (foundNumber > maxRed) {
                        maxRed = foundNumber;
                    }

                } else if (trimmedColor.contains("green")) {
                    int foundNumber = filterNumbers(color);
                    if (foundNumber > maxGreen) {
                        maxGreen = foundNumber;
                    }
                } else if (trimmedColor.contains("blue")) {
                    int foundNumber = filterNumbers(color);
                    if (foundNumber > maxBlue) {
                        maxBlue = foundNumber;
                    }
                }
            }
        }

        System.out.println("Red: " + maxRed + ", Green: " + maxGreen + ", Blue: " + maxBlue);

        return maxRed * maxGreen * maxBlue;
    }

    private boolean isGamePossible(String gameString) {
        int limitRed = 12;
        int limitGreen = 13;
        int limitBlue = 14;

        String[] gameSets = gameString.split(";");

        for (String gameSet : gameSets) {
            String[] differentColors = gameSet.trim().split(",");

            for (String color : differentColors) {
                String trimmedColor = color.trim();
                if (trimmedColor.contains("red")) {
                    if (filterNumbers(trimmedColor) > limitRed) {
                        return false;
                    }

                } else if (trimmedColor.contains("green")) {
                    if (filterNumbers(trimmedColor) > limitGreen) {
                        return false;
                    }

                } else if (trimmedColor.contains("blue")) {
                    if (filterNumbers(trimmedColor) > limitBlue) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private int filterNumbers(String color) {
        StringBuilder numbers = new StringBuilder();

        for (int i = 0; i < color.length(); i++) {
            char currentChar = color.charAt(i);

            if (Character.isDigit(currentChar)) {
                numbers.append(currentChar);
            }

        }

        return Integer.parseInt(numbers.toString());
    }

    private int getGameNumber(String line) {
        int indexOfDoublePoint = line.indexOf(":");
        int indexOfWhiteSpace = line.indexOf(" ");

        String number = line.substring(indexOfWhiteSpace + 1, indexOfDoublePoint);

        return Integer.parseInt(number);
    }


}

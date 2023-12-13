import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _DayThree {


    private List<String> input = Utils.readFile("DayThree.txt");

    @Test
    void DayThree() throws IOException {

        int sum = 0;
        int numNum = 0;
        int foundNum = 0;
        int addedNum = 0;

        for (int inputLineCounter = 0; inputLineCounter < input.size(); inputLineCounter++) {
            String currentLine = input.get(inputLineCounter);

            List<String> neededNum = findNumber(currentLine);
            numNum += neededNum.size();

            for (int lineCounter = 0; lineCounter < currentLine.length(); lineCounter++) {
                char currentChar = currentLine.charAt(lineCounter);

                if (Character.isDigit(currentChar)) {
                    String number = "";
                    int firstIndex = lineCounter;

                    for (int numberIndexCounter = lineCounter; numberIndexCounter < currentLine.length(); numberIndexCounter++) {
                        currentChar = currentLine.charAt(numberIndexCounter);

                        if (Character.isDigit(currentChar)) {
                            number += currentChar;

                            if (numberIndexCounter < 139) {
                                continue;
                            }

                        }

                        neededNum.remove(number);
                        foundNum++;
                        if (isNearSymbol(inputLineCounter, firstIndex, numberIndexCounter - 1)) {
                            addedNum++;
                            sum += Integer.parseInt(number);
                        }

                        lineCounter = numberIndexCounter;

                        break;
                    }
                }
            }

            if (!neededNum.isEmpty()) {
                System.out.println(currentLine);
                System.out.println(neededNum);
            }

        }

        System.out.println("Found Numbers: " + numNum);
        System.out.println("Checked Numbers: " + foundNum);
        System.out.println("Added Numbers: " + addedNum);
        System.out.println("Sum of all added Numbers: " + sum);

    }

    private boolean isNearSymbol(int currentLineNumber, int firstIndex, int lastIndex) {
        String currentLine = input.get(currentLineNumber);

        if (checkLeftRight(firstIndex, lastIndex, currentLine)) {
            return true;
        }

        if (checkOverUnderLine(currentLineNumber, firstIndex, lastIndex)) {
            return true;
        }

        return false;
    }

    private boolean checkLeftRight(int firstIndex, int lastIndex, String currentLine) {
        if (firstIndex > 0) {
            if (!Character.isDigit(currentLine.charAt(firstIndex - 1)) && !Character.toString(currentLine.charAt(firstIndex - 1)).contains(".")) {
                return true;
            }
        }

        if (lastIndex < input.size()) {
            if (!Character.isDigit(currentLine.charAt(lastIndex + 1)) && !Character.toString(currentLine.charAt(lastIndex + 1)).contains(".")) {
                return true;
            }
        }


        return false;
    }

    private boolean checkOverUnderLine(int currentLineNumber, int firstIndex, int lastIndex) {

        if (currentLineNumber > 0) {
            String lineOver = input.get(currentLineNumber - 1).substring(maxOrValue(firstIndex - 1), maxOrValue(lastIndex + 1));

            for (char c : lineOver.toCharArray()) {
                if (!Character.isDigit(c) && !Character.toString(c).contains(".")) {
                    return true;
                }
            }
        }

        if (currentLineNumber < input.size() - 1) {
            String lineUnder = input.get(currentLineNumber + 1).substring(maxOrValue(firstIndex - 1), maxOrValue(lastIndex + 1));

            for (char c : lineUnder.toCharArray()) {
                if (!Character.isDigit(c) && !Character.toString(c).contains(".")) {
                    return true;
                }
            }
        }

        return false;
    }

    private int maxOrValue(int value) {
        if (value > 139) {
            return 139;
        }

        return Math.max(value, 0);
    }

    private List<String> findNumber(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);

        List<String> numbers = new ArrayList<>();

        while (m.find()) {
            numbers.add(m.group());
        }

//        System.out.println(numbers);

        return numbers;

//        if (numbers.isEmpty() || numbers.stream()
//                .filter(i -> Collections.frequency(numbers, i) > 1)
//                .collect(Collectors.toSet()).size() > 0) {
//            System.out.println("ERROR!");
//            System.out.println(line);
//            System.out.println(numbers);
//
//        }

    }

}

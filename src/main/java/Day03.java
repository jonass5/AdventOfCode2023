import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {


    private List<String> input = Utils.readFile("DayThree.txt");

    void DayThree() {

        int sum = 0;

        for (int inputLineCounter = 0; inputLineCounter < input.size(); inputLineCounter++) {
            String currentLine = input.get(inputLineCounter);

            List<String> numbersInLine = findNumbers(currentLine);
            System.out.println(numbersInLine);

            for (String number : numbersInLine) {

                System.out.println(currentLine);

                int startIndex = currentLine.indexOf(number);
                int endIndex = startIndex + number.length();

                System.out.println(startIndex + ", " + endIndex);

                if (isNearSymbol(inputLineCounter, startIndex, endIndex)) {
                    System.out.println(Integer.parseInt(number));
                    sum += Integer.parseInt(number);
                }

                currentLine = currentLine.substring(endIndex);
            }
        }
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

    private List<String> findNumbers(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);

        List<String> numbers = new ArrayList<>();

        while (m.find()) {
            numbers.add(m.group());
        }

        return numbers;

    }

}

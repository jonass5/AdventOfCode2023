import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private List<String> input;

    public Day03() throws IOException {
        input = Utils.readFile(Paths.get("src/main/resources/DayThree.txt"));
    }

    public int DayThree() {
        int sum = 0;

        for (int inputLineCounter = 0; inputLineCounter < input.size(); inputLineCounter++) {
            String currentLine = input.get(inputLineCounter);

            List<String> numbersInLine = findNumbers(currentLine);

            sum += sumAllNumbersThatAreNearSymbol(inputLineCounter, currentLine, numbersInLine);
        }

        return sum;
    }

    private int sumAllNumbersThatAreNearSymbol(int inputLineCounter, String currentLine, List<String> numbersInLine) {
        int sum = 0;
        for (String number : numbersInLine) {

            System.out.println(currentLine);

            int startIndex = currentLine.indexOf(number);
            int endIndex = startIndex + number.length();

            System.out.println(startIndex + ", " + endIndex);

            if (isNearSymbolInSameLine(currentLine, startIndex, endIndex)) {
                System.out.println(Integer.parseInt(number));
                sum += Integer.parseInt(number);
            }

            currentLine = currentLine.substring(endIndex);
        }
        return sum;
    }


    public boolean isNearSymbolInSameLine(String currentLine, int firstIndex, int lastIndex) {
        return checkLeft(firstIndex, currentLine) || checkRight(lastIndex, currentLine);
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

    public List<String> findNumbers(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);

        List<String> numbers = new ArrayList<>();

        while (m.find()) {
            numbers.add(m.group());
        }

        return numbers;
    }

    public boolean isCharacterASymbol(char c) {
        return !Character.isDigit(c) && !Character.toString(c).contains(".");
    }

    public boolean checkLeft(int startIndex, String line) {
        if (startIndex > 0) {
            return isCharacterASymbol(line.charAt(startIndex - 1));
        }

        return false;
    }

    public boolean checkRight(int index, String line) {
        if (index + 1 < line.length()) {
            return isCharacterASymbol(line.charAt(index + 1));
        }

        return false;
    }

    public boolean isNearSymbolInAboveLine(List<String> input, int lineIndex, int startIndex, int endIndex) {
        String lineOver = input.get(lineIndex - 1).substring(startIndex - 1, endIndex + 2);

        for (char currentChar : lineOver.toCharArray()) {
            if (isCharacterASymbol(currentChar)) {
                return true;
            }

        }

        return false;
    }
}

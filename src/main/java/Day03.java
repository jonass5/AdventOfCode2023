import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private final List<String> input;

    public Day03(List<String> input) {
        this.input = input;
    }

    public int DayThree() {
        int sum = 0;

        for (int inputLineCounter = 0; inputLineCounter < input.size(); inputLineCounter++) {
            String currentLine = input.get(inputLineCounter);
            List<String> numbersInLine = findNumbers(currentLine);

            sum += sumAllNumbersThatAreNearSymbol(inputLineCounter, numbersInLine);
        }

        System.out.println(sum);

        return sum;
    }

    public int sumAllNumbersThatAreNearSymbol(int lineIndex, List<String> numbersInLine) {
        int sumOfNumbers = 0;
        int lineOffSet = 0;
        String currentLine = input.get(lineIndex);

        for (String number : numbersInLine) {

            int startIndex = currentLine.indexOf(number);
            int endIndex = startIndex + number.length();

            if (isNearSymbolInSameLine(currentLine, startIndex, endIndex) || isNearSymbolInAdjacentLine(input, lineIndex, lineOffSet + startIndex, lineOffSet + endIndex)) {
                sumOfNumbers += Integer.parseInt(number);
            }

            currentLine = currentLine.substring(endIndex);
            lineOffSet = endIndex;
        }

        return sumOfNumbers;
    }


    public boolean isNearSymbolInSameLine(String currentLine, int firstIndex, int lastIndex) {
        return checkLeft(firstIndex, currentLine) || checkRight(lastIndex, currentLine);
    }

    public boolean isNearSymbolInAdjacentLine(List<String> inputLines, int lineIndex, int firstIndex, int lastIndex) {
        return isNearSymbolInUnderLine(lineIndex, firstIndex, lastIndex) || isNearSymbolInAboveLine(inputLines, lineIndex, lastIndex, lastIndex);
    }

//    private boolean checkOverUnderLine(int currentLineNumber, int firstIndex, int lastIndex) {
//
//        if (currentLineNumber > 0) {
//            String lineOver = input.get(currentLineNumber - 1).substring(maxOrValue(firstIndex - 1), maxOrValue(lastIndex + 1));
//
//            for (char c : lineOver.toCharArray()) {
//                if (!Character.isDigit(c) && !Character.toString(c).contains(".")) {
//                    return true;
//                }
//            }
//        }
//
//        if (currentLineNumber < input.size() - 1) {
//            String lineUnder = input.get(currentLineNumber + 1).substring(maxOrValue(firstIndex - 1), maxOrValue(lastIndex + 1));
//
//            for (char c : lineUnder.toCharArray()) {
//                if (!Character.isDigit(c) && !Character.toString(c).contains(".")) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }

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
        if (lineIndex > 1) {
            String lineOver = input.get(lineIndex - 1).substring(Math.max(startIndex - 1, 0), Math.min(endIndex + 2, input.size()));

            for (char currentChar : lineOver.toCharArray()) {
                if (isCharacterASymbol(currentChar)) {
                    return true;
                }

            }
        }

        return false;
    }

    public boolean isNearSymbolInUnderLine(int lineIndex, int startIndex, int endIndex) {
        if (lineIndex < input.size() - 1) {
            String lineOver = input.get(lineIndex + 1).substring(Math.max(startIndex - 1, 0), Math.min(endIndex + 2, input.size()));

            for (char currentChar : lineOver.toCharArray()) {
                if (isCharacterASymbol(currentChar)) {
                    return true;
                }
            }
        }

        return false;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {

    private final List<String> input;

    public Day03(List<String> input) {
        this.input = input;
    }

    public int summerizeAllPartnerNumbers() {
        int sum = 0;

        List<PartNumber> partNumberList = findAllPartNumbers();
        List<PartNumber> filteredPartNumbers = filterPartNumbers(partNumberList);

        for (PartNumber partNumber : filteredPartNumbers) {
            sum += Integer.parseInt(partNumber.getNumber());
        }

        return sum;
    }

//    public int sumAllNumbersThatAreNearSymbolInLine(int lineIndex, List<String> numbersInLine) {
//        int sumOfNumbers = 0;
//        int lineOffSet = 0;
//        String currentLine = input.get(lineIndex);
//
//        for (String number : numbersInLine) {
//
//            int startIndex = currentLine.indexOf(number);
//            int endIndex = startIndex + number.length();
//
//            if (isNearSymbolInSameLine(currentLine, startIndex, endIndex) || isNearSymbolInAdjacentLine(lineIndex, lineOffSet + startIndex, lineOffSet + endIndex)) {
//                sumOfNumbers += Integer.parseInt(number);
//            }
//
//            currentLine = currentLine.substring(endIndex);
//            lineOffSet = endIndex;
//        }
//
//        return sumOfNumbers;
//    }


    public boolean isNearSymbolInSameLine(String currentLine, int firstIndex, int lastIndex) {
        return checkLeft(firstIndex, currentLine) || checkRight(lastIndex, currentLine);
    }

    public boolean isNearSymbolInAdjacentLine(int lineIndex, int firstIndex, int lastIndex) {
        return isNearSymbolInUnderLine(lineIndex, firstIndex, lastIndex) || isNearSymbolInAboveLine(lineIndex, firstIndex, lastIndex);
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

    public boolean isNearSymbolInAboveLine(int lineIndex, int startIndex, int endIndex) {
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

    public List<PartNumber> findAllPartNumbers() {
        List<PartNumber> partNumbers = new ArrayList<>();
        for (int inputLineCounter = 0; inputLineCounter < input.size(); inputLineCounter++) {
            String currentLine = input.get(inputLineCounter);
            List<String> numbersInLine = findNumbers(currentLine);
            List<PartNumber> linePartNumbers = new ArrayList<>();
            int lineOffset = 0;

            for (int i = 0; i < numbersInLine.size(); i++) {
                String number = numbersInLine.get(i);
                int startIndex = currentLine.substring(lineOffset).indexOf(number) + lineOffset;
                linePartNumbers.add(new PartNumber(inputLineCounter, startIndex, number));
                lineOffset = startIndex + number.length() - 1;
            }

            partNumbers.addAll(linePartNumbers);

        }
        return partNumbers;
    }

    public boolean hasDuplicateNumbers(List<PartNumber> partNumberList) {
        return partNumberList.stream().map(PartNumber::getNumber).distinct().count() != partNumberList.size();
    }

    public List<PartNumber> filterPartNumbers(List<PartNumber> partNumbers) {

        List<PartNumber> filteredPartNumberList = new ArrayList<>();

        for (PartNumber partNumber : partNumbers) {
            int endIndex = partNumber.getStartIndex() + (partNumber.getNumber().length() - 1);
            String currentLine = input.get(partNumber.getLineIndex());
            if (isNearSymbolInSameLine(currentLine, partNumber.getStartIndex(), endIndex)
                    || isNearSymbolInAdjacentLine(partNumber.getLineIndex(), partNumber.getStartIndex(), endIndex)) {
                filteredPartNumberList.add(partNumber);
            }
        }

        return filteredPartNumberList;
    }
}

class PartNumber {

    private final int lineIndex;
    private final int startIndex;
    private final String number;

    public PartNumber(int lineIndex, int startIndex, String number) {
        this.lineIndex = lineIndex;
        this.startIndex = startIndex;

        this.number = number;
    }

    public int getLineIndex() {
        return lineIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PartNumber{" +
                "lineIndex=" + lineIndex +
                ", startIndex=" + startIndex +
                ", number='" + number + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartNumber that = (PartNumber) o;

        if (lineIndex != that.lineIndex) return false;
        if (startIndex != that.startIndex) return false;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        int result = lineIndex;
        result = 31 * result + startIndex;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        return result;
    }
}

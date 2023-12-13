import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOne {

    private Map<String, String> numberNameMap = new HashMap<>();

    @Test
    void DayOne() throws IOException {
        numberNameMap.put("one", "1");
        numberNameMap.put("two", "2");
        numberNameMap.put("three", "3");
        numberNameMap.put("four", "4");
        numberNameMap.put("five", "5");
        numberNameMap.put("six", "6");
        numberNameMap.put("seven", "7");
        numberNameMap.put("eight", "8");
        numberNameMap.put("nine", "9");

        List<Integer> sumList = new ArrayList<>();
        List<String> input = Utils.readFile(Paths.get("src/test/resources/DayOne.txt"));

        for (String line : input) {
            sumList.add(getCorrectSumForLine(line));
        }

        int summary = 0;
        for (int sum : sumList) {
            summary += sum;
        }

        System.out.println(summary);
    }


    private int getCorrectSumForLine(String line) {

        StringBuilder filteredNumbers = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);

            if (Character.isDigit(currentChar)) {
                filteredNumbers.append(currentChar);
            }

            for (Map.Entry<String, String> number : numberNameMap.entrySet()) {

                if (line.substring(i).startsWith(number.getKey())) {
                    filteredNumbers.append(number.getValue());
                }
            }
        }

        int sum = Integer.parseInt(filteredNumbers.charAt(0) + String.valueOf(filteredNumbers.charAt(filteredNumbers.length() - 1)));

        if (filteredNumbers.length() < 0) {
            System.out.println(line + ", " + filteredNumbers + ", " + sum);
        }

        return sum;
    }


}
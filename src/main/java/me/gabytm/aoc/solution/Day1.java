package me.gabytm.aoc.solution;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Day1 extends Day {

    public Day1() {
        super(1);
    }

    private String getValue(String number) {
        return switch (number) {
            case "one" -> "1";
            case "two" -> "2";
            case "three" -> "3";
            case "four" -> "4";
            case "five" -> "5";
            case "six" -> "6";
            case "seven" -> "7";
            case "eight" -> "8";
            case "nine" -> "9";
            default -> number;
        };
    }

    private void solveFirstPart() {
        var pattern = Pattern.compile("\\D+");
        var total = 0;

        for (var line : getInput(1, "\n")) {
            var numbers = pattern.matcher(line).replaceAll("");

            var first = numbers.charAt(0);
            var second = numbers.charAt(numbers.length() - 1);

            total += Integer.parseInt(first + "" + second);
        }

        System.out.println("- Part 1: " + total);
    }

    private void solveSecondPart() {
        var pattern = Pattern.compile("(?=(\\d|one|two|three|four|five|six|seven|eight|nine))");
        var total = 0;

        for (var line : getInput(1, "\n")) {
            var matcher = pattern.matcher(line);
            var numbers = new ArrayList<String>();

            while (matcher.find()) {
                numbers.add(matcher.group(1));
            }

            var first = getValue(numbers.get(0));
            var second = getValue(numbers.get(numbers.size() - 1));

            total += Integer.parseInt(first + second);
        }

        System.out.println("- Part 2: " + total);
    }

    @Override
    void solve() {
        solveFirstPart();
        solveSecondPart();
    }

}

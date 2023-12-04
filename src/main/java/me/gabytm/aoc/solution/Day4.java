package me.gabytm.aoc.solution;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day4 extends Day {

    public Day4() {
        super(4);
    }

    @Override
    void solve() {
        solveFirstPart();
    }

    private void solveFirstPart() {
        var parseFunction = (Function<String, Set<Integer>>) string -> Arrays.stream(string.split(" +"))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());

        var total = Arrays.stream(getInput(1, "\n"))
            .map(line -> line.split(":")[1])
            .map(String::trim)
            .map(numbers -> numbers.split(" \\| "))
            .map(numbers -> {
                var winningNumbers = parseFunction.apply(numbers[0].trim());
                var pickedNumbers = parseFunction.apply(numbers[1].trim());

                return (int) pickedNumbers.stream()
                    .filter(winningNumbers::contains)
                    .count();
            })
            .mapToInt(count -> (int) Math.pow(2, count - 1))
            .sum();

        System.out.println("- Part 1: " + total);
    }

}

package me.gabytm.aoc.solution;

public class Day2 extends Day {

    private static final int MAX_RED = 12;
    private static final int MAX_GREEN = 13;
    private static final int MAX_BLUE = 14;

    public Day2() {
        super(2);
    }

    private boolean canBePlayed(final String[] sets) {
        for (var set : sets) {
            for (var cube : set.split(", ")) {
                var cubeParts = cube.trim().split(" ");

                var amount = Integer.parseInt(cubeParts[0]);
                var color = cubeParts[1];

                var maxForColor = switch (color) {
                    case "red" -> MAX_RED;
                    case "green" -> MAX_GREEN;
                    case "blue" -> MAX_BLUE;
                    default -> throw new IllegalArgumentException(color);
                };

                if (amount > maxForColor) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getPower(final String[] sets) {
        var requiredRed = 0;
        var requiredGreen = 0;
        var requiredBlue = 0;

        for (var set : sets) {
            for (var cube : set.split(", ")) {
                var cubeParts = cube.trim().split(" ");

                var amount = Integer.parseInt(cubeParts[0]);
                var color = cubeParts[1];

                switch (color) {
                    case "red" -> requiredRed = Math.max(requiredRed, amount);
                    case "green" -> requiredGreen = Math.max(requiredGreen, amount);
                    case "blue" -> requiredBlue = Math.max(requiredBlue, amount);
                }
            }
        }

        return requiredRed * requiredGreen * requiredBlue;
    }

    private void solveFirstPart() {
        var sum = 0;

        for (var line : getInput(1, "\n")) {
            var colonIndex = line.indexOf(':');
            // Colon is followed by a space "Game x: y green"
            var sets = line.substring(colonIndex + 2).split(";");

            if (canBePlayed(sets)) {
                var gameNumber = Integer.parseInt(line.substring(5, colonIndex));
                sum += gameNumber;
            }
        }

        System.out.println("- Part 1: " + sum);
    }

    private void solveSecondPart() {
        var sum = 0;

        for (var line : getInput(1, "\n")) {
            var colonIndex = line.indexOf(':');
            // Colon is followed by a space "Game x: y green"
            var sets = line.substring(colonIndex + 2).split(";");

            sum += getPower(sets);
        }

        System.out.println("- Part 2: " + sum);
    }

    @Override
    void solve() {
        solveFirstPart();
        solveSecondPart();
    }

}

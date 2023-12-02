package me.gabytm.aoc.solution;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class Day {

    protected final int number;

    public Day(final int number) {
        this.number = number;
        System.out.println("Day " + number + ":");
        var start = System.currentTimeMillis();
        solve();
        System.out.println("= Solved in " + (System.currentTimeMillis() - start) + "ms\n");
    }

    protected final String getInput(final int part) {
        try {
            return new String(this.getClass().getResourceAsStream("/%d.%d.txt".formatted(number, part)).readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected final String[] getInput(final int part, final String regex) {
        return getInput(part).split(regex);
    }

    abstract void solve();

}

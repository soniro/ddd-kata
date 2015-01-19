package de.munich.softwerkskammer;

import java.util.ArrayList;
import java.util.List;

public class Rolls {

    private static final int MAXIMAL_NUMBER_OF_ROLLS = 2;
    private static final int DEFAULT_NUMBER_OF_ADDITIONAL_ROLLS = 0;

    final int allowedNumberOfAdditionalRolls;
    final List<Integer> rolls;

    public Rolls() {
        this(DEFAULT_NUMBER_OF_ADDITIONAL_ROLLS);
    }

    public Rolls(int allowedNumberOfAdditionalRolls) {
        this.allowedNumberOfAdditionalRolls = allowedNumberOfAdditionalRolls;
        this.rolls = new ArrayList<>(MAXIMAL_NUMBER_OF_ROLLS + allowedNumberOfAdditionalRolls);
    }

    public void add(int pins) {
        rolls.add(pins);
    }

    public boolean full() {
        return hasSize(MAXIMAL_NUMBER_OF_ROLLS);
    }

    public boolean fullWithAdditionalRowAllowed() {
        return hasSize(MAXIMAL_NUMBER_OF_ROLLS + allowedNumberOfAdditionalRolls);
    }

    public int sum() {
        return first() + second();
    }

    public int sumWithAdditionalRolls() {
        return rolls.stream().mapToInt(i -> i).sum();
    }

    public int first() {
        return rolls.isEmpty() ? 0 : rolls.get(0);
    }

    public int second() {
        return rolls.size() < 2 ? 0 : rolls.get(1);
    }

    private boolean hasSize(int size) {
        return rolls.size() == size;
    }
}

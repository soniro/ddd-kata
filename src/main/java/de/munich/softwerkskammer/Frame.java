package de.munich.softwerkskammer;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    protected static final int MAXIMUM_NUMBER_OF_PINS = 10;
    protected static final int MAXIMUM_NUMBER_OF_FRAMES = 10;

    final List<Integer> rolls = new ArrayList<>(2);
    final int frameNumber;
    Frame nextFrame;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    public void roll(int pins) {
        if (frameComplete() && nextFrame == null) initNextFrame();
        if (frameComplete()) nextFrame.roll(pins);
        else if (rollIsValid(pins)) rolls.add(pins);
        else throw new RuntimeException("Invalid roll! Too many pins in frame.");
    }

    public int score() {
        if (strike() && nextFrame ==null) return MAXIMUM_NUMBER_OF_PINS;
        else if (strike()) return MAXIMUM_NUMBER_OF_PINS + nextFrame.strikeBonus();
        else if (spare()) return MAXIMUM_NUMBER_OF_PINS + nextFrame.spareBonus();
        else return sumOfRolls();
    }

    private void initNextFrame() {
        if (frameNumber == MAXIMUM_NUMBER_OF_FRAMES - 1) nextFrame = new LastFrame();
        else nextFrame = new Frame(frameNumber + 1);
    }

    protected boolean frameComplete() {
        return strike() || rolls.size() == 2;
    }

    protected boolean strike() {
        return !rolls.isEmpty() && rolls.get(0) == MAXIMUM_NUMBER_OF_PINS;
    }

    protected boolean spare() {
        return !strike() && frameComplete() && sumOfRolls() == MAXIMUM_NUMBER_OF_PINS;
    }

    protected int strikeBonus() {
        if (strike() && nextFrame == null) return MAXIMUM_NUMBER_OF_PINS;
        else if (strike()) return MAXIMUM_NUMBER_OF_PINS + nextFrame.spareBonus();
        else return sumOfRolls();
    }

    private int spareBonus() {
        return rolls.get(0);
    }

    protected int sumOfRolls() {
        if (rolls.size() == 0) return 0;
        if (rolls.size() == 1) return rolls.get(0);
        else return rolls.get(0) + rolls.get(1);
    }

    public Frame nextFrame() {
        return nextFrame;
    }

    public boolean lastFrame() {
        return nextFrame == null;
    }

    protected boolean rollIsValid(int pins) {
        return pins <= MAXIMUM_NUMBER_OF_PINS && (rolls.isEmpty() || rolls.get(0) + pins <= MAXIMUM_NUMBER_OF_PINS);
    }
}

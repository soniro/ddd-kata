package de.munich.softwerkskammer;

public class Frame {

    protected static final int MAXIMUM_NUMBER_OF_PINS = 10;
    protected static final int MAXIMUM_NUMBER_OF_FRAMES = 10;

    final int frameNumber;
    Rolls rolls;
    Frame nextFrame;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        this.rolls = new Rolls();
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
        else return rolls.sum();
    }

    private void initNextFrame() {
        if (frameNumber == MAXIMUM_NUMBER_OF_FRAMES - 1) nextFrame = new LastFrame();
        else nextFrame = new Frame(frameNumber + 1);
    }

    protected boolean frameComplete() {
        return strike() || rolls.full();
    }

    protected boolean strike() {
        return rolls.first() == MAXIMUM_NUMBER_OF_PINS;
    }

    protected boolean spare() {
        return !strike() && rolls.sum() == MAXIMUM_NUMBER_OF_PINS;
    }

    protected int strikeBonus() {
        if (strike() && nextFrame == null) return MAXIMUM_NUMBER_OF_PINS;
        else if (strike()) return MAXIMUM_NUMBER_OF_PINS + nextFrame.spareBonus();
        else return rolls.sum();
    }

    private int spareBonus() {
        return rolls.first();
    }

    public Frame nextFrame() {
        return nextFrame;
    }

    public boolean lastFrame() {
        return nextFrame == null;
    }

    protected boolean rollIsValid(int pins) {
        return pins <= MAXIMUM_NUMBER_OF_PINS && rolls.first() + pins <= MAXIMUM_NUMBER_OF_PINS;
    }
}

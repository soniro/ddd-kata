package de.munich.softwerkskammer;

public class LastFrame extends Frame {

    public LastFrame() {
        super(MAXIMUM_NUMBER_OF_FRAMES);
        rolls = new Rolls(1);
    }

    @Override
    public void roll(int pins) {
        if (frameComplete()) throw new RuntimeException("The game is over. Start a new one.");
        else if (rollIsValid(pins)) rolls.add(pins);
        else throw new RuntimeException("Invalid roll! Too many pins in frame.");
    }

    @Override
    protected boolean frameComplete() {
        return needsExtraRoll() ? rolls.fullWithAdditionalRowAllowed() : rolls.full();
    }

    @Override
    public int score() {
        return rolls.sumWithAdditionalRolls();
    }

    @Override
    protected boolean spare() {
        return (rolls.full() || rolls.fullWithAdditionalRowAllowed()) && rolls.sum() == MAXIMUM_NUMBER_OF_PINS;
    }

    @Override
    protected int strikeBonus() {
        return rolls.sum();
    }

    @Override
    protected boolean rollIsValid(int pins) {
       return pins <= MAXIMUM_NUMBER_OF_PINS && (spare() || strike() || rolls.first() + pins <= MAXIMUM_NUMBER_OF_PINS);
    }

    private boolean needsExtraRoll() {
        return strike() || spare();
    }

}

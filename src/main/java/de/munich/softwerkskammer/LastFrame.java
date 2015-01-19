package de.munich.softwerkskammer;

public class LastFrame extends Frame {

    public LastFrame() {
        super(MAXIMUM_NUMBER_OF_FRAMES);
    }

    @Override
    public void roll(int pins) {
        if (frameComplete()) throw new RuntimeException("The game is over. Start a new one.");
        else if (rollIsValid(pins)) rolls.add(pins);
        else throw new RuntimeException("Invalid roll! Too many pins in frame.");
    }

    @Override
    protected boolean frameComplete() {
        int needsExtraRoll = needsExtraRoll() ? 1 : 0;
        return rolls.size() == 2 + needsExtraRoll;
    }

    @Override
    public int score() {
        return rolls.stream().mapToInt(i -> i).sum();
    }

    @Override
    protected boolean spare() {
        return rolls.size() >= 2 && sumOfRolls() == MAXIMUM_NUMBER_OF_PINS;
    }

    @Override
    protected int strikeBonus() {
        if (rolls.size() == 0) return 0;
        if (rolls.size() == 1) return rolls.get(0);
        else return sumOfRolls();
    }

    @Override
    protected boolean rollIsValid(int pins) {
       return pins <= MAXIMUM_NUMBER_OF_PINS && (rolls.isEmpty() || rolls.size() == 2 || strike() || rolls.get(0) + pins <= MAXIMUM_NUMBER_OF_PINS);
    }

    private boolean needsExtraRoll() {
        return strike() || spare();
    }

}

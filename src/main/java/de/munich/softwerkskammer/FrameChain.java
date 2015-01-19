package de.munich.softwerkskammer;

public class FrameChain {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int numberOfPinsForRoll(int frameIndex) {
        return rolls[frameIndex];
    }
}

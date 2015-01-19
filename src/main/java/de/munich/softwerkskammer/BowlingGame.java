package de.munich.softwerkskammer;

public class BowlingGame {

    FrameChain frameChain = new FrameChain();

    public void roll(int pins) {
        frameChain.roll(pins);
    }

    public int score() {
        return frameChain.score();
    }

}
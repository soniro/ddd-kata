package de.munich.softwerkskammer;

public class BowlingGame {

    FrameChain frameChain = new FrameChain();

    public void roll(int pins) {
        frameChain.roll(pins);
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int frameIndex) {
        return frameChain.numberOfPinsForRoll(frameIndex) == 10;
    }

    private boolean isSpare(int frameIndex) {
        return frameChain.numberOfPinsForRoll(frameIndex) + frameChain.numberOfPinsForRoll(frameIndex + 1) == 10;
    }

    private int strikeBonus(int frameIndex) {
        return frameChain.numberOfPinsForRoll(frameIndex + 1) + frameChain.numberOfPinsForRoll(frameIndex + 2);
    }

    private int spareBonus(int frameIndex) {
        return frameChain.numberOfPinsForRoll(frameIndex + 2);
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return frameChain.numberOfPinsForRoll(frameIndex) + frameChain.numberOfPinsForRoll(frameIndex + 1);
    }

}
package de.munich.softwerkskammer;

public class FrameChain {

    Frame firstFrame = new Frame();

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        firstFrame.roll(pins);
        rolls[currentRoll++] = pins;
    }

    public int numberOfPinsForRoll(int frameIndex) {
        return rolls[frameIndex];
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
        return numberOfPinsForRoll(frameIndex) == 10;
    }

    private boolean isSpare(int frameIndex) {
        return numberOfPinsForRoll(frameIndex) + numberOfPinsForRoll(frameIndex + 1) == 10;
    }

    private int strikeBonus(int frameIndex) {
        return numberOfPinsForRoll(frameIndex + 1) + numberOfPinsForRoll(frameIndex + 2);
    }

    private int spareBonus(int frameIndex) {
        return numberOfPinsForRoll(frameIndex + 2);
    }

    private int sumOfBallsInFrame(int frameIndex) {
        return numberOfPinsForRoll(frameIndex) + numberOfPinsForRoll(frameIndex + 1);
    }
}

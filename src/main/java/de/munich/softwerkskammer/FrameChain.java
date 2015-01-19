package de.munich.softwerkskammer;

public class FrameChain {

    Frame firstFrame = new Frame(1);

    public void roll(int pins) {
        firstFrame.roll(pins);
    }

    public int score() {
        return score(firstFrame);
    }

    private int score(Frame frame) {
        if (frame.lastFrame()) return frame.score();
        else return frame.score() + score(frame.nextFrame());
    }
}

package de.munich.softwerkskammer;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private static final int MAXIMUM_NUMBER_OF_PINS = 10;

    final List<Integer> rolls = new ArrayList<>(2);
    Frame nextFrame;

    public void roll(int pins) {
        if (isFrameComplete() && nextFrame == null) nextFrame = new Frame();
        if (isFrameComplete()) nextFrame.roll(pins);
        else rolls.add(pins);
    }

    private boolean isFrameComplete() {
        return isStrike() || rolls.size() == 2;
    }

    private boolean isStrike() {
        return !rolls.isEmpty() && rolls.get(0) == MAXIMUM_NUMBER_OF_PINS;
    }
}

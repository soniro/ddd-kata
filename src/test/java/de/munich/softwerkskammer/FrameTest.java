package de.munich.softwerkskammer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FrameTest {

    @Test
    public void nextToLastFrameReturnsCorrectStrikeScore() {
        // next to last frame
        Frame frame = new Frame(9);
        frame.roll(10);
        // last frame
        frame.roll(10);
        frame.roll(10);
        frame.roll(10);

        assertEquals(30, frame.score());
    }

    @Test(expected = RuntimeException.class)
    public void firstTwoRollsCombinedMayNotHaveMoreThanTenPins() {
        Frame frame = new Frame(1);
        frame.roll(7);
        frame.roll(8);
    }
}

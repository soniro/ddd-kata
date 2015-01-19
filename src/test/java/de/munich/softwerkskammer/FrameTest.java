package de.munich.softwerkskammer;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class FrameTest {

    @Test
    public void nextToLastFrameReturnsCorrectStrikeScore() {
        Frame frame = createNextToLastFrameWithRolls(10, 10, 10, 10);
        assertEquals(30, frame.score());
    }

    @Test(expected = RuntimeException.class)
    public void firstTwoRollsCombinedMayNotHaveMoreThanTenPins() {
        createNextToLastFrameWithRolls(7, 8);
    }

    private Frame createNextToLastFrameWithRolls(int... rolls) {
        Frame frame = new Frame(9);
        IntStream.of(rolls).forEach(roll -> frame.roll(roll));
        return frame;
    }
}

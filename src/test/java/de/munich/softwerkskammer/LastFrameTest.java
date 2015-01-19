package de.munich.softwerkskammer;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class LastFrameTest {

    Frame lastFrame = new LastFrame();

    @Test
    public void lastFrameAcceptsTwoExtraRollIfStrike() {
        roll(10, 10, 10);
        assertEquals(30, lastFrame.score());
    }

    @Test
    public void lastFrameAcceptsOneExtraRollIfSpare() {
        roll(4, 6, 2);
        assertEquals(12, lastFrame.score());
    }

    @Test(expected = RuntimeException.class)
    public void lastFrameAcceptsNoExtraRollIfNoStrikeOrSpare() {
        roll(3, 5, 2);
    }

    @Test(expected = RuntimeException.class)
    public void firstTwoRollsCombinedMayNotHaveMoreThanTenPins() {
        roll(7, 8);
    }

    @Test
    public void rollSmallerEqualsTenIsValid() {
        roll(10);
    }

    @Test(expected = RuntimeException.class)
    public void rollGreaterTenIsInvalid() {
        roll(11);
    }

    private void roll(int... rolls) {
        IntStream.of(rolls).forEach(roll -> lastFrame.roll(roll));
    }
}

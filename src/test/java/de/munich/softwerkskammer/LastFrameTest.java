package de.munich.softwerkskammer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LastFrameTest {

    Frame lastFrame = new LastFrame();

    @Test
    public void lastFrameAcceptsTwoExtraRollIfStrike() {
        lastFrame.roll(10);
        lastFrame.roll(10);
        lastFrame.roll(10);
        assertEquals(30, lastFrame.score());
    }

    @Test
    public void lastFrameAcceptsOneExtraRollIfSpare() {
        lastFrame.roll(4);
        lastFrame.roll(6);
        lastFrame.roll(2);
        assertEquals(12, lastFrame.score());
    }

    @Test(expected = RuntimeException.class)
    public void lastFrameAcceptsNoExtraRollIfNoStrikeOrSpare() {
        lastFrame.roll(3);
        lastFrame.roll(5);
        lastFrame.roll(2);
    }

    @Test(expected = RuntimeException.class)
    public void firstTwoRollsCombinedMayNotHaveMoreThanTenPins() {
        lastFrame.roll(7);
        lastFrame.roll(8);
    }

    @Test
    public void rollSmallerEqualsTenIsValid() {
        lastFrame.roll(10);
    }

    @Test(expected = RuntimeException.class)
    public void rollGreaterTenIsInvalid() {
        lastFrame.roll(11);
    }
}

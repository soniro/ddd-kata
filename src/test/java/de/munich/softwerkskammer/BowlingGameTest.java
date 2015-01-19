package de.munich.softwerkskammer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void beforeTest() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void initialScoreShouldBeZero() {
        assertEquals(0, bowlingGame.score());
    }

    @Test
    public void strikesOnlyShouldReturn300() {
        rollPinsSeveralTimes(10, 12);
        assertEquals(300, bowlingGame.score());
    }

    @Test
    public void incompleteGameShouldReturnIntermediateScoreStrike() {
        bowlingGame.roll(10);
        assertEquals(10, bowlingGame.score());
    }

    @Test
    public void incompleteGameShouldReturnIntermediateScore() {
        rollPinsSeveralTimes(10, 5);
        assertEquals(120, bowlingGame.score());
    }

    @Test
    public void pairsOfNineAndMissShouldReturn90() {
        rollAlternatingSeveralTimes(10, 9, 0);
        assertEquals(90, bowlingGame.score());
    }

    @Test
    public void fivesOnlyShouldReturn150() {
        rollPinsSeveralTimes(5, 21);
        assertEquals(150, bowlingGame.score());
    }

    @Test(expected = RuntimeException.class)
    public void rollingMoreThen21TimesShouldThrowException() {
        rollPinsSeveralTimes(5, 22);
    }

    private void rollPinsSeveralTimes(int pins, int times) {
        IntStream.range(0, times).forEach(Void -> bowlingGame.roll(pins));
    }

    private void rollAlternatingSeveralTimes(int times, int... pins) {
        IntStream.range(0, times).forEach(Void -> IntStream.of(pins).forEach(pin -> bowlingGame.roll(pin)));
    }

}

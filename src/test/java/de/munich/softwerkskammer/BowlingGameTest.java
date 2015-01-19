package de.munich.softwerkskammer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        bowlingGame.roll(10);
        assertEquals(300, bowlingGame.score());
    }

    @Test
    public void pairsOfNineAndMissShouldReturn90() {
        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);

        bowlingGame.roll(9);
        bowlingGame.roll(0);
        assertEquals(90, bowlingGame.score());
    }

    @Test
    public void fivesOnlyShouldReturn150() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        assertEquals(150, bowlingGame.score());
    }

    @Test(expected = RuntimeException.class)
    public void rollingMoreThen21TimesShouldThrowException() {
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
    }

}

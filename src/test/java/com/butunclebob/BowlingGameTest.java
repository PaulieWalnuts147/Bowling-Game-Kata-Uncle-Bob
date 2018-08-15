package com.butunclebob;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    public void rollMany(int noOfRolls, int pinsKnocked){
        for (int i = 0; i < noOfRolls; i++) {
            bowlingGame.roll(pinsKnocked);
        }
    }

    @Test
    public void shouldScoreGutterGame() {
        rollMany(20, 0);
        assertEquals(0, bowlingGame.getScore());
    }

    @Test
    public void shouldScoreGameOfAllOnes() {
        rollMany(20, 1);
        assertEquals(20, bowlingGame.getScore());
    }

    @Test
    public void scoreAssortedScoreWithNoBonuses() {
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        bowlingGame.roll(2);
        bowlingGame.roll(1);
        bowlingGame.roll(0);
        bowlingGame.roll(8);
        rollMany(14, 0);
        assertEquals(19, bowlingGame.getScore());
    }

    @Test
    public void rollOneSpare() {
        bowlingGame.roll(5);
        bowlingGame.roll(5); //spare
        bowlingGame.roll(3);
        rollMany(17, 0);
        assertEquals(16, bowlingGame.getScore());
    }

    @Test
    public void rollOneSpareWithNoBonus() {
        bowlingGame.roll(5);
        bowlingGame.roll(5); //spare
        rollMany(18, 0);
        assertEquals(10, bowlingGame.getScore());
    }

    @Test
    public void rollTwoSpares() {
        bowlingGame.roll(5);
        bowlingGame.roll(5); //spare
        bowlingGame.roll(3);
        bowlingGame.roll(3);
        bowlingGame.roll(6);
        bowlingGame.roll(4); //spare
        bowlingGame.roll(4);
        rollMany(13, 0);
        assertEquals(37, bowlingGame.getScore());
    }

    @Test
    public void rollTwoSparesInARow() {
        bowlingGame.roll(5);
        bowlingGame.roll(5); //spare
        bowlingGame.roll(5);
        bowlingGame.roll(5); //spare
        bowlingGame.roll(3);
        bowlingGame.roll(3);
        rollMany(14, 0);
        assertEquals(34, bowlingGame.getScore());
    }


    @Test
    public void testOneStrike() {
        bowlingGame.roll(10); //strike
        bowlingGame.roll(3);
        bowlingGame.roll(4);
        rollMany(16, 0);
        assertEquals(24, bowlingGame.getScore());
    }


    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, bowlingGame.getScore());
    }
}

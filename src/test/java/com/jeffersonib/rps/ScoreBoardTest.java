package com.jeffersonib.rps;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @Before
    public void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    public void newScoreBoardStartsAtZero() {
        assertEquals(0, scoreBoard.getWins());
        assertEquals(0, scoreBoard.getLosses());
        assertEquals(0, scoreBoard.getTies());
    }

    @Test
    public void incrementWinsOnlyChangesWins() {
        scoreBoard.incrementWins();
        scoreBoard.incrementWins();

        assertEquals(2, scoreBoard.getWins());
        assertEquals(0, scoreBoard.getLosses());
        assertEquals(0, scoreBoard.getTies());
    }

    @Test
    public void incrementLossesOnlyChangesLosses() {
        scoreBoard.incrementLosses();

        assertEquals(0, scoreBoard.getWins());
        assertEquals(1, scoreBoard.getLosses());
        assertEquals(0, scoreBoard.getTies());
    }

    @Test
    public void incrementTiesOnlyChangesTies() {
        scoreBoard.incrementTies();

        assertEquals(0, scoreBoard.getWins());
        assertEquals(0, scoreBoard.getLosses());
        assertEquals(1, scoreBoard.getTies());
    }
}

package com.jeffersonib.rps;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameOptionTest {

    @Test
    public void rockBeatsScissors() {
        assertTrue(GameOption.ROCK.beats(GameOption.SCISSORS));
    }

    @Test
    public void paperBeatsRock() {
        assertTrue(GameOption.PAPER.beats(GameOption.ROCK));
    }

    @Test
    public void scissorsBeatsPaper() {
        assertTrue(GameOption.SCISSORS.beats(GameOption.PAPER));
    }

    @Test
    public void rockDoesNotBeatPaper() {
        assertFalse(GameOption.ROCK.beats(GameOption.PAPER));
    }

    @Test
    public void noOptionBeatsItself() {
        for (GameOption option : GameOption.values()) {
            assertFalse(option.beats(option));
        }
    }
}

package com.jeffersonib.rps;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

    private static final int OPTION_ROCK = 0;
    private static final int OPTION_PAPER = 1;
    private static final int OPTION_SCISSORS = 2;

    @Mock
    private Scanner scanner;

    @Mock
    private Random random;

    @InjectMocks
    private Game game;

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream out;

    @Before
    public void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void when_writeQuit_then_exitGame() {
        when(scanner.nextLine()).thenReturn("Quit");

        game.play();

        assertTrue(out.toString().contains("Let's play Rock"));
    }

    @Test
    public void when_chooseRock_then_beatsScissors() {
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_SCISSORS);

        game.play();

        assertTrue(out.toString().contains("Computer chose scissors"));
        assertTrue(out.toString().contains("wins:1"));
        assertTrue(out.toString().contains("loses:0"));
    }

    @Test
    public void when_chooseScissors_then_beatsPaper() {
        when(scanner.nextLine()).thenReturn("Scissors").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();

        assertTrue(out.toString().contains("Computer chose paper"));
        assertTrue(out.toString().contains("wins:1"));
        assertTrue(out.toString().contains("loses:0"));
    }

    @Test
    public void when_choosePaper_then_beatsRock() {
        when(scanner.nextLine()).thenReturn("Paper").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();

        assertTrue(out.toString().contains("Computer chose rock"));
        assertTrue(out.toString().contains("wins:1"));
        assertTrue(out.toString().contains("loses:0"));
    }

    @Test
    public void when_bothChooseRock_then_tie() {
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_ROCK);

        game.play();

        assertTrue(out.toString().contains("Computer chose rock"));
        assertTrue(out.toString().contains("ties:1"));
        assertTrue(out.toString().contains("loses:0"));
    }

    @Test
    public void when_chooseRockAndComputerChoosePaper_then_lose() {
        when(scanner.nextLine()).thenReturn("Rock").thenReturn("Quit");
        when(random.nextInt(3)).thenReturn(OPTION_PAPER);

        game.play();

        assertTrue(out.toString().contains("Computer chose paper"));
        assertTrue(out.toString().contains("loses:1"));
    }
}

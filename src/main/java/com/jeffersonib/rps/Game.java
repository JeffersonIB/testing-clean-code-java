package com.jeffersonib.rps;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final String QUIT = "QUIT";
    private static final String INSTRUCTIONS =
            "Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.";

    private final Scanner input;
    private final Random random;

    public Game() {
        this(new Scanner(System.in), new Random());
    }

    public Game(Scanner input, Random random) {
        this.input = input;
        this.random = random;
    }

    public void play() {
        printGameRules();
        ScoreBoard scoreBoard = new ScoreBoard();

        String choice = readChoice();
        while (!isQuit(choice)) {
            GameOption playerOption = toGameOption(choice);
            if (playerOption == null) {
                System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
            } else {
                GameOption computerOption = getComputerChoice();
                playRound(scoreBoard, playerOption, computerOption);
                printResults(scoreBoard);
            }
            choice = readChoice();
        }
    }

    private String readChoice() {
        return input.nextLine().trim().toUpperCase();
    }

    private boolean isQuit(String choice) {
        return QUIT.equals(choice);
    }

    private GameOption toGameOption(String choice) {
        try {
            return GameOption.valueOf(choice);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private GameOption getComputerChoice() {
        GameOption[] options = GameOption.values();
        GameOption option = options[random.nextInt(options.length)];
        System.out.println("Computer chose " + option.name().toLowerCase());
        return option;
    }

    private void playRound(ScoreBoard scoreBoard, GameOption playerOption, GameOption computerOption) {
        if (playerOption == computerOption) {
            System.out.println("It's a tie");
            scoreBoard.incrementTies();
        } else if (playerOption.beats(computerOption)) {
            System.out.println("you win!");
            scoreBoard.incrementWins();
        } else {
            System.out.println("you lose.");
            scoreBoard.incrementLosses();
        }
    }

    private void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println(INSTRUCTIONS);
    }

    private void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins()
                + "\nloses:" + scoreBoard.getLosses()
                + "\nties:" + scoreBoard.getTies());
        System.out.println("Let's play again! \n \n");
        System.out.println(INSTRUCTIONS);
    }
}

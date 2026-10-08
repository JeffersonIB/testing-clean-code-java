package com.jeffersonib.rps;

public enum GameOption {
    ROCK, PAPER, SCISSORS;

    public boolean beats(GameOption other) {
        return switch (this) {
            case ROCK -> other == SCISSORS;
            case PAPER -> other == ROCK;
            case SCISSORS -> other == PAPER;
        };
    }
}

package fr.lernejo.guessgame;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger;

    public HumanPlayer(Logger logger) {
        this.logger = logger;
    }

    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        logger.log("Enter your guess:");
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log(lowerOrGreater ? "Your guess is too low." : "Your guess is too high.");
    }
}


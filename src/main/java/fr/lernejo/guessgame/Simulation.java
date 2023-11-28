package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("Correct! You've guessed the number!");
            return true;
        } else {
            player.respond(guess < numberToGuess);
            logger.log("Incorrect guess. Try again.");
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        while (!nextRound()) {
            // Loop until the player guesses the number
        }
        logger.log("You won! The game is over.");
    }
}

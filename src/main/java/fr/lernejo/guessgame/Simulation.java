package fr.lernejo.guessgame;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private final long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
        this.numberToGuess = 0; // Initialiser avec une valeur par défaut, sera mise à jour dans initialize()
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
        logger.log("New game started. Try to guess the number!");
    }

    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            logger.log("Congratulations! You guessed the right number.");
            return true;
        } else {
            player.respond(guess < numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(int maxIterations) {
        long startTime = System.currentTimeMillis();
        int iteration = 0;
        while (!nextRound() && iteration < maxIterations) {
            iteration++;
        }
        long endTime = System.currentTimeMillis();

        logger.log("Game over!");
        logger.log("Time taken: " + formatTime(endTime - startTime));
        logger.log("Player " + (iteration < maxIterations ? "succeeded" : "did not succeed") + " within the iteration limit.");
    }

    private String formatTime(long milliseconds) {
        long seconds = milliseconds / 1000;
        long minutes = seconds / 60;
        return String.format("%02d:%02d.%03d", minutes, seconds % 60, milliseconds % 1000);
    }
}


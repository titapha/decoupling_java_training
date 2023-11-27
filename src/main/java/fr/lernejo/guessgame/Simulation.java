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

    public void loopUntilPlayerSucceed() {
        while (!nextRound()) {
            // Continue the game
        }
        logger.log("Game over!");
    }
}


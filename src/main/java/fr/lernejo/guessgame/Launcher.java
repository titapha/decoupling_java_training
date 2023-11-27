package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        Logger playerLogger = LoggerFactory.getLogger("player");
        Player humanPlayer = new HumanPlayer(playerLogger);

        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);

        Simulation game = new Simulation(humanPlayer);
        game.initialize(randomNumber);
        game.loopUntilPlayerSucceed();
    }
}


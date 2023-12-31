package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100); // Génère un nombre entre 0 et 99

        Simulation game = new Simulation(new HumanPlayer());
        game.initialize(randomNumber);
        game.loopUntilPlayerSucceed();
    }
}

package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        // Pour l'instant, nous ignorons le paramètre 'name'
        return new ConsoleLogger();
    }
}


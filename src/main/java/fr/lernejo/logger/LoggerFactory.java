package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name, String filePath) {
        Logger fileLogger = new FileLogger(filePath);
        return new ContextualLogger(name, fileLogger);
    }
}

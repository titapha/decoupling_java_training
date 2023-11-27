package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name, String filePath) {
        Logger consoleLogger = new ContextualLogger(name, new ConsoleLogger());
        Logger fileLogger = new ContextualLogger(name, new FileLogger(filePath));
        return new CompositeLogger(consoleLogger, fileLogger);
    }
}


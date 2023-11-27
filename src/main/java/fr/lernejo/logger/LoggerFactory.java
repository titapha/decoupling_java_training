package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name, String filePath) {
        Logger consoleLogger = new ContextualLogger(name, new ConsoleLogger());
        
        Predicate<String> simulationFilter = message -> message.contains("Simulation");
        Logger filteredFileLogger = new FilteredLogger(new ContextualLogger(name, new FileLogger(filePath)), simulationFilter);

        return new CompositeLogger(consoleLogger, filteredFileLogger);
    }
}


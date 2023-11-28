package fr.lernejo.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger fileLogger = new FileLogger(name);
        Logger consoleLogger = new ConsoleLogger();
        return new CompositeLogger(consoleLogger, fileLogger);
    }

    private static class FileLogger implements Logger {
        private final PrintWriter writer;

        public FileLogger(String fileName) {
            try {
                this.writer = new PrintWriter(new FileWriter(fileName, true), true);
            } catch (IOException e) {
                throw new RuntimeException("Failed to initialize FileLogger", e);
            }
        }

        @Override
        public void log(String message) {
            writer.println(message);
        }
    }
}

import logger.ILogger;
import logger.LogLevel;
import logger.LoggerFactory;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        ILogger debugLogger = LoggerFactory.createLogger(LogLevel.DEBUG);
        ILogger infoLogger = LoggerFactory.createLogger(LogLevel.INFO);
        ILogger errorLogger = LoggerFactory.createLogger(LogLevel.ERROR);

        debugLogger.log("Debug log message");
        infoLogger.log("Info log Message");
        errorLogger.log("Error log Message");
    }
}

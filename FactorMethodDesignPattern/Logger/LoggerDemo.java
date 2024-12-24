package Logger;

interface ILogger{
    void log(String message);
}

class DebugLogger implements ILogger{

    @Override
    public void log(String message) {
        System.out.println("Debug: "+ message);
    }
}

class InfoLogger implements ILogger{

    @Override
    public void log(String message) {
        System.out.println("Info: "+ message);
    }
}

class ErrorLogger implements ILogger{

    @Override
    public void log(String message) {
        System.out.println("Error: "+message);
    }
}

interface LoggerFactory{
    ILogger createLogger();
}

class DebugLoggerFactory implements LoggerFactory{

    @Override
    public ILogger createLogger() {
        return new DebugLogger();
    }
}

class ErrorLoggerFactory implements LoggerFactory{

    @Override
    public ILogger createLogger() {
        return new ErrorLogger();
    }
}

class InfoLoggerFactory implements LoggerFactory{

    @Override
    public ILogger createLogger() {
        return new InfoLogger();
    }
}

public class LoggerDemo {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new InfoLoggerFactory();
        ILogger logger = loggerFactory.createLogger();

        logger.log("This is an info message");

        loggerFactory = new DebugLoggerFactory();
        logger = loggerFactory.createLogger();

        logger.log("This is a Debug Message");
    }
}

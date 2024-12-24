package logger;

public class Debuglogger implements ILogger{

    @Override
    public void log(String msg) {
        System.out.println("Debug: " +msg);
    }
}

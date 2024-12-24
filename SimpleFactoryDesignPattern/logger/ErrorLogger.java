package logger;

public class ErrorLogger implements ILogger{
    @Override
    public void log(String msg) {
        System.out.println("ERROR: "+msg);
    }
}

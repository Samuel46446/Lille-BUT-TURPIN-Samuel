package tp09;

public class WrongLoginException extends Exception
{
    private String LOGIN;

    public boolean init(String base, String log)
    {
        
        return false;
    }

    @Override
    public synchronized Throwable initCause(Throwable cause)
    {
        return super.initCause(cause);
    }
}
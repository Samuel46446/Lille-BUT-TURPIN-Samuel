package e6;
/**
 * NotFoundVoyageExeption
 * Existence d’un voyage possible
 */
public class NotFoundVoyageExeption extends Exception
{
    public NotFoundVoyageExeption(String msg)
    {
        super(msg);
    }
}
package tp10;

public interface IScheduler<IPriority>
{
    void addElement(IPriority type);
    IPriority highestPriority(); 
    boolean isEmpty();
    int size();
}

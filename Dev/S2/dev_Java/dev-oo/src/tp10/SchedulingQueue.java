package tp10;

import java.util.LinkedList;

@SuppressWarnings("hiding")
public class SchedulingQueue<IPriority> implements IScheduler<IPriority>
{
    public static int queueCounter;
    protected LinkedList<IPriority> theQueue = new LinkedList<>();

    public int getID()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        if(theQueue.isEmpty())
        {
            return "Queue"+getID()+" -> []";
        }
        else
        {
            return "Queue"+getID()+" -> "+theQueue.get(getID()).toString();
        }
    }

    @Override
    public void addElement(IPriority type)
    {
        theQueue.add(type);
    }

    @Override
    public IPriority highestPriority()
    {
        return theQueue.getFirst();
    }

    @Override
    public boolean isEmpty()
    {
        return theQueue.isEmpty();
    }

    @Override
    public int size()
    {
        return theQueue.size();
    }
}
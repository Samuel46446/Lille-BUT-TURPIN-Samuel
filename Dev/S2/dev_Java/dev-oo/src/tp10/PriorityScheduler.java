package tp10;

import java.util.LinkedList;

public class PriorityScheduler<IPriority> implements IScheduler<IPriority>
{
    protected LinkedList<Task> theQueue = new LinkedList<>();
    private int pri;

    public PriorityScheduler(int prio)
    {
        this.pri = prio;
    }

    public int size(int priority)
    {
        int nbTask = 0;
        for(Task t : theQueue)
        {
            if(t.getPriority() == priority)
            {
                nbTask=nbTask+1;
            }
        }
        return nbTask;
    }

    @Override
    public void addElement(IPriority type)
    {
        this.theQueue.add((Task) type);
    }

    @Override
    public IPriority highestPriority()
    {
        int highPrio = 0;
        for(Task ty : theQueue)
        {
            if(ty.getPriority() > highPrio)
            {
                highPrio = ty.getPriority();
            }
        }

        Task t = null;
        for(Task ty : theQueue)
        {
            if(ty.getPriority() == highPrio)
            {
                t = ty;
            }
        }
        return (IPriority) t;
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

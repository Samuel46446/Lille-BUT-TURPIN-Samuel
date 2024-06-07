package tp10;

public class PrioritySchedulingQueue<T extends IPriority> extends SchedulingQueue<T>
{
    @Override
    public T highestPriority()
    {
        int highPrio = 0;
        for(T ty : theQueue)
        {
            if(ty.getPriority() > highPrio)
            {
                highPrio = ty.getPriority();
            }
        }

        T t = null;
        for(T ty : theQueue)
        {
            if(ty.getPriority() == highPrio)
            {
                t = ty;
            }
        }
        return t;
    }
}

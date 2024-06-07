package tp10;

public class Task implements IPriority
{
    int priority;
    String label;
    
    public Task(String l, int p)
    {
        this.label = l;
        this.priority = p;
    }

    public int getPriority()
    {
        return this.priority;
    }

    public String getLabel()
    {
        return this.label;
    }

    public void setLabel(String l)
    {
        this.label = l;
    }

    @Override
    public String toString()
    {
        return "Task:"+getLabel()+"("+getPriority()+")";
    }
}
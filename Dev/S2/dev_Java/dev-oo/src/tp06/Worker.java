package tp06;

import java.time.LocalDate;

public class Worker extends Employee
{
    private static final double BY_UNIT = 5.0;
    private int units;
    private static int objective = 10000;

    public Worker(String n, LocalDate ld, int u)
    {
        super(n, ld);
        this.units=u;
    }

    @Override
    public String getTitle()
    {
        return "Worker";
    }

    public boolean objectiveFulfilled()
    {
        if(units>=objective)
        {
            return true;
        }
        return false;
    }

    @Override
    public double getWages()
    {
        return BY_UNIT*units;
    }
    
    @Override
    public String toString()
    {
        return getTitle() + " " + getName();
    }
}
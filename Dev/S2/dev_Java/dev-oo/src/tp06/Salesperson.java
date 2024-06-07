package tp06;

import java.time.LocalDate;

public abstract class Salesperson extends Employee
{
    private double turnover;
    private static double objective = 10000.0;

    public Salesperson(String n, LocalDate ld, double t)
    {
        super(n, ld);
        this.turnover=t;
    }

    public double getTurnover()
    {
        return turnover;
    }

    public boolean objectiveFulfilled()
    {
        if(turnover>=objective)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}

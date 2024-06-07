package tp06;

import java.time.LocalDate;

public abstract class Employee
{
    private String name;
    private LocalDate hiringDate;

    public Employee(String n, LocalDate ld)
    {
        this.name=n;
        this.hiringDate=ld;
    }

    public String getName()
    {
        return this.name;
    }

    public LocalDate getHiringDate()
    {
        return hiringDate;
    }

    @Override
    public String toString()
    {
        return getTitle() + " " + getName();
    }

    public abstract boolean objectiveFulfilled();

    public abstract String getTitle();

    public abstract double getWages();
}
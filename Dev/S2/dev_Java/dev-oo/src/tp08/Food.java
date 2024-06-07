package tp08;

import java.time.LocalDate;

public class Food implements IProduct, Comparable<Food>
{
    private String label = "refUnknownXXX";
    private double price;
    private LocalDate beforeRots;

    public Food(String l, double p, LocalDate rots)
    {
        this.label=l;
        this.price=p;
        this.beforeRots=rots;
    }

    public Food(String l, double p)
    {
        this(l, p, LocalDate.now().minusDays(10));
    }

    @Override
    public double getPrice()
    {
        return this.price;
    }

    @Override
    public int compareTo(Food o)
    {
        return this.beforeRots.compareTo(o.beforeRots);
    }

    public boolean isNotRotten(LocalDate aDate)
    {
        if(this.beforeRots.getDayOfYear()>=aDate.getDayOfYear() && this.beforeRots.getDayOfMonth()>=aDate.getDayOfMonth())
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean isPerishable()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "["+this.label+"="+getPrice()+" -> " + this.beforeRots+"]";
    }
}
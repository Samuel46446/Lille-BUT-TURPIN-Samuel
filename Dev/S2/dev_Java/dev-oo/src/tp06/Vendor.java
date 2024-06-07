package tp06;

import java.time.LocalDate;

public class Vendor extends Salesperson
{
    private static final double POURCENTAGE = 1.20;
    private static final int BONUS = 400;

    public Vendor(String n, LocalDate ld, double t)
    {
        super(n, ld, t);
    }

    public static double getPourcentage() {
        return POURCENTAGE;
    }

    public static int getBonus() {
        return BONUS;
    }

    @Override
    public String getTitle()
    {
        return getName();
    }

    @Override
    public double getWages()
    {
        return getWages()+400;
    }
}

package tp06;

import java.time.LocalDate;

public class TravellingSalesperson extends Salesperson
{
    private static final double POURCENTAGE = 1.20;
    private static final int BONUS = 800;

    public TravellingSalesperson(String n, LocalDate ld, double t)
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
        return "TravellingSalesperson";
    }

    @Override
    public double getWages()
    {
        return getWages()+800;
    }
}
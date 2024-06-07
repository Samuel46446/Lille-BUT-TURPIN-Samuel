package td08;

import java.time.LocalDate;

public class Person
{
    private String nom;
    private LocalDate Birth;

    public Person(String n, LocalDate d)
    {
        this.nom=n;
        this.Birth=d;
    }

    public String getNom() {
        return nom;
    }

    public long getAges()
    {
        return Birth.toEpochDay();
    }
}
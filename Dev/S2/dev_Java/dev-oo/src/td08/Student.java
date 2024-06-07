package td08;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Student
{
    private final String INE;
    private String nom;
    private LocalDate Birth;
    private Map<Mat, Double> grades;
    private Person person;
    private boolean pedago = false;

    public Student(String n, LocalDate anniv, Map<Mat, Double> g)
    {
        this.nom=n;
        this.Birth=anniv;
        this.grades=g;
        this.person=new Person(n, anniv);
        this.INE="0";
        this.pedago=true;
    }

    public Student(String n, LocalDate d)
    {
        this(n, d, new HashMap<>());
        this.pedago=false;
    }

    public long getAges()
    {
        return this.person.getAges();
    }

    public String getINE() {
        return INE;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getBirth() {
        return Birth;
    }

    public void addGrade(Mat mat, double grade)
    {
        this.grades.put(mat, grade);
    }

    public void addGrade(String mat, double grade)
    {
        this.addGrade(Mat.valueOf(mat.toUpperCase(Locale.ROOT)), grade);
    }

    public double computeOverall()
    {
        double calcul=0.0;
        if(grades.isEmpty())
        {
            return -1;
        }
        else
        {
            for(Double d : grades.values())
            {
                calcul=calcul+d;
            }
            calcul = calcul/grades.size();
            return calcul;
        }
    }

    @Override
    public String toString()
    {
        if(this.pedago)
        {
            return "true";
        }
        else
        {
            return "false";
        }
    }
}
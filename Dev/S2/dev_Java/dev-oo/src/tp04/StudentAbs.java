package tp04;

public class StudentAbs extends Student
{
    private int nbAbsence;

    public StudentAbs(Student pers, double[] grades, int abs)
    {
        super(pers, grades);
        this.nbAbsence=abs;
    }

    public int getNbAbsence() {
        return nbAbsence;
    }

    public boolean warning(int thresholdAbs, double thresholdAvg)
    {
        return getAverage() <= thresholdAvg || getNbAbsence() >= thresholdAbs;
    }

    public boolean validation(int thresholdAbs, double thresholdAvg)
    {
        return getAverage() >= thresholdAvg || getNbAbsence() <= thresholdAbs;
    }

    public boolean equals(StudentAbs abs)
    {
        return abs.getNbAbsence() == this.getNbAbsence();
    }

    @Override
    public String toString()
    {
        return getPers().getForename()+" "+getPers().getName()+", nbAbs="+getNbAbsence();
    }
}
package tp04;

public class Student extends Person
{
    private double grades[] = {};
    private static String forename;
    private static String name;
    private Person pers;

    public Student(String f, String n)
    {
        super(f, n);
    }

    public Student(Person pers, double[] grades)
    {
        super(forename, name);
        this.pers = pers;
        this.grades = grades;
        
    }
    public Student(String forename, String name, double[] grades)
    {
        super(forename, name);
        this.grades = grades;
    }

    public double[] getGrades() {
        return grades;
    }

    public void addGrade(double aGrade)
    {
        this.grades[getGrades().length-1]=aGrade;
    }

    public Person getPers() {
        return pers;
    }
    
    public boolean equals(Student stu)
    {
        return super.equals(stu) && stu.getGrades().length == this.getGrades().length;
    }

    public double getAverage()
    {
        double db = 0.0;
        if(getGrades().length == 0)
        {
            return db;
        }
        else
        {
            for(int i = 0; i < getGrades().length; i++)
            {
                db = db + getGrades()[i];
            }
            db = db / getGrades().length;
            return db;
        }
    }

    @Override
    public String toString()
    {
        return "Student["+getID()+": "+getPers().getForename()+" "+getPers().getName()+" = "+getAverage()+"]";
    }
}
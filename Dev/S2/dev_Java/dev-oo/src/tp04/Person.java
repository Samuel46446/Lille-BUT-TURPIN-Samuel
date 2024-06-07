package tp04;

public class Person
{
    private static final int ID = 0;
    private String forename;
    private String name;

    public Person(String f, String n)
    {
        this.forename=f;
        this.name=n;
    }

    public int getID()
    {
        return ID;
    }

    public String getForename()
    {
        return forename;
    }

    public String getName()
    {
        return name;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Méthode equals non necessaire equals(Obj obj) { if(obj == this) }

    @Override
    public String toString()
    {
        return getID() + ": " + getForename() + " " + getName();
    }
}
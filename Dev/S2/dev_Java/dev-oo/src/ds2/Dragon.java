package ds2;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Dragon
{
    private Capacity capacity;
    private final String NAME;
    private final LocalDate BIRTH;
    protected int power;
    private Dragon father;
    private Dragon mother;
    public static final Random rnd = new Random();
    boolean isPowerfull = father.power > mother.power;

    public Dragon(String n, Dragon fath, Dragon moth)
    {
        this.capacity = null;
        this.NAME = n;
        this.BIRTH = LocalDate.now();
        this.power = rnd.nextInt(0, isPowerfull ? father.power : mother.power);
        this.father = fath;
        this.mother = moth;
    }

    public Dragon(String n)
    {
        this(n, null, null);
        this.power = rnd.nextInt(0, 100);
    }

    public String getNAME() {
        return NAME;
    }

    public LocalDate getBIRTH() {
        return BIRTH;
    }

    public void setCapacity()
    {
        if(this.father.power == this.mother.power)
        {
            Capacity[] c = {this.father.capacity, this.mother.capacity};
            this.capacity = c[rnd.nextInt(c.length - 1)];
        }
        if(this.father.power > this.mother.power)
        {
            this.capacity = this.father.capacity;
        }
        else if(this.father.power < this.mother.power)
        {
            this.capacity = this.mother.capacity;
        }
        else //Née sous X
        {
            Capacity[] c = Capacity.values();
            this.capacity = c[rnd.nextInt(c.length - 1)];
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        Dragon dr = (Dragon) obj;
        return this.NAME.equals(dr.NAME);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash();
    }
}
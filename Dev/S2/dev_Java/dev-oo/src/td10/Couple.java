package td10;

public class Couple<T,S>
{
    private T first;
    private S second;

    public Couple(T t, S s)
    {
        this.first = t;
        this.second = s;
    }

    public T getFirst()
    {
        return this.first;
    }

    public S getSecond()
    {
        return this.second;
    }

    public boolean sameAs(Couple<T,S> other)
    {
        return this.first.equals(other.first) && this.second.equals(other.second);
    }

    public static<T,S> boolean sameCouples(Couple<T,S> c1, Couple<T,S> c2)
    {
        return c1.sameAs(c2);
    }
}
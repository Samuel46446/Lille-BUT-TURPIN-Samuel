package td10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Duo
 */
public class Duo<E>
{
    private E one;
    private E two;

    public Duo(E e1, E e2)
    {
        this.one = e1;
        this.two = e2;
    }

    public Duo(E e1)
    {
        this(e1, null);
    }

    public E getFirst()
    {
        return this.one;
    }

    public E getSecond()
    {
        return this.two;
    }

    public void swap()
    {
        E newOne = this.two;
        E newSecond = this.one;
        this.one = newOne;
        this.two = newSecond;
    }

    public boolean identicalElements()
    {
        if(this.one == null && this.two == null)
        {
            return true;
        }

        if(this.one == null)
        {
            return false;
        }
        return this.one.equals(this.two);
    }

    public boolean orderedEquals(Duo<E> otherDuo)
    {
        return this.one.equals(otherDuo.getFirst()) && this.two.equals(otherDuo.getSecond());
    }

    public boolean reverseEquals(Duo<E> otherDuo)
    {
        return this.one.equals(otherDuo.getSecond()) && this.two.equals(otherDuo.getFirst());
    }

    public boolean nonOrderedEquals(Duo<E> otherDuo)
    {
        return this.reverseEquals(otherDuo) || this.orderedEquals(otherDuo);
    }

    public static<E> void mixDuos(Duo<E> d1, Duo<E> d2)
    {
        E tmp = d1.one;
        d1.one = d2.two;
        d2.two = tmp;
    }

    public static<E> List<Duo<E>> randomDuos(List<E> elements)
    {
        Collections.shuffle(elements);
        List<Duo<E>> duos = new ArrayList<Duo<E>>();
        while (elements.size() > 1)
        {
            duos.add(new Duo<E>(elements.remove(0), elements.remove(0)));
        }

        if(elements.size() == 1)
        {
            duos.add(new Duo<E>(elements.remove(0)));
        }
        return duos;
    }

    @Override
    public String toString()
    {
        return this.one + " et " + this.two;
    }
}
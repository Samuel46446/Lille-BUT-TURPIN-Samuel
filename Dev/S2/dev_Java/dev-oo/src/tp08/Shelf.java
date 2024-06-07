package tp08;

import java.util.ArrayList;

public class Shelf
{
    private boolean refridge;
    private int capacityMax;
    private ArrayList<IProduct> shelves;

    public Shelf(boolean r, int c)
    {
        this.refridge=r;
        this.capacityMax=c;
        this.shelves = new ArrayList<>();
    }

    public ArrayList<IProduct> getShelves()
    {
        return this.shelves;
    }

    public Food getFood(int i)
    {
        return (Food) getShelves().get(i);
    }

    public boolean add(IProduct item)
    {
        if(isFull())
        {
            return false;
        }
        else
        {
            getShelves().add(item);
            return true;
        }
    }

    public boolean isFull()
    {
        if(!isEmpty() && this.capacityMax == this.shelves.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isEmpty()
    {
        if(this.shelves.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isRefrigerated()
    {
        return this.refridge;
    }

    @Override
    public String toString()
    {
        return "["+this.refridge+" : "+this.capacityMax+" -> "+this.shelves.toString()+"]";
    }
}

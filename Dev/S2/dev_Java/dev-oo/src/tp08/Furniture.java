package tp08;

public class Furniture implements IProduct, Comparable<Furniture>
{
    private String label = "refUnknownXXX";
    private double price;

    public Furniture(String l, double p)
    {
        this.label=l;
        this.price=p;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public double getPrice()
    {
        return this.price;
    }

    @Override
    public int compareTo(Furniture o)
    {
        return this.label.compareTo(o.label);
    }

    @Override
    public boolean isPerishable()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return "["+this.label+"="+getPrice()+" -> Never Perishable]";
    }
}
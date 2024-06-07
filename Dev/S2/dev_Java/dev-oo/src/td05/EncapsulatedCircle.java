package td05;

public class EncapsulatedCircle
{
    private double x, y, r;

    public EncapsulatedCircle(double x, double y, double r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void moveCenter(double dx, double dy)
    {
        this.x=dx;
        this.y=dy;
    }

    public void updateRadius(double dr)
    {
        this.r=dr;
    }

    public Point getCenter()
    {
        return new Point(this.x, this.y);
    }

    @Override
    public String toString()
    {
        return "EncapsulatedCircle[Point("+this.x+","+this.y+"),"+this.r+"]";
    }
}
package td05;

public class Point
{
    private double x, y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void move(double x, double y)
    {
        x=x+1;
        y=y+1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString()
    {
        return "Point("+this.x+","+this.y+")";
    }
}
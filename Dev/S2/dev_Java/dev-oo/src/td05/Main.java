package td05;

public class Main
{
    public static void main(String[] args)
    {
        EncapsulatedCircle e = new EncapsulatedCircle(3, 3, 5);

        System.out.println(e);
        e.moveCenter(9,5);
        e.updateRadius(10);
        System.out.println(e);
        System.out.println(e.getCenter());
    }
}
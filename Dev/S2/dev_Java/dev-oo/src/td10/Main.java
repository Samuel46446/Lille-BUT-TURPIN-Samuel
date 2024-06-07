package td10;

public class Main
{
    public static void main(String[] args)
    {
        //testDuos();
        testCouple();
    }

    private static void testCouple()
    {
        Couple<String, String> c1 = new Couple<String,String>("alice", "bruno");
        Couple<String, String> c2 = new Couple<String,String>("alice", "polo");

        System.out.println(c1.sameAs(c2));
        System.out.println(Couple.sameCouples(c1, c2));
    }

    private static void testDuos()
    {
        Duo<String> duoStr = new Duo<String>("bruno", "alice");
        System.out.println(duoStr);
        duoStr.swap();
        System.out.println(duoStr);
        Duo<Boolean> duoBool = new Duo<Boolean>(false, true);
        System.out.println(duoBool);
        duoBool.swap();
        System.out.println(duoBool);

        Duo<Integer> d1 = new Duo<Integer>(1, 2);
        Duo<Integer> d2 = new Duo<Integer>(2, 1);
        System.out.println(d1.orderedEquals(d2));
        System.out.println(d1.nonOrderedEquals(d2));
    }
}
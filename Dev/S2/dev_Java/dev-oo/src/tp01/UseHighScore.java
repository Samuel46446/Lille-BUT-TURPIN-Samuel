package tp01;

public class UseHighScore
{
    public static void main(String[] args)
    {
        HighScore hSc = new HighScore(3);
        hSc.ajout(new Score("Alice", 300, "29/01"));
        hSc.ajout(new Score("Bob", 800, "29/01"));
        hSc.ajout(new Score("Alice", 42, "30/01"));
        hSc.ajout(new Score("Alice", 650, "31/01"));
        System.out.println(hSc);
    }
} 

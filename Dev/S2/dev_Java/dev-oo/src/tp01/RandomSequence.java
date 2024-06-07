package tp01;

import java.util.Random;

public class RandomSequence
{
    private int nbGen;
    private int valMax;
    private String intOrReal = "INTEGER";

    public RandomSequence(int n, int v, String i)
    {
        this.nbGen = n;
        this.valMax = v;
        this.intOrReal = i;
    }

    public int getNbGen() {
        return nbGen;
    }

    public int getValMax() {
        return valMax;
    }

    public String getIntOrReal() {
        return intOrReal;
    }

    public static void main(String[] args)
    {
        if(Integer.parseInt(args[0]) >= 1 && Integer.parseInt(args[1]) >= 1)
        {
            Random rnd = new Random();
            if(args[2].equals("REAL"))
            {
                String rep = "";
                for(int i = 1;i<=Integer.parseInt(args[0]);i++)
                {
                    double db = rnd.nextDouble(Double.parseDouble(args[1]));
                    rep = rep + "Valeur n°"+i+" : "+db + "\n";
                }
                System.out.println(rep);
            }
            else
            {
                String rep = "";
                for(int i = 1;i<=Integer.parseInt(args[0]);i++)
                {
                    int in = rnd.nextInt(Integer.parseInt(args[1]));
                    rep = rep + "Valeur n°"+i+" : "+in + "\n";
                }
                System.out.println(rep);
            }
        }
        else
        {
            System.out.println("Correct usage : <nbElt> <maxVal> [INTEGER|REAL]"); 
        } 
    }
}
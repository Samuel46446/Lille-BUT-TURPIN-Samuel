package tp02;

import java.util.Random;

public class Dice
{
    private Random rand = new Random();
    private int numberSides;
    private int value;
    
    public Dice(int n)
    {
        if(n > 1)
        {
            this.numberSides = n;
        }
        else
        {
            this.numberSides = 1;
        }
    }
    
    public void roll()
    {
        value = rand.nextInt(numberSides)+1;
    }
    
    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "Valeur du dee = " + getValue();
    }
}
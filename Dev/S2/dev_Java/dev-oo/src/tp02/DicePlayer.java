package tp02;

public class DicePlayer
{
    private String nm;
    private int totalValue;
    private int nbDiceRolls;

    public DicePlayer(String name)
    {
        this.nm = name;
    }

    public void play(Dice dice6)
    {
        nbDiceRolls = 0;
        while (this.totalValue < 20)
        {
            nbDiceRolls=nbDiceRolls+1;
            dice6.roll();
            System.out.println(this.nm + ": "+nbDiceRolls+" lancer: "+dice6);
            this.totalValue = this.totalValue+dice6.getValue();
        }
    }

    public void setNbDiceRolls(int a)
    {
        this.nbDiceRolls=a;
    }

    public int getNbDiceRolls()
    {
        return nbDiceRolls;
    }

    public String getName()
    {
        return nm;
    }

    public boolean isWinning(DicePlayer p)
    {
        if(p.nbDiceRolls < this.nbDiceRolls)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return this.nm+": "+this.totalValue+" points en "+this.nbDiceRolls+" coups.";
    }
}
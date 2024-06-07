package tp02;

public class Competitor
{
    private int t, s;
    private String numberSign;

    public Competitor(int numberSign, int score, int min, int sec)
    {
        if(numberSign>=1 && numberSign<=100)
        {
            this.numberSign = "No"+numberSign;
        }
        if(score>=0 && score<=50)
        {
            this.s = score;
        }
        if(sec>=0 && sec<=60 && min>=0 && min<=60)
        {
            this.t = (60*min) + sec;
        }
    }

    String display()
    {
        if(numberSign == null)
        {
            return "[<invalide>,"+s+" points,"+t+" s]";
        }
        return "["+numberSign+","+s+" points,"+t+" s]";
    }

    public boolean equals(Competitor c)
    {
        if(this == c) { return true; }
        if(c == null) { return false; }
        if(c.numberSign.equals(this.numberSign) && c.s == this.s)
        { return true; }
        return false;
    }
    
    boolean isFaster(Competitor other)
    {
        if(this == other)
        {return false;}
        if(other == null)
        {return false;}
        if(other.t < this.t)
        {
            return true;
        }
        return false;
    }
}
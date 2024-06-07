package tp01;

public class Score
{
    private String n = "Empty";
    private int sc = 0;
    private String tS = "00/00";
    
    public Score(String name, int score, String timestamp)
    {
        this.n = name;
        this.sc = score;
        this.tS = timestamp;
    }

    public int getSc() {
        return sc;
    }

    @Override
    public String toString()
    {
        return tS + " " + n + " = " + sc + ".";
    }
}
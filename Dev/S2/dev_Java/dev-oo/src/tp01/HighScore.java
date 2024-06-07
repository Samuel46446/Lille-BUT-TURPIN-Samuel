package tp01;

public class HighScore
{   
    private Score[] top;

    public HighScore(int numberPod)
    {
        this.top = new Score[numberPod];
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < top.length; i++) {
            sb.append((i + 1) + ". " + (top[i] != null ? top[i].toString() : "N/A") + "\n");
        }
        return sb.toString();
    }

    public boolean ajout(Score newScore)
    {
        for (int i = 0; i < top.length; i++)
        {
            if (top[i] == null || newScore.getSc() > top[i].getSc())
            {
                // Décale les éléments vers la droite pour faire de la place
                for (int j = top.length - 1; j > i; j--) {
                    top[j] = top[j - 1];
                }
                top[i] = newScore;
                return true;
            }
        }
        return false;
    }
}
package tp02;

public class TwoDicePlayerGame
{
    DicePlayer p1, p2;

    public TwoDicePlayerGame(DicePlayer p1, DicePlayer p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public DicePlayer winner()
    {
        if(p1.isWinning(p2))
        {
            return p2;
        }
        return p1;
    }
    public static void main(String[] args)
    {
        Dice dee = new Dice(6);
        DicePlayer player1 = new DicePlayer("Alice");
        DicePlayer player2 = new DicePlayer("Gordon");
        TwoDicePlayerGame jeux = new TwoDicePlayerGame(player1, player2);
        player1.play(dee);
        player2.play(dee);
        System.out.println("Vainqueur: " + jeux.winner());
    }
}
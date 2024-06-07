package tp02;

public class NDicePlayerGame
{
    private int acreate;
    private DicePlayer[] players;

    public NDicePlayerGame(int creerJoueur)
    {
        this.acreate = creerJoueur;
        players = new DicePlayer[creerJoueur];
    }

    public int getJoueurCreer()
    {
        return acreate;
    }

    public DicePlayer[] creer(int a, DicePlayer p)
    {
        players[a] = p;
        return players;
    }

    public DicePlayer[] winner()
    {
        DicePlayer n = new DicePlayer("Pro");
        n.setNbDiceRolls(99);
        DicePlayer[] vainqueur = {};
        int min = 99;
        for (int i = 0; i < players.length-1; i++)
        {
            if(players[i].getNbDiceRolls() < min)
            {
                min = players[i].getNbDiceRolls();
            }
        }
        for (int i = 0; i < min-1; i++)
        {
            for (int k = 0; k < players.length-1; k++)
            {
                if(players[k].getNbDiceRolls() == min)
                {
                    vainqueur[i] = players[k];
                }
            }
        }
        return vainqueur;
    }

    public static void main(String[] args)
    {
        Dice dee = new Dice(6);
        DicePlayer player1 = new DicePlayer("Alice");
        DicePlayer player2 = new DicePlayer("Gordon");
        DicePlayer player3 = new DicePlayer("Nils");
        DicePlayer player4 = new DicePlayer("Samuel");

        NDicePlayerGame jeux = new NDicePlayerGame(4);
        jeux.creer(0, player1);
        jeux.creer(1, player2);
        jeux.creer(2, player3);
        jeux.creer(3, player4);
        player1.play(dee);
        player2.play(dee);
        player3.play(dee);
        player4.play(dee);
        DicePlayer[] tb = jeux.winner();
        for (int index = 0; index < jeux.winner().length; index++)
        {    
            System.out.println("Vainqueur "+index+": " + tb[index]);
        }
    }
}
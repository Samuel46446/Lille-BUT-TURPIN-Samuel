package tp02;

public class OneDicePlayerGame
{
    public static void main(String[] args)
    {
        Dice dee = new Dice(6);
        DicePlayer player = new DicePlayer("Alice");
        player.play(dee);
        System.out.println(player);
    }
}
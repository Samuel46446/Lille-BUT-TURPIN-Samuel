package ds2;

public enum Capacity
{
    CLIMBER, VENOM, WHIPTAIL;

    @Override
    public String toString()
    {
        String rep = "";
        switch (this)
        {
            case CLIMBER:
            rep = "I can attack from trees. . .";
                break;
            case VENOM:
                rep = "I can poison preys. . .";
                break;
            case WHIPTAIL:
            rep = "I can attack from trees. . .";
                break;
            default:
            rep = "NULL CAPACITY";
                break;
        }
        return rep;
    }
}
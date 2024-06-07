package tp03;

/**
* Cette classe créer une carte en spécifiant sa couleur et sont rang
*
* @author Samuel Turpin
*/
public class Card
{
    /* Déclaration privée de la couleur et le rang de la carte */
    private Color c;
    private Rank r;

    /* 
    *
    * Constructeur principal
    *
    */
    public Card(Color color, Rank rank)
    {
        this.c = color;
        this.r = rank;
    }

    /* Autre constructeur (NON FINI) */
    public Card(String color, String rank)
    {
        System.out.println("Constructeur en chantier" + color + rank);
    }

    /* Accesseur pour la variable color */
    public Color getColor()
    {
        return this.c;
    }

    /* Accesseur pour la variable rank */
    public Rank getRank()
    {
        return this.r;
    }

    /* Comparateur de Rang
     * - renvoie 0 si c'est le même objet ou qu'il à le même rang
     * - renvoie -1 si l'ordre de l'objet enum est inférieur
     * - renvoie 1 si l'ordre de l'objet enum est supérieur
     * - renvoie 2 si aucune condition n'a marché 
     */
    public int compareRank(Card c)
    {
        int retour = 2;
        if(this == c || c.r==this.r) { 
            retour = 0;
        }
        if(this.r.ordinal() < c.r.ordinal()) { 
            retour = -1; 
        }
        if(this.r.ordinal() > c.r.ordinal()) { 
            retour = 1; 
        }
        return retour;
    }

    /* Comparateur de Couleur
     * - renvoie 0 si c'est le même objet ou qu'il à le même couleur
     * - renvoie -1 si l'ordre de l'objet enum est inférieur
     * - renvoie 1 si l'ordre de l'objet enum est supérieur
     * - renvoie 2 si aucune condition n'a marché 
     */
    public int compareColor(Card c)
    {
        int retour = 2;
        if(this.equals(c)) { 
            retour = 0; 
        }
        if(this.c.ordinal() < c.c.ordinal()) { 
            retour = -1; 
        }
        if(this.c.ordinal() > c.c.ordinal()) { 
            retour = 1; 
        }
        return retour;
    }

    /* Méthode retournant true tout le temps (probablement non fini) */
    public boolean isBefore(Card c)
    {
        return true;
    }

    /* Méthode boolean d'égalité entre deux cartes */
    public boolean equals(Card c)
    {
        if(this == c) {
            return true;
        }
        if(this.c==c.c && this.r == c.r) { 
            return true; 
        }
        return false;
    }

    /* Méthode toString() sans intérer */
    @Override
    public String toString() {
        return "mc";
    }
}
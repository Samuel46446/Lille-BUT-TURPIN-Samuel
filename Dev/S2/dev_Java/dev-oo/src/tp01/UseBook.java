package tp01;

public class UseBook
{
    public static void main(String[] args)
    {
        Book[] biblio = new Book[3];
        biblio[0] = new Book("Edwin A. Abbott", "Flatland", 1884);
        biblio[1] = new Book("Picasso", "L'art de la peinture", 1886);
        biblio[2] = new Book("Samuel Monet", "Les attrocités de la guerre", 1985);
        for(int i = 0;i<3; i++)
        {
            System.out.println(biblio[i]);
        }
    }
}
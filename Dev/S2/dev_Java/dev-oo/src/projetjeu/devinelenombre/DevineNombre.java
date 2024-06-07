package projetjeu.devinelenombre;

import java.util.Random;
import java.util.Scanner;

public class DevineNombre
{
    private static void m(String m)
    {
        System.out.println(m);
    }

    public static void main(String[] args)
    {
        m("Jouons à un jeu...");
        m("Je vais penser à un nombre entre 1 et 100...");
        m("Et toi tu devras le retrouver...");
        m("Tu dispose de 5 tentatives...");
        Random rnd = new Random();
        try (Scanner sc = new Scanner(System.in)) {
            int nb = rnd.nextInt(1,100);
            int lives = 5;
            int reponse = 0;
            while(lives != 0)
            {
                m("Nombre de Vies : " + lives);
                reponse = sc.nextInt();
                if(reponse == nb)
                {
                    m("Bravo tu as réussis le nombre était " + nb);
                    lives=0;
                }
                else if (reponse < nb)
                {
                    m("C'est plus !");
                }
                else if (reponse > nb)
                {
                    m("C'est moins !");
                }
                lives=lives-1;
            }
            if(reponse != nb)
            {
                m("Perdu, le nombre était " + nb);
            }
        }
    }
}
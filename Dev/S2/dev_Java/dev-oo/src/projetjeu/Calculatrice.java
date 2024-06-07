package projetjeu;

import java.util.Scanner;

public class Calculatrice
{
    private static void m(String m)
    {
        System.out.println(m);
    }

    private static boolean func_1(char c)
    {
        switch (c) {
            case '+':
            return false;
             case '-':
                return false;
            case '*':
                return false;
            case '/':
                return false;
        }
        return true;
    }
    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        m("Bienvenue dans la calculatrice !");
        char c = 'd';
        double db1 = 0.0;
        double db2 = 0.0;
        double calcul = 0.0;
        m("Ecrivez le premier nombre");
        do {
            db1 = sc.nextDouble();
        } while(!(db1 <= Double.MIN_VALUE) && !(db1 <= Double.MAX_VALUE));
        m("Ecrivez un signe pour une adition(+) soustraction(-) multiplication(*) et une division(/)");
        do {
            c = sc.next().charAt(0);
        }
        while(func_1(c));
        m("Ecrivez le deuxième nombre");
        do {
            db2 = sc.nextDouble();
        } while(!(db2 <= Double.MIN_VALUE) && !(db2 <= Double.MAX_VALUE));

        switch (c) {
            case '+':
             calcul = db1 + db2;
                break;
            case '-':
                calcul = db1 - db2;
                   break;
            case '*':
             calcul = db1 * db2;
                break;
            case '/':
             calcul = db1 / db2;
                break;
        }
        System.out.println("Le résultat pour le calcul : " + db1 + c + db2 + " = " + calcul);
    }
}

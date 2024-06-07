package tp09;

import java.util.Scanner;

public class LogInManagement
{
    public static final String LOGIN = "samuel.turpin.etu";
    public static final String PWD = "poneymagique";

    public boolean getUserPwd()
    {
        return true;
    }

    public static void main(String[] args)
    {
        boolean connected = false;
        Scanner scan = new Scanner(System.in);
        while(!connected)
        {
            String log = scan.next();
            String pass = scan.next();

            try
            {
                if(log.equals(LOGIN) && pass.equals(PWD))
                {
                    System.out.println("Mot de passe correct !");
                }
            } catch (Exception e) {
                System.out.println("Erreur du Mot de passe !");
                System.out.println("Veuillez réésayer...");
            }
        }
    }
}
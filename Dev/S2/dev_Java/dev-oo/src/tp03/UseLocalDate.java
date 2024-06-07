package tp03;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import util.Keyboard;

public class UseLocalDate
{
    public static String dateOfTheDay()
    {
        String str = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()).toString();
        return "Today’s date is " + str;
    }

    private static boolean nombreValide(int nombre, int nbMin, int nbMax)
    {
        if (nombre >= nbMin && nombre <= nbMax)
        {
            return true;
        }
        return false;
    }

    private static boolean bissextile(int year)
    {
        if(year % 4 == 0 && year >= 1582)
        {
            return true;
        }
        return false;
    }

    public static LocalDate inputDate()
    {
        int year = 2004, month = 11, day = 3;
        do
        {
            System.out.println("Entrez une année supérieur ou égal à 1970 :");
            year = Keyboard.readInt();
        }while(!(nombreValide(year, 1970, Integer.MAX_VALUE)));

        do
        {
            System.out.println("Entrez un mois entre 1 et 12 :");
            month = Keyboard.readInt();
        }while(!(nombreValide(month, 1, 12)));

        do
        {
            System.out.println("Entrez un jour entre 1 et 31 (doit être correct en fonction du mois ou de l'an bissextile) :");
            day = Keyboard.readInt();
        }while(!(nombreValide(day, 1, 31)));

        if(day == 29 && month == 2 && !bissextile(year))
        {
            System.out.println("Le 29 février " + year + " ! N'existe pas, veuillez entrer une année bissextile :");
            do{
                year = Keyboard.readInt();
            }while(!bissextile(year) && !(nombreValide(year, 1970, Integer.MAX_VALUE)));
        }
        LocalDate data = LocalDate.of(year, month, day);
        final Month[] mois = Month.values();
        if(data.getMonth().maxLength() == mois[month].maxLength())
        {
            return data;
        }
        System.out.println("Erreur la date entrée n'est pas correcte veuillez vérifier le nombre de jours présent dans ce mois");
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(dateOfTheDay());
        LocalDate date = inputDate();
        System.out.println(date.getMonth());
        System.out.println(date.getMonth().maxLength());
        System.out.println(date.toString());
    }
}

package td09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestingFileReader
{
    public static void main(String[] args) throws IOException
    {
        FileReader fileR = new FileReader("C://Users/samue/OneDrive/Bureau/Dev/S2/dev_Java/dev-oo/src/td09/truc.txt");
        BufferedReader buff = new BufferedReader(fileR);

        try
        {
            String str = buff.readLine();
            while(str != null)
            {
                System.out.println(str);
                str = buff.readLine();
            }

            System.out.println();

            /*if(fileR.ready())
            {
                String n = buff.readLine();
                System.out.println(n);
            }*/
            buff.close();
            fileR.close();
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Fichier non trouvé !!!");
            e.printStackTrace();
        }
        finally
        {
            buff.close();
            fileR.close();
        }
    }
}
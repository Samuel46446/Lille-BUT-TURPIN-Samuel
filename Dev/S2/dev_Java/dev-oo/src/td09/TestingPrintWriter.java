package td09;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestingPrintWriter
{
    public static void main(String[] args)
    {
        double[] data = new double[] {15.9,21.2,18.4,25.4,31.1};

        File fileIn = new File("C://Users/samue/OneDrive/Bureau/Dev/S2/dev_Java/dev-oo/src/td09/chose.txt");
        if(!fileIn.exists())
		{
			try
			{
				FileWriter writer = new FileWriter(fileIn);
				BufferedWriter buffer = new BufferedWriter(writer);
                PrintWriter pW = new PrintWriter(fileIn);

                for(double d : data)
                {
                    pW.println(d);
                    //buffer.write(String.valueOf(d));
                    //buffer.newLine();
                }
                pW.close();
                buffer.close();
                writer.close();
                fileIn.createNewFile();
            }catch(IOException e)
            {
                System.err.println("Erreur sur le fichier");
            }
        }
    }    
}
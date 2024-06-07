package e6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import fr.ulille.but.sae_s2_2024.ModaliteTransport;
import fr.ulille.but.sae_s2_2024.MultiGrapheOrienteValue;
import fr.ulille.but.sae_s2_2024.AlgorithmeKPCC;
import fr.ulille.but.sae_s2_2024.Chemin;

/**
 * Voyageur
 * Classe Principale
 */
public class Voyageur
{
    private static List<Ville> villes;
    private static List<Arrete> trancons;

    public static List<Ville> sortVille(List<String> data)
    {
        List<Ville> res = new ArrayList<Ville>();

        for (String trajet : data)
        {
            if (!res.contains(new Ville(trajet.split(";")[0]))) 
            {
                res.add(new Ville(trajet.split(";")[0]));
            }
            if (!res.contains(new Ville(trajet.split(";")[1])))
            {
                res.add(new Ville(trajet.split(";")[1]));
            }
        }
        return res;
    }

    public static List<Ville> sortVille(List<String> data, ModaliteTransport transport)
    {
        List<Ville> res = new ArrayList<Ville>();

        for (String trajet : data) {
            if (trajet.split(";")[2].toUpperCase().equals(transport.name()))
            {
                if (!res.contains(new Ville(trajet.split(";")[0])))
                {
                    res.add(new Ville(trajet.split(";")[0]));
                }
                if (!res.contains(new Ville(trajet.split(";")[1])))
                {
                    res.add(new Ville(trajet.split(";")[1]));
                }
            }
        }

        return res;
    }

    public static List<Arrete> creationArrete(List<String> data)
    {
        List<Arrete> res = new ArrayList<Arrete>();
        Arrete nTraj;

        for (String i : data)
        {
            Map<TypeCout, Double> tmp = new HashMap<TypeCout, Double>();
            
            for (int y = 0; y < TypeCout.values().length; y++)
            {
                Double tmpDouble = Double.parseDouble(i.split(";")[3 + y]);
                tmp.put(TypeCout.values()[y], tmpDouble);
            }

            nTraj = new Arrete(
                getVilleByName(i.split(";")[0]),
                getVilleByName(i.split(";")[1]),
                getModaliteTransportByName(i.split(";")[2]), tmp);
                res.add(nTraj);
        }
        return res;
    }

    public static List<Arrete> creationArrete(List<String> data, ModaliteTransport transport)
    {
        List<Arrete> res = new ArrayList<Arrete>();
        Arrete nTraj;

        for (String i : data)
        {
            String test = i.split(";")[2].toUpperCase();
            if (test.equals(transport.name()))
            {
                Map<TypeCout, Double> tmp = new HashMap<TypeCout, Double>();
                
                for (int y = 0; y < TypeCout.values().length; y++) {
                    Double tmpDouble = Double.parseDouble(i.split(";")[3 + y]);
                    
                    tmp.put(TypeCout.values()[y], tmpDouble);
                }

                nTraj = new Arrete(
                    getVilleByName(i.split(";")[0]),
                    getVilleByName(i.split(";")[1]),
                    getModaliteTransportByName(i.split(";")[2]), tmp);
                
                res.add(nTraj);
            }
        }

        return res;
    }

    public static ModaliteTransport getModaliteTransportByName(String name)
    {
        for (ModaliteTransport modalite : ModaliteTransport.values())
        {
            if (name.toUpperCase().equals(modalite.name()))
            {
                return modalite;
            }
        }
        return null;
    }

    public static Ville getVilleByName(String name) {
        for (Ville ville : villes) {
            if (name.equals(ville.toString())) 
            {
                return ville;
            }
        }
        return null;
    }

    public static Double extractValue(String line, String key) {
        line = line.substring(1, line.length() - 1);
        String[] keyValuePairs = line.split(", ");

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split("=");
            if (keyValue[0].equals(key)) {
                return Double.parseDouble(keyValue[1]);
            }
        }
        return null;
    }
 
    public static void main(String[] args) throws IOException
    {
        MultiGrapheOrienteValue graphe = new MultiGrapheOrienteValue();
        List<String> newData = new ArrayList<>();

        try(BufferedReader buff = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"poo"+File.separator+"res"+File.separator+"data.csv")))
        {
            String reading = buff.readLine();
            while(reading != null)
            {
                newData.add(reading);
                reading = buff.readLine();
            }
            buff.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        for(String d : newData)
        {
            System.out.println("Valeur de data : " + d);
        }
        System.out.println(newData.isEmpty());

        System.out.println("Voulez-vous un moyen de transport spécifique ? : ");
        System.out.println('\t' + "0) TOUS");
        for (int i = 0; i < ModaliteTransport.values().length; i++) {
            System.out.println('\t' + "" + (i + 1) + ") " + ModaliteTransport.values()[i]);
        }
        Scanner s = new Scanner(System.in);
        String res = s.nextLine();
        if ((Integer.parseInt(res) - 1) < ModaliteTransport.values().length && (Integer.parseInt(res) - 1) >= 0) {
            villes = sortVille(newData, ModaliteTransport.values()[(Integer.parseInt(res) - 1)]);
            trancons = creationArrete(newData, ModaliteTransport.values()[(Integer.parseInt(res) - 1)]);
        } else {
            villes = sortVille(newData);
            trancons = creationArrete(newData);
        }


        for (Ville ville : villes) {
            graphe.ajouterSommet(ville);
        }
        
        for (Arrete arr : trancons) {
            graphe.ajouterArete(arr, extractValue(arr.getCout().entrySet() + "", TypeCout.TEMPS.name()));
        }

        System.out.print("Combien de plus court chemin voulez-vous au maximum ? : ");
        s = new Scanner(System.in);
        res = s.nextLine();
        List<Chemin> kpcc;
        if (Integer.parseInt(res) > 0) {
            kpcc = AlgorithmeKPCC.kpcc(graphe, villes.get(0), villes.get(2), Integer.parseInt(res));
        } else {
            kpcc = AlgorithmeKPCC.kpcc(graphe, villes.get(0), villes.get(2), 1);
        }

        for (int i = 0; i < kpcc.size(); i++) {
            System.out.println(kpcc.get(i));
        }
        s.close();
    }
}
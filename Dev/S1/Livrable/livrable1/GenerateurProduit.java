class GenerateurProduit extends Program
{
    String rechercherValeur(String name, String product)
    {
        int indice = 0;
        int nbOccu = 0;
        String str = "";
        boolean b = false;
        while(!b && (indice + length(name)) <= length(product))
        {
            if(equals(substring(product, indice, indice+length(name)), name))
            {
                b = true;
                nbOccu = indice;
                while(!equals(substring(product, nbOccu, nbOccu+1), "\n") && nbOccu <= length(product))
                {
                    nbOccu = nbOccu + 1;
                }
                str = substring(product, indice+length(name)+3, nbOccu);
            }
            else
            {
                indice = indice + 1;
            }
        }
        return str;
    }

    void genererProduit(String filename)
    {
        String valeur_cle_nom = rechercherValeur("nom", filename); 
        String valeur_cle_entreprise = rechercherValeur("entreprise", filename);
        String valeur_cle_prix = rechercherValeur("prix", filename);
        String valeur_cle_date = rechercherValeur("date", filename);
        String valeur_cle_description = rechercherValeur("description", filename);

        println("<!DOCTYPE html>");
		println("<html lang=\"fr\">");
        println("  <head>");
        println("    <title>"+valeur_cle_nom+"</title>");
        println("    <meta charset=\"utf-8\">");
        println("  </head>");
        println("  <body>");
        println("    <h1>"+valeur_cle_nom+" ("+valeur_cle_entreprise+")</h1>");
        println("    <h2>"+valeur_cle_prix+" (Sortie en "+valeur_cle_date+")</h2>");
        println("    <p>");
        println(valeur_cle_description + "    </p>");
        println("  </body>");
        println("</html>");
    }

    void algorithm()
    {
        String nomFichier = argument(0);
        if(!fileExist(nomFichier))
        {
            error("fichier non trouvé !");
        }
        else{
            genererProduit(nomFichier);
        }
    }
}
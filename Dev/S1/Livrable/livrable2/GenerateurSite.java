class GenerateurSite extends Program
{
    final char NEW_LINE = '\n';

    String rechercherValeur(String chaine, String cle) {
        String valeur = "";
        int indice = 0;
        while (indice < length(chaine) && indice+length(cle) < length(chaine) && 
               !equals(cle, substring(chaine, indice, indice+length(cle)))) {
            indice = indice + 1;
        }
        if (indice < length(chaine)-length(cle)) {
            int indiceRetourLigne = indice;
            while (indiceRetourLigne < length(chaine) && charAt(chaine, indiceRetourLigne) != NEW_LINE) {
                indiceRetourLigne = indiceRetourLigne + 1;
            }
            valeur = substring(chaine, indice+length(cle), indiceRetourLigne);
        }
        return valeur;
    }

    String genererProduit(String filename)
    {
        final String CONTENU = fileAsString(filename);
        final String valeur_cle_nom = rechercherValeur(CONTENU, "nom : "); 
        final String valeur_cle_entreprise = rechercherValeur(CONTENU, "entreprise : ");
        final String valeur_cle_prix = rechercherValeur(CONTENU, "prix : ");
        final String valeur_cle_date = rechercherValeur(CONTENU, "date : ");
        final String valeur_cle_description = rechercherValeur(CONTENU, "description : ");

        String genWebProduct = "        <h2>"+valeur_cle_nom+" ("+valeur_cle_entreprise+")"+"</h2>\n        <h3>"+valeur_cle_prix+" (Sortie en "+valeur_cle_date+")"+"</h3>\n        <p>\n"+valeur_cle_description+"\n        </p>\n";
        return genWebProduct;
    }

    String WebGenbyProduct(String WebId)
    {
        String addToWeb = "";

        if(WebId == "index")
        {
            addToWeb = "        <h2>Tout ce que vous avez toujours voulu savoir sur les vieux ordis sans jamais avoir osé le demander !</h2>\n          <p>\nBienvenue dans le musée virtuel d'ordinateurs mythiques de l'histoire de l'informatique. Vous trouverez ici des éléments sur quelques machines qui ont marqué l'histoire de l'informatique que cela soit par leurs caractéristiques techniques ou l'impact commercial qu'elles ont eu et qui ont contribué au développement du secteur informatique.\n          </p>\n";
        }
        else
        {
            addToWeb = genererProduit("data/"+WebId + ".txt");
        }
        return addToWeb;
    }

    String baseWepPage(String sectId)
    {
        String webHead = "<!DOCTYPE html>\n<html lang=\"fr\">\n  <head>\n    <title>Ordinateurs mythiques</title>\n    <meta charset=\"utf-8\">\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n  </head>\n";
        String webNav = "  <body>\n    <header>\n      <h1>Ordinateurs mythiques</h1>\n    </header>\n    <nav>\n";
        String webulLi = "      <ul>\n        <li><a href=\"index.html\">Accueil</a></li>\n        <li><a href=\"produit1.html\">Produit 1</a></li>\n        <li><a href=\"produit2.html\">Produit 2</a></li>\n        <li><a href=\"produit3.html\">Produit 3</a></li>\n        <li><a href=\"produit4.html\">Produit 4</a></li>\n        <li><a href=\"produit5.html\">Produit 5</a></li>\n      </ul>\n";
        String webSect = "    </nav>\n    <main>\n      <section>\n";
        //Fonction qui change en fonction des produits
        String webProduct = WebGenbyProduct(sectId);
        String webEnd = "      </section>\n    </main>\n  </body>\n";
        String webFusion = webHead + webNav + webulLi + webSect + webProduct + webEnd + "</html>";
        return webFusion;
    }
    void algorithm()
    {
        String dir = "output/";
        String[] produit = {"index", "produit1", "produit2", "produit3", "produit4", "produit5"};
        
        stringAsFile(dir + produit[0] + ".html", baseWepPage(produit[0]) + NEW_LINE);
        stringAsFile(dir + produit[1] + ".html", baseWepPage(produit[1]));
        stringAsFile(dir + produit[2] + ".html", baseWepPage(produit[2]));
        stringAsFile(dir + produit[3] + ".html", baseWepPage(produit[3]));
        stringAsFile(dir + produit[4] + ".html", baseWepPage(produit[4]));
        stringAsFile(dir + produit[5] + ".html", baseWepPage(produit[5]));
    }
}
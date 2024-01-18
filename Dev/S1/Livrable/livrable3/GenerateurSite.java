class GenerateurSite extends Program{
    final int IDX_NOM = 0;
    final int IDX_DATE = 1;
    final int IDX_ENTREPRISE = 2;
    final int IDX_PRIX = 3;
    final int IDX_DESCRIPTION = 4; 
    final int ELEMENTNUMBER = 5; 
    final char NEW_LINE ='\n';

    void algorithm(){

        genererProduit();
    }

    void genererProduit(){
        String[][] contentOfFile = chargerProduits("data/", "produit");

        String result = getBaseStart(contentOfFile, 0);
        result = getIndexPageCore(result);
        result = result + getBaseEnd() + NEW_LINE;
        stringAsFile("output/index.html", result);

    
        for (int fileIndex = 0; fileIndex < length(contentOfFile, 2); fileIndex = fileIndex + 1) {
            String resultProuct = getBaseStart(contentOfFile, fileIndex);
            resultProuct = getPageCore(resultProuct, contentOfFile, fileIndex);
            resultProuct = resultProuct + getBaseEnd();
            int tempNb = fileIndex + 1;
            stringAsFile("output/produit"+tempNb+".html", resultProuct);
        }
    }

    String[][] chargerProduits(String repertoire, String prefixe) {
        String[] fileNameArray = getAllFilesFromDirectory(repertoire);    
        int fileToStore = length(fileNameArray);
        String[][] contentOfFile = new String[ELEMENTNUMBER][fileToStore]; 
        
        String[] keyList = new String[]{"nom : ", "date : ", "entreprise : ", "prix : ", "description : "};

        for (int produitIndex = 1; produitIndex <= fileToStore; produitIndex = produitIndex + 1) {
            if(fileExist(repertoire+prefixe+produitIndex+".txt")){
                final String TEXT = fileAsString(repertoire+prefixe+produitIndex+".txt");
                for(int keyIndex = 0; keyIndex < ELEMENTNUMBER; keyIndex++){
                    contentOfFile[keyIndex][produitIndex - 1] = rechercherValeur(TEXT, keyList[keyIndex]);
                }
            }else{
                final String MESSAGE = "generer-produit.sh génère une page HTML à partir d'un fichier texte structuré.\n" +
                            "En supposant qu'il existe un fichier produit1.txt dans le répertoire data qui respecte le format\n" +
                            "la commande suivante générera le fichier HTML correspondant dans output/produit1.html\n" +
                            "Syntaxe : ./generer-produit.sh produit1";
                error(MESSAGE);
            }
            
        }
        return contentOfFile;
    }

    String getBaseStart(String[][] contentOfFile, int fileIndex){
        int fileNameHtml = fileIndex + 1;
        String result = 
                 "<!DOCTYPE html>" + NEW_LINE +
                 "<html lang=\"fr\">" + NEW_LINE +
                 "  <head>" + NEW_LINE +
                 "    <title>Ordinateurs mythiques</title>" + NEW_LINE +
                 "    <meta charset=\"utf-8\">" + NEW_LINE +
                 "    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">" + NEW_LINE +
                 "  </head>" + NEW_LINE +
                 "  <body>" + NEW_LINE +
                 "    <header>" + NEW_LINE +
                 "      <h1>Ordinateurs mythiques</h1>" + NEW_LINE +
                 "    </header>" + NEW_LINE +
                 "    <nav>" + NEW_LINE +
                 "      <ul>" + NEW_LINE+
                 "        <li><a href=\"index.html\">Accueil</a></li>" + NEW_LINE +
                 "        <li><a href=\"produit"+fileNameHtml+".html\">"+contentOfFile[IDX_NOM][fileIndex]+"</a></li>" + NEW_LINE;

        int diff = length(contentOfFile, 2) - fileIndex - 1;
        int tempNb = 0;
        if(diff > 0){
            tempNb = fileIndex + 2;
            result = result + "        <li><a href=\"produit"+tempNb+".html\">"+contentOfFile[IDX_NOM][fileIndex + 1 ]+"</a></li>" + NEW_LINE;

            if(diff > 1){
                tempNb = fileIndex + 3;
                result = result +  "        <li><a href=\"produit"+tempNb+".html\">"+contentOfFile[IDX_NOM][fileIndex + 2 ]+"</a></li>" + NEW_LINE;

                if(diff > 2){
                    tempNb = fileIndex + 4;
                    result = result +  "        <li><a href=\"produit"+tempNb+".html\">"+contentOfFile[IDX_NOM][fileIndex + 3 ]+"</a></li>" + NEW_LINE;

                    if(diff > 3){
                        tempNb = fileIndex + 5;
                        result = result +  "        <li><a href=\"produit"+tempNb+".html\">"+contentOfFile[IDX_NOM][fileIndex + 4 ]+"</a></li>" + NEW_LINE;
                    }
                }
            }

        }

        result = result +  "      </ul>" + NEW_LINE+ "    </nav>" + NEW_LINE +  "    <main>" + NEW_LINE + "      <section>" + NEW_LINE;   
        return result;
    }
    String getIndexPageCore(String input){                          
        return input +  "        <h2>Tout ce que vous avez toujours voulu savoir sur les vieux ordis sans jamais avoir osé le demander !</h2>" + NEW_LINE +
                        "          <p>" + NEW_LINE +
                        "Bienvenue dans le musée virtuel d'ordinateurs mythiques de l'histoire de l'informatique. Vous trouverez ici des éléments sur quelques machines qui ont marqué l'histoire de l'informatique que cela soit par leurs caractéristiques techniques ou l'impact commercial qu'elles ont eu et qui ont contribué au développement du secteur informatique." + NEW_LINE +
                        "          </p>" + NEW_LINE;
    }

    String getPageCore(String input, String[][] contentOfFile, int fileIndex){
        return input +  "        <h2>"+contentOfFile[IDX_NOM][fileIndex]+" ("+contentOfFile[IDX_ENTREPRISE][fileIndex]+")</h2>" + NEW_LINE +
                        "        <h3>"+contentOfFile[IDX_PRIX][fileIndex]+" (Sortie en "+contentOfFile[IDX_DATE][fileIndex]+")</h3>" + NEW_LINE + 
                        "        <p>" + NEW_LINE + contentOfFile[IDX_DESCRIPTION][fileIndex] + NEW_LINE +"        </p>" + NEW_LINE;
    }

    String getBaseEnd(){
        return  "      </section>" + NEW_LINE + "    </main>" + NEW_LINE + "  </body>"+NEW_LINE + "</html>"; 
    }

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
}
class Generateur extends Program 
{
    String fileAsString(String filename)
    {
        extensions.File f = new extensions.File(filename);
        String content = "";
        while (ready(f)) {
        content = content + readLine(f) + '\n';
        }
        return content;
    }

    void algorithm()
    {
        print("<!DOCTYPE html>" + '\n');
		print("<html lang=\"fr\">" + '\n');
        print("    <head>" + '\n');
        print("      <title> Zen of Python </title>" + '\n');
        print("      <meta charset=\"utf-8\">" + '\n');
        print("    </head>" + '\n');
        print("    <body>" + '\n');
        print("      <p>" + '\n');
        String texte = fileAsString("data/Zen of Python.txt");
        print(texte);
        print("    </p>" + '\n');
        print("  </body>" + '\n');
        print("</html>");
    }
}
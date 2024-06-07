package tp05;

public class Book
{
    private String code;
    private final String title;
    private final String author;
    private final int publicationYear;
    private int user; // 0 = default

    public Book(String c, String t, String a, int p, int u)
    {
        this.code = c;
        this.title = t;
        this.author = a;
        this.publicationYear = p;
        this.user = u;
    }

    public String getCode()
    {
        return code;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public int getPubliYear()
    {
        return publicationYear;
    }

    public int getUser()
    {
        return user;
    }

    public boolean borrow(int borrower)
    {
        this.user = borrower;
        if(this.getUser() != 0)
        {
            return true;
        }
        return false;
    }

    public boolean giveBack()
    {
        if(this.isAvailable())
        {
            return false;
        }
        else
        {
            this.user = 0;
            return true;
        }
    }

    public boolean equals(Book obj)
    {
        if(this == obj) { return true; }
        if(this.getCode().equals(obj.getCode())) { return true; }
        if((this.getAuthor().equals(obj.getAuthor())) && (this.getTitle().equals(obj.getTitle()))) { return true; }
        if(this == null || obj == null) { return false; }
        return false;
    }

    public boolean isAvailable()
    {
        if(this.getUser() == 0)
        {
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return "Code : "+getCode()+" | Nom : "+getTitle()+" | Auteur : "+getAuthor()+" | Publication : "+getPubliYear()+'\n';
    }
}
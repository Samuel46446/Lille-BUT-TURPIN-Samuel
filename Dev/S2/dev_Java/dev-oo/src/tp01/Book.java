package tp01;

class Book
{
    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return this.author;
    }
    public String getTitle() {
        return this.title;
    }
    public String print() {
        return author + "\t" + title + "\t" + year;
    }

    @Override
    public String toString()
    {
        return author + " a écrit " + title + " en " + year;
    }
}
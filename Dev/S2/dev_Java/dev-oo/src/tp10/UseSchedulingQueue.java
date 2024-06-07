package tp10;

import tp05.Book;

public class UseSchedulingQueue
{
    public static void main(String[] args)
    {
        SchedulingQueue<Book> superBook = new SchedulingQueue<>();
        SchedulingQueue<Task> amongus = new SchedulingQueue<>();

        Book b1 = new Book("pfj", "ao", "zez", 1951, 0);
        Book b2 = new Book("kko", "ss", "neo", 1985, 0);

        Task t1 = new Task("t1", 3);
        Task t2 = new Task("t2", 1);

        superBook.addElement(b1);
        superBook.addElement(b2);

        amongus.addElement(t1);
        amongus.addElement(t2);

        System.out.println(superBook.isEmpty());
        System.out.println(amongus.isEmpty());
        System.out.println(superBook.size());
        System.out.println(amongus.size());

        System.out.println(superBook);
        System.out.println(amongus);

        System.out.println(superBook);
        System.out.println(amongus);
    }   
}
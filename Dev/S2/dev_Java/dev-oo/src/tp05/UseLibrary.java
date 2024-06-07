package tp05;

public class UseLibrary
{
	public static void main(String[] args)
	{
		Library lib = new Library();
		lib.addBook(new Book("mc", "Minecaft", "None", 2010, 0));
		lib.addBook(new Book("nes", "Nees 1985", "N", 2000, 0));
		lib.addBook(new Book("fr", "Ma France", "Geaul", 1956, 0));

		System.out.println(lib.getBook("nes"));
		System.out.println(lib);
	}
}
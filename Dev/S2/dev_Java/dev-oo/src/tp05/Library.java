package tp05;

import java.util.ArrayList;

public class Library
{
	private ArrayList<Book> books = new ArrayList<>();

	public Book getBook(String code)
	{
		for(int i = 0; i <= books.size() - 1; i++)
		{
			if(code.equals(books.get(i).getCode()))
			{
				return books.get(i);
			}
		}
		return null;
	}

	public boolean addBook(Book b)
	{
		return books.add(b);
	}

	public boolean removeBook(String aCode)
	{
		for(int i = 0; i <= books.size() - 1; i++)
		{
			if(aCode.equals(books.get(i).getCode()))
			{
				return books.remove(i) != null;
			}
		}
		return false;
	}

	public boolean removeBook(Book b)
	{
		return books.remove(b);
	}

	public String borrowings()
	{
		String str = "";
		for(int i = 0; i <= books.size() - 1; i++)
		{
			if(books.get(i).getUser() == 0)
			{
				str=str+books.get(i);
			}
		}
		return str;
	}

	public boolean borrow(String code, int borrower)
	{
		for(int i = 0; i <= books.size() - 1; i++)
		{
			if(code.equals(books.get(i).getCode()))
			{
				return books.get(i).borrow(borrower);
			}
		}
		return false;
	}

	public boolean giveBack(String code)
	{
		for(int i = 0; i <= books.size() - 1; i++)
		{
			if(code.equals(books.get(i).getCode()))
			{
				return books.get(i).giveBack();
			}
		}
		return false;
	}

	@Override
	public String toString()
	{
		String str = "";

		for(int i = 0; i <= books.size() - 1; i++)
		{
			Book b = books.get(i);
			str=str+"Code : "+b.getCode()+" | Nom : "+b.getTitle()+" | Auteur : "+b.getAuthor()+" | Publication : "+b.getPubliYear()+'\n';
		}
		return str;
	}
}
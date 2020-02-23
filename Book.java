package Project;

public class Book {

	/*class Books
	{*/
		private String name;
		private Author author;
		private double price;
		private int qty;
		Book(String name, Author author, double price)
		{
			this.name=name;
			this.author=author;
			this.price=price;
		}
		Book(String name, Author author, double price, int qty)
		{
			this.name=name;
			this.author=author;
			this.price=price;
			this.qty=qty;
		}
		Book(Book b)
		{
			this.name=b.name;
			this.author=b.author;
			this.price=b.price;
			this.qty=1;
		}
		public String getName()
		{
			return name;
		}
		public Author getAuthor()
		{
			return author;
		}
		public double getPrice()
		{
			return price;
		}
		public void setPrice(double price)
		{
			this.price=price;
		}
		public int getQty()
		{
			return qty;
		}
		public void setQty(int qty)
		{
			this.qty=qty;
		}
		public String display()
		{
			String s="[name="+name+",Author="+author.display()+"price="+price+",quantity="+qty+"]";
			return s;
		}
	}
/* Ankit Raj Biswal
1941012238
CSE D*/


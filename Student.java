package Project;
import java.util.Scanner;
public class Student {

		String name;
		int roll,qty;
		Date issueDate, returnDate;
		Book list[] = new Book[5];
		Book b[];
		Student(String name, int roll, Book b[])
		{
			this.name=name;
			this.roll=roll;
			this.b=b;
			qty=0;
		}
		public Student(String string, int i) {
			// TODO Auto-generated constructor stub
		}
		public String getName()
		{
			return name;
		}
		public int getRoll()
		{
			return roll;
		}
		public void issueBook()
		{
			
			if(qty<5)
			{
				Scanner in = new Scanner(System.in);
				System.out.println("Books Available for issue :");
				for(int i=0; i<10; i++)
				{
					System.out.println(b[i].display());			
				}
				System.out.print("Enter Name of Book to Issue :");
				String bName=in.nextLine();
				boolean k=getIssue(bName);
				if(k)
				{
					System.out.println("Enter the Todays date in DDMMYYYY format :");
					String dt=in.nextLine();
					try
					{
						int dd=Integer.parseInt(dt.substring(0,2));
						int mm=Integer.parseInt(dt.substring(2,4));
						int yyyy=Integer.parseInt(dt.substring(4,8));
						issueDate = new Date(dd,mm,yyyy);
					}
					catch(StringIndexOutOfBoundsException e)
					{
						System.out.println("Invalid Date Format\nTaking Date as 00000000");
						issueDate = new Date(00,00,0000);
					}
					qty++;
					System.out.println("The Book\""+bName.toUpperCase()+"\" issued to "+name);
				}
				else
				{
					System.out.println("Book Issue Failed");
				}
			}
			else
			{
				System.out.println("Book Issue Limit Exceeded");
				System.out.println("Book Issue Failed");
			}
		}
		public boolean getIssue(String s)
		{
			int n=-1;
			for(int i=0; i<10; i++)
			{
				String nm=b[i].getName();
				if(nm.equalsIgnoreCase(s))
				{
					n=i;
					System.out.println("Book Found Getting an Issue");
					break;
				}
			}
			if(n!=-1)
			{
				int t=b[n].getQty();
				if(t!=0)
				{
					//System.out.println("quantity reduced from "+t);
					b[n].setQty(t-1);
					addBook(b[n]);
					return true;
				}
				else
				{
					System.out.println("Book Not is Stock");
					return false;
				}
			}
			else
			{
				System.out.println("Book not Found");
				return false;
			}
		}
		public void depositBook()
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Issued Books are :");
			issueList();
			System.out.println("Name of Book to Return");
			String bName=in.nextLine();
			boolean k=returnBook(bName);

			if(k)
			{
				System.out.println("Enter the Todays date in DDMMYYYY format :");
				String dt=in.nextLine();
				try
				{
					int dd=Integer.parseInt(dt.substring(0,2));
					int mm=Integer.parseInt(dt.substring(2,4));
					int yyyy=Integer.parseInt(dt.substring(4,8));
					returnDate = new Date(dd,mm,yyyy);
				}
				catch(StringIndexOutOfBoundsException e)
				{
					System.out.println("Date Entered in Wrong Format\nTaking date as 00000000");
					returnDate = new Date(00,00,0000);
				}
				qty--;
				System.out.println("Book Unissued Successfuly");
			}
			else
			{
				System.out.println("Book Unissueing Failed");
			}
		}
		public boolean returnBook(String s)
		{
			int n=-1;
			for(int i=0; i<list.length; i++)
			{
				int t=-1;
				String nm=list[i].getName();
				if(nm.equalsIgnoreCase(s))
				{
					t=i;
				}
				try
				{
					if(removeBook(list[t]))
					{
						n=i;
						System.out.println("Book Found, Unissueing");
						break;
					}
				}
				catch(Exception e)
				{
					//Nothing to do Errors Expected
				}
			}
			if(n!=-1)
			{
				int t=b[n].getQty();
				b[n].setQty(t+1);
				return true;
			}
			else
			{
				System.out.println("Book not Found\nCheck The Name of the Book");
				return false;
			}
		}
		public boolean removeBook(Book bk)
		{
			String s=bk.display();
			for(int i=0; i<list.length; i++)
			{
				if(s.equals(list[i].display()))
				{
					list[i]=null;
					System.out.println("Book Removed from Students issue list !!");
					return true;
				}
			}
			System.out.println("Book Not found !!");
			return false;
		}
		public void addBook(Book bk)
		{
			String s=bk.display();
			for(int i=0; i<list.length; i++)
			{
				try
				{
					list[i].display();
				}
				catch(NullPointerException e)
				{
					//throw exception because the object not initalized
					System.out.println("Book Added to Issue List");
					list[i] = new Book(bk.getName(), bk.getAuthor(), bk.getPrice(), 1);
					break;
				}
			}
		}
		public void issueList()
		{
			for(int i=0; i<list.length; i++)
			{
				try
				{
					System.out.println(list[i].display());
				}
				catch(NullPointerException e)
				{
					//Book slot is empty
				}
			}
		}
	}
/* Ankit Raj Biswal
1941012238
CSE D*/


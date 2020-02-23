package Project;
import java.util.Scanner;



public class Test {
	
	
		final public String programAuthorName="	Ankit Raj Biswal";
		final public String registrationNumber="1941012238";
		Book b[] = new Book[10];
		Student student[];
		public static void main(String args[])
		{
			Scanner in = new Scanner(System.in);
		Test ob = new Test();
			ob.randomBookGen();
			System.out.print("Enter the Number of Students :");
			int n=in.nextInt();
			ob.createStudentArray(n);
			ob.basicinfo();
			while(true)
			{
				System.out.println("You Have Entered an Infinite Loop\n to Exit press 0 when asked to Exit");
				int index=ob.init();
				ob.choice(index);
				System.out.println("Do you want to Exit ??");
				System.out.println("Press any number to continue");
				System.out.println("Press 0 to Exit");
				int i=in.nextInt();
				if(i==0)
					break;
			}
		}
		public int init()
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Press ");
			for(int i=0; i<student.length; i++)
			{
				System.out.println(i+" for "+student[i].getName()+" (Roll Number "+student[i].getRoll()+")");
			}
			int n=in.nextInt();
			if(n<0 || n>=student.length)
			{
				System.out.println("Invalid Selection");
				System.out.println("Default Selection 0");
				return 0;
			}
			return n;
		}
		public void choice(int index)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("What do you want to do ??");
			System.out.println("Press 1 for Issue a Book");
			System.out.println("Press 2 to Return a Book");
			System.out.println("Press 3 to View of Issued Books");
			switch(in.nextInt())
			{
				case 1:
				student[index].issueBook();
				break;
				case 2:
				student[index].depositBook();
				break;
				case 3:
				student[index].issueList();
				break;
				default:
				System.out.println("Invalid Selection");
				System.out.println("Operation Failed");
			}
		}
		public void basicinfo()
		{
			Scanner in = new Scanner(System.in);
			for(int i=0; i<student.length; i++)
			{
				System.out.print("Enter the Name : ");
				String nm=in.nextLine();
				System.out.print("Enter the Roll Number :");
				int rn=in.nextInt();
				student[i] = new Student(nm,rn,b);
				in.nextLine();
			}
		}
		public void createStudentArray(int n)
		{
			student = new Student[n];
		}
		public void randomBookGen()
		{
			for(int i=0; i<10; i++)
			{
				b[i] = new Book(randomName(10),randomAuthor(),(int)(Math.random()*2000),(int)(Math.random()*10));
			
			}
		}
		public String randomName(int n)
		{
			String s="";
			for(int i=0; i<n; i++)
			{
				s=s+(char)((int)(65+Math.random()*26));
			}
			return s;
		}
		public Author randomAuthor()
		{
			char ch='M';
			switch((int)(Math.random()*2))
			{
				case 0:
				ch='M';
				break;
				case 1:
				ch='F';
				break;
			}
			Author a = new Author(randomName(5)+" "+randomName(5), randomName(5)+"@gmail.com", ch);
			return a;
		}
}

/* Ankit Raj Biswal
1941012238
CSE D*/
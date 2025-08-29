import java.util.*;
import java.io.*;
import java.nio.file.*;
class Student
{
	static String filename="Student_details.txt";
	static void ViewAll(int id,String name,String branch,String Section)
	{
		try{
		BufferedReader read =new BufferedReader(new FileReader(filename));
		boolean flag=false;
		String line;
		while((line=read.readLine())!=null)
		{
			String[] p=line.split(" ");
			if(Integer.parseInt(p[0])==id)
			{
				flag=true;
				break;
			}
		}
		read.close();
		if(flag){	System.out.println("already present");}

		else{
			FileWriter writer =new FileWriter(filename,true);
			writer.write(id+" "+ name+" " + branch+" " + Section+"\n");
			writer.close();
			System.out.println("Student data enterd");
		  }
		}
		catch(IOException e){
			System.out.println("error");
			}
	}	
	static void getAllStudent()
	{
		try{
		BufferedReader reader =new BufferedReader(new FileReader(filename));
		int count=1;
		String line;
		while((line=reader.readLine())!=null)
			System.out.println(line);
		reader.close();
		}
		catch(IOException e){
			System.out.println("error");
			}

	}
	static void getStudentById(int id)
	{	
		try
		{
		BufferedReader read =new BufferedReader(new FileReader(filename));
		boolean flag=false;
		String line;
		while((line=read.readLine())!=null)
		{
			String[] p=line.split(" ");
			if(Integer.parseInt(p[0])==id)
			{
				System.out.println(p[0]+" "+p[1]+" "+p[2]+" "+p[3]);
				flag=true;
				break;
			}
		}
		read.close();
		if(!flag)	System.out.println("not found");
		}
		catch(IOException e){
			System.out.println("error");
			}

	}
	static void getStudentByName(String name)
	{
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader(filename));
			boolean flag=false;
			String line;
			while((line=reader.readLine())!=null)
			{
				String[] p=line.split(" ");
				if(p[1].equals(name))
				{
					System.out.println(p[0]+" "+p[1]+" "+p[2]+" "+p[3]);
					flag=true;
				}
			}
			reader.close();
			if(!flag)	System.out.println("not found");
		}
		catch(IOException e)
		{
			System.out.println("error");
		}	

	}
	static void deleteStudentById(int id)
	{
		try{
			File replace=new File("replace.txt");
			File file=new File(filename);
			BufferedReader reader=new BufferedReader(new FileReader(file));
			BufferedWriter writer=new BufferedWriter(new FileWriter(replace));

			boolean flag=false;
			String line;
			while((line=reader.readLine())!=null)
			{
				String[] p=line.split(" ");
				if(Integer.parseInt(p[0])==id)
				{
					flag=true;
					continue;
				}
				writer.write(line+System.lineSeparator());
			}
			reader.close();writer.close();
			if(flag)
			{
				Files.delete(file.toPath());
				Files.move(replace.toPath(),file.toPath(),StandardCopyOption.REPLACE_EXISTING);
				System.out.println("done");
			}
			else{
				replace.delete();
				System.out.println("not found");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	static void getStudentByBranch(String branch)
	{
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader(filename));
			boolean flag=false;
			String line;
			while((line=reader.readLine())!=null)
			{
				String[] p=line.split(" ");
				if(p[2].equals(branch))
				{
					System.out.println(p[0]+" "+p[1]+" "+p[2]+" "+p[3]);
					flag=true;
				}
			}
			reader.close();
			if(!flag)	System.out.println("not found");
		}
		catch(IOException e)
		{
			System.out.println("error");
		}	
	}
	static void getStudentBySection(String branch,String sec)
	{
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader(filename));
			boolean flag=false;
			String line;
			while((line=reader.readLine())!=null)
			{
				String[] p=line.split(" ");
				if(p[2].equals(branch) & p[3].equals(sec))
				{
					System.out.println(p[0]+" "+p[1]+" "+p[2]+" "+p[3]);
					flag=true;
				}
			}
			reader.close();
			if(!flag)	System.out.println("not found");
		}
		catch(IOException e)
		{
			System.out.println("error");
		}	
	}

								
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Enter Student\n2.view all Student\n3.view by id \n4.view by name\n5.delete by id\n6.get all student in branch\n7.get all student by section\n8.exit");
		int choice=sc.nextInt();
		int id;
		String name,branch,Section; 
		while(choice<8 && choice>0)
		{
			switch(choice)
			{
				case 1:
					System.out.println("Enter Student Id:");
					id=sc.nextInt();
					System.out.println("Enter Student name:");
					name=sc.next();
					System.out.println("Enter Student branch:");
					branch=sc.next();
					System.out.println("Enter Student section:");
					Section=sc.next();
					ViewAll(id,name,branch,Section);
					break;
				case 2:
					getAllStudent();
					break;
				case 3:
					System.out.println("Enter Student Id:");
					id=sc.nextInt();
					getStudentById(id);
					break;
				case 4:
					System.out.println("Enter Student name:");
					name=sc.next();
					getStudentByName(name);
					break;
				case 5:
					System.out.println("Enter Student Id:");
					id=sc.nextInt();
					deleteStudentById(id);
					break;
				case 6:
					System.out.println("Enter Student branch:");
					branch=sc.next();
					getStudentByBranch(branch);
					break;
				case 7:
					System.out.println("Enter Student branch:");
					branch=sc.next();
					System.out.println("Enter Student section:");
					Section=sc.next();
					getStudentBySection(branch,Section);
					break; 
			}
			System.out.println("1.Enter Student\n2.view all Student\n3.view by id \n4.view by name\n5.delete by id\n6.get all student in branch\n7.get all student by section\n8.exit");	choice=sc.nextInt();
		}
	}
}
					

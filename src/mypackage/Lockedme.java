package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Lockedme 
{
	static final String pathOfTheFile="D:\\LockedmeFile";
	static final String error="Some error occured. Please contact admin@Lockedme.com";
	final static Scanner obj=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
			
			int ch;
		do
		{
			getDisplay();
			System.out.println("Enter your choice:");
			ch=Integer.parseInt(obj.nextLine());
			
			switch(ch)
			{
			case 1:addFile();
			break;
			case 2:deleteFile();
			break;
			case 3:searchFile();
			break;
			case 4:getAllFile();
			break;
			case 5:System.exit(0);
			break;
			default:System.out.println("Invalid option");
			break;
			}
		}
		while(ch>0);
		
        obj.close();
		
	}
	
	public static void getDisplay()
	{
		System.out.println("\t\t Welcome Lockedme.com");
		System.out.println("\t\tDeveloped by: Taniya Batabyal");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("1.Add a File");
		System.out.println("2.Delete a File");
		System.out.println("3.Search a File");
		System.out.println("4.Display all Files");
		System.out.println("5.Exit");
	}
	
	public static void addFile()
	{
		try
		{
			System.out.println("Enter the file name which you want to add");
			String fileName = obj.nextLine();
			File folder = new File(pathOfTheFile);
			File[] listOfFiles = folder.listFiles();
			
			LinkedList<String> filename = new LinkedList<String>();
			 
			for(var l:listOfFiles)
			 
				 filename.add(l.getName());
			 
			if(filename.contains(fileName))
			
				System.out.println("File name already exist.Please choose another name of the file");
			else
			{
				System.out.println("Enter how many lines you want to add");
				int line=Integer.parseInt(obj.nextLine());
				
				FileWriter myWriter= new FileWriter(pathOfTheFile+ "\\"+ fileName);
				for(int i=1;i<=line;i++)
				{
					System.out.println("Enter the line ");
					myWriter.write(obj.nextLine()+"\n");
				}
				System.out.println("File added successful");
				
				myWriter.close();
			}
			
		}
		catch(Exception ex)
		{
			System.out.println(error);
		}
	}
	public static void deleteFile()
	{
		try
		{
		 String fileName;
		 
		 
		 System.out.println("Enter the name of the file which you want to delete");
		 fileName=obj.nextLine();
		 File file = new File(pathOfTheFile+ "\\"+ fileName);
         
	        if(file.exists())
	        {
	        	file.delete();
	            System.out.println("File deleted successfully");
	        }
	        else
	            System.out.println("File not exist");
	        
	      
		}
		catch(Exception ex)
		{
			System.out.println(error);
		}
	}
	public static void searchFile()
	{
		try
		{
		 String fileName;
		 
		 
		 System.out.println("Enter the name of the file which you want to search");
		 fileName=obj.nextLine();
		 
		 File folder = new File(pathOfTheFile);
		 File[] listOfFiles = folder.listFiles();
		 
		 LinkedList<String> filename = new LinkedList<String>();
		 
		 for(var l:listOfFiles)
		 
			 filename.add(l.getName());
		 
		if(filename.contains(fileName))
		
			System.out.println("File exist.");
		
		else
			System.out.println("File not exist");
		
	     
		}
		catch(Exception ex)
		{
			System.out.println(error);
			
		}
	}
	public static void getAllFile()
	{
		try
		{
			File folder = new File(pathOfTheFile);
			File[] listOfFiles = folder.listFiles();
			
			if(listOfFiles.length==0)
			{
				System.out.println("No files exit");
			}
			else
			{
				for(var l:listOfFiles)
				 {
					 System.out.println(l.getName());
				 }
			}
		}
		catch(Exception ex)
		{
			System.out.println(error);
		}
	}

 }

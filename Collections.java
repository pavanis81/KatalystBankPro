package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.example.ShopWebsite.Employee;

public class Collections {

	public static void main(String[] args) 
	{
        
		

		//LIST    ....... Comparison  ...most developers fav
		//SET     ....... Contains also to remove duplicate
		//MAP     ........ All searching solutions ...
		
		
File file = new File("/Users/Training/class/TempWorkspace/CoreJava/Employee.txt");
		
		try {
			Scanner scanFile = new Scanner(file);
			
			ArrayList<Employee> list = new ArrayList<Employee>();
			
			HashSet<Employee> set = new HashSet<Employee>();
			
			HashMap<String, Employee> map = new HashMap<String, Employee>();
			
			while(scanFile.hasNext())//while you file has a next line read 1 by 1 line
			{
				
				String line = scanFile.nextLine();
				     String splitLine[] = line.split(" ");
				     
				     Employee e = new Employee();
				     
				     e.id=Integer.parseInt(splitLine[0]);
				     e.name=splitLine[1];
				     e.salary=Double.parseDouble(splitLine[2]);
				     e.managerName=splitLine[3];
				
				list.add(e);
				
				set.add(e);
				
				
				map.put(e.id+"",e);
				
			}//At this point all employee from file are now added to List
			
			
			
			///Find all employees that report to bob
			
			for(Employee e  : list)
			{
				if(e.managerName.equals("bob")) System.out.println(e.name);
			}
			
			// Java 8 ways of doing above by using stream api and lambda function
			//Find Employee name who has id 5
			
			for(Employee e  : list)
			{
				if(e.id==5) System.out.println(e.name);
			}
			
			Employee temp=list.stream().filter(e -> e.id == 5).findFirst().orElse(null);
			
			System.out.println(temp.name);
			
			
			
			list.sort((e1,e2) -> e1.name.compareTo(e2.name) );
			
			
			
			///Print all employees in a SET
			Iterator<Employee> iter = set.iterator();
			
			while(iter.hasNext()) System.out.println(iter.next().name);
			
			
			//Below we see how we implement search using MAP
			
			Scanner scanConsole= new Scanner(System.in);
			
			System.out.println(" Please eneter id of employee whose details"
					+ "you wish to see");
			
			int id = scanConsole.nextInt();
			
			System.out.println(" Details of employee you are searching are");
			
			Employee found= map.get(id+"");
			
			System.out.println(found.name + found.salary);
			
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		i had changed something
		
		
		
		
		
		
		
		
		
		

	}

}

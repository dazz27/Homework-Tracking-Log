package Hwprogress.pkg;

import java.io.*;
import java.util.*;
import java.sql.*;

public class ProgressTracking {
	//declare arraylists
	ArrayList<Student> students;
	ArrayList<Employee> staff;
	ArrayList<Homework> hw;
	ArrayList<AssignedHomeworks> givenHW;
	Scanner input = new Scanner(System.in);
	int studCounter = 0;
	int hwCounter = 0;
	int empID = 0;

	//int empID = 0; //used for login to keep track of what employee is logged in
	//int counter = 0;
	
	ProgressTracking() throws IOException
	{
		//initialize arraylists
		students = new ArrayList<Student>();
		staff = new ArrayList<Employee>();
		hw = new ArrayList<Homework>();	
		givenHW = new ArrayList<AssignedHomeworks>();
	}
	
	//function - load test data
	
	void loadData() {
		//create 3 students, 5 homeworks, 4 staff
		java.util.Date tdate = new java.util.Date();  
		
		students.add(new Student(1, "Derwin", "Davis", '5', "521"));
		students.add(new Student(2, "Jason", "Pitts", '4', "422"));
		students.add(new Student(3, "Malik", "Wright", '3', "301"));
		studCounter = students.get(students.size() - 1).getStudID(); //sets the counter to the last index of the arraylist

		// hwid, empid, studid, date, score, checked
		//this section is not really needed, because I am using the arraylists for assigned homeworks in the student class
		givenHW.add(new AssignedHomeworks(1, 1, 1, tdate, -1, true));
		givenHW.add(new AssignedHomeworks(2, 1, 2, tdate, -1, false));
		givenHW.add(new AssignedHomeworks(3, 2, 3, tdate, -1, false));
		givenHW.add(new AssignedHomeworks(4, 3, 4, tdate, -1, true));
		//givenHW.add(new AssignedHomeworks(5, 4, 3, tdate, -1, true));
		
		//these are not necessarly assigned anywhere, because the arraylist above for assigned homeworks are not linked to students
		hw.add(new Homework(1, "Math"));
		hw.add(new Homework(2, "English"));
		hw.add(new Homework(3, "Social Studies"));
		hw.add(new Homework(4, "Science"));
		hwCounter = hw.get(hw.size() - 1).getHwID(); //sets the counter to the last index of the arraylist
		
		// int empID, String jobTitle, String fName, String lName
		staff.add(new Employee(1, "Activity Specialist", "Mark", "Jackson", "password"));
		staff.add(new Employee(2, "Activity Specialist", "Kenny", "Smith", "hat"));
		staff.add(new Employee(3, "Activity Specialist", "Charles", "Barkley", "cat"));
		staff.add(new Employee(4, "Activity Specialist", "Shaquille", "O'Neal", "rat"));
	}
	
	// welcome screen
	 void welcome() throws IOException, NullPointerException
	  {	
		//loop
		    System.out.println("1.) Input New Student Info\n2.) Input Student Homework\n3.) View Student Roster\n4.) View Homework Records\n5.) Update Homework Records\n6.) Exit");
		    int choice = input.nextInt();
		    input.nextLine();
		    
		    switch(choice)
		    {	case(1):
		    	{
	    			newStudent();
	    			break;
		    	}
		    	case(2):
		    	{
		    		inputStudentHWRecords();
		    		break;
		    	}
		    	case(3):
		    	{
		    		viewStudents();
		    		break;
		    	}
		    	case(4):
		    	{
		    		viewHWRecords();
		    		break;
		    	}
		    	case(5):
		    	{
		    		updateHWRecords();
		    		break;
		    	}
		    	case(6):
		    	{	System.out.println("Goodbye!");
			    	System.exit(0);
		    	}
		    	default:
		    	{
		    		System.out.println("Invalid Choice!");
		    	}
		    }	  
	  }
	 
	 //input a new student into the system
	 void newStudent() throws IOException
	 {
		 System.out.println("Enter First Name: ");
		 String fname = input.nextLine();
		 System.out.println("Enter Last Name: ");
		 String lname = input.nextLine();
		 System.out.println("Enter Grade Level: ");
		 char grade = input.next().charAt(0);
		 input.nextLine();
		 System.out.println("Enter Class Number: ");
		 String classNum = input.nextLine();
		 
		 System.out.println("You entered: \n" + fname + "\n" + lname + "\n" + grade + "\n" + classNum + "\n");
		 
		 studCounter++; // keeps track of each student
		 students.add(new Student(studCounter, fname, lname, grade, classNum));
		 //
		 ArrayList<AssignedHomeworks> myHW = new ArrayList<AssignedHomeworks>(); //initializes a new arraylist
		 students.get(studCounter-1).setHwList(myHW); //assigns new arraylist to student
		 //
	 }
	 
	 //input student homework records
	 void inputStudentHWRecords() throws IOException 
	 {
		 java.util.Date date = new java.util.Date();  
		 boolean comp = false;
		 int status = 0;
		 //int studentIndex = 0;
		 
		 System.out.println(date);
		 System.out.println("Enter Student ID: ");
		 int sid = input.nextInt();
		 input.nextLine();
		 System.out.println("How many homework assignments does he/she have?");
		 //System.out.println("How many homework assignments does " + fname + " have?: "); //open database to get name?
		 int hwTotal = input.nextInt();
		 input.nextLine();
		 
		 for(int i = 0; i < hwTotal; i++)
		 {
			 System.out.println("What is the subject for Homework #" + (i + 1) + "?");
			 //System.out.println("1. Math \n2. English \n3. Social Studies \n4. Science");
			 String sub = input.nextLine();
			 //input.nextLine();
			 System.out.println("Enter the Status:");
			 System.out.println("1. Complete \n2. Not Complete");
			 status = input.nextInt();
			 input.nextLine();
			 
			if(status == 1) 
			 {
				 comp = true;
			 }
			else if (status == 2)
			{
				comp = false;
			}
			
			hwCounter++;
			//givenHW.add(new AssignedHomeworks(ahwCounter++, sub, empID, sid, date, -1, comp)); 
			/*for (int j = 0; i < students.size(); i++) //find what index the student is at based on the sid given
			{
				if(sid == students.get(j).getStudID())
				{
					studentIndex = j;
				}
			}*/
			students.get(sid-1).getHwList().add(new AssignedHomeworks(hwCounter, empID, sid, date, -1, comp));
			hw.add(new Homework(hwCounter, sub));
		 }
		 
		// System.out.println("For " + fname + " " + lname + " you entered:" + "\n" + hwTotal + " assignments" + "\n" + statusCount + " Completed" + "\n" + (hwTotal - statusCount) + " Not Completed ");
		 
		 
		// updateDB(); // Should I use this at the end of each function?
	 }
	 
	 //view each student
	 void viewStudents()
	 {
		 System.out.printf("%-15s %-15s %-15s %-15s %-15s %n", 
				 "Student ID:", "First Name:", "Last Name:", "Grade Level:", "Class Number:");
		 for(int i = 0; i < students.size(); i++)
		 {
			 System.out.printf("%-15s %-15s %-15s %-15s %-15s %n", students.get(i).getStudID(), 
					 students.get(i).getfName(), students.get(i).getlName(), 
					 students.get(i).getGrade(), students.get(i).getClassNum());
		 }
		 
		 /*
		 try
		    {
		      String myDriver = "com.microsoft.jdbc.sqlserver.SQLServerDriver"; //get new database
		      String myUrl = "jdbc:sqlserver://DESKTOP-RRGBPKV\\BCS425_TABDB:1433"; 
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      
		      String sel = "SELECT * FROM Student";
		      // create the java statement
		      Statement st = conn.createStatement();
		      
		      // execute the query, and get a java resultset
		     
		      ResultSet rs = st.executeQuery(sel);
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("studID");
		        String fName = rs.getString("fName");
		        String lName = rs.getString("lName");
		        char gradeLVL = rs.getString("gradeLvl").charAt(0);
		        String classNum = rs.getString("classNum");
		        //Do I include the arraylist from the Student class?
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, fName, lName, gradeLVL, classNum);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }*/
	 }
	 
	 //view all the homework records for each student
	 //I think I should be reading from the homework table and the assigned homeworks table
	 void viewHWRecords()
	 {
		 System.out.println("Which student's records would you like to see?");
		 System.out.println("Enter student ID:");
		 int sid = input.nextInt();
		 input.nextLine();
		//sid-1 is used below to grab for the appropriate index
		 
		 System.out.println("Here are all of " + students.get(sid-1).getfName() + "'s" + " homework assignments:");
		 System.out.printf("%-30s %-20s %-20s %-20s %n", "Date:", 
				 "Homework Subject:", "Completion Status:", "Checked By:");
		 for(int i = 0; i < students.get(sid-1).getHwList().size(); i++)
		 {
			 System.out.printf("%-30s %-20s %-20s %-20s %n", students.get(sid-1).getHwList().get(i).getDate(), 
					 hw.get((students.get(sid-1).getHwList().get(i).getHwID())-1).getSubject(), 
					 students.get(sid-1).getHwList().get(i).getChecked(), 
					 staff.get((students.get(sid-1).getHwList().get(i).getEmpID())-1).getfName());
		 }
		// System.out.printf("%-15s, %-15s, %-15s, %-15s", givenHW.get(sid).tdate() + hw.get(index))
		// I may need another class to store the values form students, homeworks, and assigned homeworks 
		
		/* 
		 try
		    {
		      String myDriver = "org.gjt.mm.mysql.Driver"; //get new database
		      String myUrl = "jdbc:mysql://localhost/test";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "");
		      
		      String sel = "SELECT * FROM AssignedHomeworks, Homework WHERE AssignedHomeworks.studID = " 
		    		  + sid + "AND AssignedHomeworks.hwID = Homework.hwID;"; 
			  //second query to get subject from Homework
			  //from assgnhw - based on id
		     
			 // create the java statement
		      Statement st = conn.createStatement();
		      
		      // execute the query, and get a java resultset
		     
		      ResultSet rs = st.executeQuery(sel);
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("hwID");
		        String subject = rs.getString("subject");
		        Date dateCreated = rs.getDate("tdate");
		        int score = -1;
		        Boolean status = rs.getBoolean("compStatus");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s, %s, %s\n", id, subject, dateCreated, score, status);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Error Occurred");
		      System.err.println(e.getMessage());
		    }*/
		  
	 }
	  
	 void updateDB()
	   {
		    try { 
		        String url = "jdbc:sqlserver://DESKTOP-RRGBPKV\\BCS425_TABDB"; //get new database
		        Connection conn = DriverManager.getConnection(url,"",""); 
		        Statement st = conn.createStatement(); 
		       
		        for (int i = 0; i < students.size(); i++) {
		        st.executeUpdate("INSERT INTO Student VALUES (" +
		          students.get(i).getStudID() +","+
		          students.get(i).getfName()+","+
		          students.get(i).getlName()+","+
		          students.get(i).getGrade()+","+
		          students.get(i).getClassNum()+")"); //do i need to add hw arraylist?
		        }
		        
		        for (int i = 0; i < staff.size(); i++) { 
		        st.executeUpdate("INSERT INTO ActivitySpecialist VALUES ("+
		        staff.get(i).getEmpID() +","+ 
		        staff.get(i).getJobTitle() + "," +
		        staff.get(i).getfName()+","+ 
		        staff.get(i).getLName()+")");
		        }
		        
		        for (int i = 0; i < hw.size(); i++) {
		        st.executeUpdate("INSERT INTO Homework VALUES (" + 
		        hw.get(i).getHwID()+","+
		        hw.get(i).getSubject()+ ")");
		        }
		        
		        for (int i = 0; i < givenHW.size(); i++) {
		        st.executeUpdate("INSERT INTO AssignedHomeworks VALUES (" +
		        givenHW.get(i).getHwID() + "," +
		        givenHW.get(i).getEmpID() + "," +
		        givenHW.get(i).getStudID() + "," +
		        givenHW.get(i).getDate() + "," +
		        givenHW.get(i).getScore() + "," +
		        givenHW.get(i).getChecked() + ")");
		        }
		        conn.close(); 
		        
		    } catch (Exception e) { 
		        System.err.println("Exception Error! "); 
		        System.err.println(e.getMessage()); 
		    }

	}
	 
	 boolean login()
	 {
		 boolean loginValid = false;
		 int index = -1;
		 int counter = 0; //keeps track of password login attempts
		 System.out.println("Please enter your employee ID:");
		 int eid = input.nextInt();
		 input.nextLine();
		 empID = eid; //remembers global employee id to use for later
		 
		 for (int i = 0; i < staff.size(); i++)
		 {
			 if(eid == staff.get(i).getEmpID())
			 {
				 System.out.println("Hi " + staff.get(i).getfName());
				 index = i;
			 } 	 
		 }
		 
		if (index > -1) 
		{
			while(counter < 3 && loginValid != true)
			{
					System.out.println("Please enter your password: "); 
					String pwd = input.nextLine();	 
				 
					if(pwd.equals(staff.get(index).getEmpPwd()))
					{
						loginValid = true;
					}
					else if(counter == 2)
					{
						System.out.println("Too many wrong password attempts. Program terminating.");
						System.exit(0);
					}
					else 
					{
						System.out.println("Incorrect password.");
					}
				counter++;
			}
		 }
	 
	 return loginValid;
		/* 
		 try {
		 String myDriver = "org.gjt.mm.mysql.Driver"; //get new database
	      String myUrl = "jdbc:mysql://localhost/test";
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      String sel = "SELECT fName FROM Employee WHERE Employee.empID = " + eid + ";"; 
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(sel);
	      
	      String sel2 = "SELECT empID FROM Employee;";
	      Statement st2 = conn.createStatement();
	      ResultSet rs2 = st.executeQuery(sel2);
	      

	      
	      st.close();
		 }
		 catch (Exception e)
		    {
		      System.err.println("Error Occurred");
		      System.err.println(e.getMessage());
		    }*/
}
	 
	 //write to text file - you can take this out
	 void writeStudent() throws IOException
		{
			FileWriter fw = new FileWriter("students.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
		// Write each student record to the file
		     for (int i = 0; i < students.size(); i++) 
		     {
		      	bw.write(students.get(i).getStudID() + "," +
		      			 students.get(i).getfName() + "," +
		   			     students.get(i).getlName() + "," +
		   			     students.get(i).getGrade() +
		   			     students.get(i).getClassNum() + "\n");
	    	}
		    System.out.println("File written Successfully");
			bw.close();
		}

	 void updateHWRecords() throws IOException
	 {
		 System.out.println("Which student's homework would you like to update?");
		 int sid = input.nextInt(); //inputs student id number
		 //sid-1 is used below to grab for the appropriate index
		 input.nextLine();
		 
		 System.out.println("Here are all of " + students.get(sid-1).getfName() + "'s" + " homework assignments:");
		 System.out.printf(" %-30s %-20s %-20s %-20s %n", "Date:", 
				 "Homework Subject:", "Completion Status:", "Checked By:");
		 for(int i = 0; i < students.get(sid-1).getHwList().size(); i++)
		 {
			 System.out.print(i + ") ");
			 System.out.printf("%-30s %-20s %-20s %-20s %n", students.get(sid-1).getHwList().get(i).getDate(), 
					 hw.get((students.get(sid-1).getHwList().get(i).getHwID())-1).getSubject(), 
					 students.get(sid-1).getHwList().get(i).getChecked(), 
					 staff.get((students.get(sid-1).getHwList().get(i).getEmpID())-1).getfName());
		 }
		 
		 System.out.println("Which homework assignment would you like to update?");
		 int hwID = input.nextInt();
		 input.nextLine();
		 System.out.println("What subject is the homework?");
		 String sub = input.nextLine();
		 System.out.println("What is the completion status? (Enter 1 or 2)");
		 System.out.println("1) Complete \n2) Incomplete");
		 int status = input.nextInt();
		 input.nextLine();
		 boolean comp = false;
		 if(status == 1) 
		 {
			 comp = true;
		 }
		else if (status == 2)
		{
			comp = false;
		}
		 
		 System.out.println("Which employee checked the homework? (Enter the employee ID)");
		 int emp = input.nextInt();
		 input.nextLine();
		//hwid-1 is used below to grab for the appropriate index
		 
		 hw.get((students.get(sid-1).getHwList().get(hwID-1).getHwID())-1).setSubject(sub);
		 students.get(sid-1).getHwList().get(hwID-1).setChecked(comp);
		 students.get(sid-1).getHwList().get(hwID-1).setEmpID(emp);
		 //should I update the date as well?
		 //I could also allow them to view updated info
	 }
	 
	 
	/* void writeHomework() throws IOException
	 {
		 FileWriter fw = new FileWriter("homework.txt", true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 
		 for (int i = 0; i < givenHW.size();)
		 {
			 bw.write(students.get(i).getEmpId() + "," +
		 )
		 }
	 } */
	 
	 //add login employee function - i would like for the system to recognize who's logged into the system so that you can check which employee has checked a specific students's hw
}

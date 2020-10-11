package Hwprogress.pkg;

import java.io.IOException;
//import java.util.ArrayList;

//import java.io.*;
import java.util.Scanner;

public class HWTrackingSystem {
	public static void main(String[] args) throws IOException
	{
		char cont ='x';
		ProgressTracking progress = new ProgressTracking();
		Scanner input;
		input = new Scanner(System.in);
		boolean loginvalid = false;
		int counter = 0;
		
		System.out.println("Welcome to the Homework Progress Tracker.");
		progress.loadData();
		
		while (counter < 3)
		{
			loginvalid = progress.login();
			if(loginvalid)
			{
				do
				{
					progress.welcome();
					System.out.println("Press any key to continue...");
					input.nextLine();
					//System.out.println("Would you like to continue using the program?(y or n)");
					//cont = input.next().charAt(0);
				} while (cont == 'x');
				//while (cont == 'y' || cont == 'Y'); 
				System.out.println("See you next time!");
			}
			else if(counter == 2)
			{
				System.out.println("Too many failed attmpts! Program Terminating!");
				System.exit(0);
			}
			else
			{	
				System.out.println("Invalid ID, Try again!");	
			}
			counter++;
		}
		input.close();
	}
	
}




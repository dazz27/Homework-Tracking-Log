package pkgAppleCard;

import java.io.*;

public class AppleCardProcesses 
{
	
	public static void main(String[] args) throws IOException 
	{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	char choice = 'y';
	AppleCard card = new AppleCard("Apple", "AppleCard", "Darrien Hunt", "0000 0000 0000 0000", "02/24", 3000.00f, 1500.00f);
	while(choice == 'y')
	{
		System.out.println("Welcome to the Apple Credit Card Transaction Machine!");
		System.out.println("Would you like to record a transaction? (y/n)");
		choice = (br.readLine().charAt(0));
		
		if (choice == 'y')
		{
			card.transaction();
			System.out.println("Would you like to enter another transaction?");
			choice = br.readLine().charAt(0);
		}
		
		if (choice == 'n')
		{
			System.out.println("See you Next Time!");
		}
	}
	}
}

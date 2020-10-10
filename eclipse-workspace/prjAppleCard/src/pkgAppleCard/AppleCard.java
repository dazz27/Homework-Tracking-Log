package pkgAppleCard;

import java.io.*;
import java.util.Scanner;

	/*	Project Name: 	AppleCard
	 *  Purpose:  		Create a program that calculates credit transactions for the Apple Card.
	 *  Author:			Darrien Hunt
	 *  Date Created:	February 27th, 2020
	 */

public class AppleCard {

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String companyName;
		String cardName;
		String fullname;
		String cardNum;
		String expDate;
		float maxAmt;
		float cardbal;
		
		public AppleCard(String companyName, String cardName, String fullname, String cardNum, String expDate,
				float maxAmt, float cardbal) {
			super();
			this.companyName = companyName;
			this.cardName = cardName;
			this.fullname = fullname;
			this.cardNum = cardNum;
			this.expDate = expDate;
			this.maxAmt = maxAmt;
			this.cardbal = cardbal;
		}

		
		public AppleCard() {
			super();
			this.companyName = "";
			this.cardName = "";
			this.fullname = "";
			this.cardNum = "";
			this.expDate = "";
			this.maxAmt = 0;
			this.cardbal = 0;
		}


		public String getCompanyName() {
			return companyName;
		}


		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}


		public String getCardName() {
			return cardName;
		}


		public void setCardName(String cardName) {
			this.cardName = cardName;
		}


		public String getFullname() {
			return fullname;
		}


		public void setFullname(String fullname) {
			this.fullname = fullname;
		}


		public String getCardNum() {
			return cardNum;
		}


		public void setCardNum(String cardNum) {
			this.cardNum = cardNum;
		}


		public String getExpDate() {
			return expDate;
		}


		public void setExpDate(String expDate) {
			this.expDate = expDate;
		}


		public double getMaxAmt() {
			return maxAmt;
		}


		public void setMaxAmt(float maxAmt) {
			this.maxAmt = maxAmt;
		}


		public float getCardbal() {
			return cardbal;
		}


		public void setCardbal(float cardbal) {
			this.cardbal = cardbal;
		}
		
		public void transaction() throws NumberFormatException, IOException
		{
			String storeName;
			float amount = 0;
			String transDate;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Enter the store name: ");
			storeName = (br.readLine());
			System.out.println("Enter the amount: ");
			amount = scanner.nextFloat();
			System.out.println("Enter the date of the transaction: ");
			transDate = (br.readLine());		
			
			if(amount > this.cardbal)
				System.out.println("This transaction is declined.");
			
			if (amount <= this.cardbal)
				System.out.println("Transaction approved.");
				this.cardbal = this.cardbal - amount;
				System.out.printf("Your new card balance is: $ %,.2f \n" , this.cardbal);
		}
		

	}


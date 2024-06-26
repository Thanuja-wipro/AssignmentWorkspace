package com.creditcard;
import java.util.Scanner;
public class CreditCardApproval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your credit score: ");
		int creditScore = scanner.nextInt();
		
		System.out.print("Enter your debt amount: ");
		double debt = scanner.nextDouble();
		
		System.out.print("Enter your income amount: ");
		double income = scanner.nextDouble();
		
		System.out.print("Your bankrupcty status in the last 5 years? (yes or no): ");
		String status = scanner.next();
		status = status.toLowerCase();
		
		double incomeRatio = income * 0.3;
		String result = "";
		
		if (creditScore >= 700 && debt <= incomeRatio && status.equals("no")) {
			result = "Your Credit Card is Approved!";
		}else {
			result = "Your Credit Card is not Approved";
		}
		
		System.out.println(result);
		scanner.close();
	}

}

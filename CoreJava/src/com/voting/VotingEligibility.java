package com.voting;
import java.util.Scanner;
public class VotingEligibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your age: ");
		int age = scanner.nextInt();
		
		System.out.print("Citizenship status? (yes or no): ");
		String citizenship = scanner.next();
		
		System.out.print("Felony status? (yes or no): ");
		String felony = scanner.next();
		
		citizenship = citizenship.toLowerCase();
		felony = felony.toLowerCase();
		
		String result = "";
		if (age>=18 && citizenship.equals("yes") && felony.equals("no")) {
			result="You are eligible to vote";
		}else {
			result="You are not eligible to vote";
		}
		
		System.out.println(result);
		scanner.close();
	}

}

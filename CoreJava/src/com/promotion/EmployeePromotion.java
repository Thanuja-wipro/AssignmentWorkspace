package com.promotion;
import java.util.Scanner;
public class EmployeePromotion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your years of service: ");
		int experience = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.print("Enter your performance rating: ");
		String rating = scanner.nextLine();
		
		System.out.print("Enter your training status: ");
		int training = scanner.nextInt();
		
		if(experience>=5 && rating.equals("excellent") && training>=1) {
			System.out.println("You are eligible for promotion");
		}else {
			System.out.println("You are not eligible for promotion");
		}
		
		scanner.close();
	}

}

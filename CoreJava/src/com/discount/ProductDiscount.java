package com.discount;
import java.util.Scanner;
public class ProductDiscount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the product price in dollars: ");
		double price = scanner.nextDouble();
		
		System.out.print("Premium membership status? (true or false): ");
		boolean membershipStatus = scanner.nextBoolean();
		
		double discountAmount = 0;
		if(price>100 && membershipStatus==true) {
			discountAmount = price * 0.2;
		}else if(price>100 && membershipStatus!=true) {
			discountAmount = price * 0.1;
		}else {
			discountAmount = 0;
		}
		
		System.out.println("Your Discount Amount is: " + discountAmount);
		
		scanner.close();
	}

}

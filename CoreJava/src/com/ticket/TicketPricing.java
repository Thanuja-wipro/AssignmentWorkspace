package com.ticket;
import java.util.Scanner;
public class TicketPricing {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter  your age: ");
		int age = scanner.nextInt();
		
		scanner.nextLine();
		System.out.print("Enter the type of Movie: "); 
		String type = scanner.nextLine();
		
		String price="Invalid selection";
		type = type.toLowerCase();
		if(type.equals("regular movie")){
			if(age<18) {
				price="8$";
				
			}else {
				price="18$";
				
			}
		}else if(type.equals("3d movie")) {
			if(age<18) {
				price="10$";
				
			}else {
				price="15$";
				
			}
		}
		System.out.println(price);
		scanner.close();
	}

}

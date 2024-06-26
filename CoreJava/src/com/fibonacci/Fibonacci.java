package com.fibonacci;
import java.util.Scanner;
import java.util.ArrayList;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the no. of terms to generate fibonacci sequence: ");
		int terms = scanner.nextInt();       
		
		ArrayList<Integer> myArray = new ArrayList<>();
		myArray.add(0);
		myArray.add(1);
		
		int sum = 0;
		for (int i=0; i<terms-2; i++) {
			sum = myArray.get(i) + myArray.get(i+1);
			myArray.add(sum);
		}
		
		System.out.println(myArray);
		
//		for(int i: myArray) {
//			System.out.println(i);
//		}
		scanner.close();
	}

}

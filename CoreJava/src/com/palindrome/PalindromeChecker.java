package com.palindrome;
import java.util.Scanner;
public class PalindromeChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the string: ");
		String givenstring = scanner.nextLine();
		
		
		System.out.println(checkPalindrome(givenstring));
		
		scanner.close();
	}
	
	public static boolean checkPalindrome(String word) {
		int length = word.length();
		
		String reversedString = "";
		for(int i=0; i<length; i++) {
			reversedString = word.charAt(i) + reversedString;
		}
		
		if(word.equals(reversedString)) {
			return true;
		}else {
			return false;
		} 
	}

}

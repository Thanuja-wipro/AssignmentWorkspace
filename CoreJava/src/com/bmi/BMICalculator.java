package com.bmi;
import java.util.Scanner;
public class BMICalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your weight in kilograms: ");
		float weight = scanner.nextFloat();
		
		System.out.print("Enter you height in meters: ");
		float height = scanner.nextFloat();
		
		float bmi = weight / (height * height);
		String result = "";
		
		if (bmi < 18.5) {
			result="Underweight";
		}else if ((18.5 <= bmi) && (bmi < 25)) {
			result="Normal weight";
		}else if ((25 <= bmi) && (bmi < 30)) {
			result="Overweight";
		}else {
			result="Obese";
		}

		System.out.println("You are " + result);
		scanner.close();

	}

}

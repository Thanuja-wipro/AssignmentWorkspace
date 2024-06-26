package com.temperature;
import java.util.Scanner;
public class TemperatureConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the temperature value: ");
		String temperature = scanner.nextLine();
		
		int lastIndex = temperature.length()-1;
		
		String tempValue = temperature.substring(0, lastIndex);
		int temp = Integer.parseInt(tempValue);
		
		char ch = temperature.charAt(lastIndex);
		ch = Character.toLowerCase(ch);
		double result=0;
		String finalResult="";
		if (ch == 'c') {
		    result = temp * 9 / 5 + 32; 
		    finalResult = result+"f";
		} else if (ch == 'f') {
		    result = (temp - 32) * 5 / 9;
		    finalResult = result+"c";
		} else {
			System.out.println("Invalid temperature");
		}
		System.out.println(finalResult);
		scanner.close();
	}

}

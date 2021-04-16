/*
Given an integer, num, convert it to hexadecimal and return the result.

Ex: Given the following num…

num = 15, return "f".
Ex: Given the following num…

num = 46, return "2e".
*/


import java.util.*;

public class IntegerToHexadecimal {

	public static String convertToHexadecimal(int number) {
		if (number <= 9)
			return String.valueOf(number);
		StringBuilder sb = new StringBuilder();
		char [] map = new char [] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		while (number > 0) {
			int remainder = number % 16;
			sb.append(map[remainder]);
			number /= 16;
		}
		return sb.reverse().toString();
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println(convertToHexadecimal(number));
	}
}

/*
Given two non-negative numbers, num1 and num2 represented as strings, sum the integers together and return the result as a string.

Ex: Given the following values for num1 and num2...

num1 = “2”, num2 = “5”, return “7”.
Ex: Given the following values for num1 and num2...

num1 = “7”, num2 = “95”, return “102”.
*/


import java.util.*;

public class StringAddition {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2);
		int result = n1 + n2;
		System.out.println(Integer.toString(result));
	}
}
This question is asked by Facebook. Given two integers x and y, return the hamming distance between the two numbers.
Note: The hamming distance between two numbers is the number of bit positions in which the bits differ.

Ex: Given the following integers x and y…

x = 2, y = 4, return 2.
2 in binary is 0 0 1 0
4 in binary is 0 1 0 0
therefore the number of positions in which the bits differ is two.

import java.util.*;

public class Solution {
	// function to convert the decimal to binary
	public static String decimalToBinary(int number) {
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int remainder = number % 2;
			sb.append(remainder);
			number /= 2; 
		}
		return sb.reverse().toString();
	}
	public static int hammingDistance(int number1, int number2) {
		// the base case
		if (number1 == 0 && number2 == 0)
			return 0;
		int xor = number1 ^ number2;
		int hamming = 0;
		String binaryXor = decimalToBinary(xor);
		// now we check for the number of 1's because for xor, same bit gives 0 and different bits give 1
		for (char binaryPiece: binaryXor.toCharArray()) {
			if (binaryPiece == '1')
				hamming += 1;
		}
		return hamming;
	}
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int number1 = sc.nextInt();
		int number2 = sc.nextInt();
		System.out.println(hammingDistance(number1, number2));
	}
}
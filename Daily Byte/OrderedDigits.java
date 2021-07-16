/*
Given two values, low and high, return all values between low and high (inclusive) that contain consecutive digits in sorted order.
Note: low and high will be between one and a million.

Ex: Given the following low and high…

low = 10, high = 25, return [12, 23].
Ex: Given the following low and high…

low = 15, high = 48, return [23, 34, 45].
*/

import java.util.*;

public class OrderedDigits {

	public static List<Integer> sequentialDigit(int low, int high) {
		List<Integer> result = new ArrayList<>();
		for (int i=1; i<=9; i++) {
			backtrackHelper(result, low, high, 0, i);
		}
		Collections.sort(result);
		return result;
	}

	public static void backtrackHelper(List<Integer> result, int low, int high, int currentValue, int i) {
		if (currentValue > high) {
			return;
		}
		if (currentValue >= low) {
			result.add(currentValue);
		}
		if (i > 9) {
			return;
		}
		backtrackHelper(result, low, high, currentValue * 10 + i, i+1);
 	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int low = sc.nextInt();
		int high = sc.nextInt();
		System.out.println(sequentialDigit(low, high));
	}
}
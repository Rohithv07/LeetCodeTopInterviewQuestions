/*
Given an integer array, nums, return the total number of integers within nums that have an even number of digits.

Ex: Given the following nums…

nums = [1, 12, 123], return 1 (12 is the only integer with an even number of digits).
Ex: Given the following nums…

nums = [1, 32, 3492, 23], return 3.
*/


import java.util.*;

public class EvenDigitIntegers {

	public static int howManyEvenDigit(int [] nums, int n) {
		int count = 0;
		for (int number : nums) {
			int currentNumberDigitCount = countDigit(number);
			if (currentNumberDigitCount % 2 == 0)
				count += 1;
		}
		return count;
	}

	// this function executes in O(logn) time complexity : https://stackoverflow.com/questions/50261364/explain-why-time-complexity-for-summing-digits-in-a-number-of-length-n-is-ologn#:~:text=The%20complexity%20is%20proportional%20to,inclusive%20and%2010%5Ed%20exclusive.
	public static int countDigit(int number) {
		int total = 0;
		while (number > 0) {
			total += 1;
			number /= 10;
		}
		return total;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(howManyEvenDigit(nums, n));
	}
}

/*
Given an integer array, nums, return true if there are three consecutive odd values within nums, otherwise, return false.

Ex: Given the following nums…

nums = [1, 2, 3, 4, 5], return false.
Ex: Given the following nums…

nums = [1, 3, 4, 2, 3, 9, 15], return true.
*/


import java.util.*;

public class ThreeInARow {

	public static boolean areThereAny3ConsecutiveNumbers(int [] nums, int n) {
		if (n < 3)
			return false;
		for (int i=0; i<n - 2; i++) {
			int firstNumber = nums[i];
			int secondNumber = nums[i + 1];
			int thirdNumber = nums[i + 2];
			if (firstNumber % 2 != 0 && secondNumber % 2 != 0 && thirdNumber % 2 != 0)
				return true;
		}
		return false;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(areThereAny3ConsecutiveNumbers(nums, n));
	}
}

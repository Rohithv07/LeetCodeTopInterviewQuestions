/*
Given an integer array, nums, return true if for any value within nums its double also exists within the array.

Ex: Given the following nums…

nums = [4, 3, 9, 8], return true (4 and 8 both appear in nums).
Ex: Given the following nums…

nums = [9, 2, 3, 5], return false.
*/


import java.util.*;

public class DoubleValue {

	public static boolean isThereDoubleValue(int [] nums, int n) {
		if (n <= 1)
			return false;
		Set<Integer> set = new HashSet<>();
		for (int number: nums) {
			if (set.contains(number))
				return true;
			set.add(number * 2);
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
		System.out.println(isThereDoubleValue(nums, n));
	}
}


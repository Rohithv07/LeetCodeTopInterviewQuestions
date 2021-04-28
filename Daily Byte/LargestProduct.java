/*
Given a non-negative integer array, nums, return the maximum product you can create with two separate indices i and j.
Note: You may assume the product will not overflow.

Ex: Given the following nums…

nums = [4, 2, 5, 3], return 20 (5 * 4).
Ex: Given the following nums…

nums = [6, 2, 4, 3], return 24.
*/

import java.util.*;

public class LargestProduct {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int firstLarge = Integer.MIN_VALUE;
		int secondLarge = Integer.MIN_VALUE;
		for (int number : nums) {
			if (number > firstLarge) {
				secondLarge = firstLarge;
				firstLarge = number;
			}
			else if (number > secondLarge) {
				secondLarge = number;
			}
		}
		System.out.println(firstLarge * secondLarge);
	}
}

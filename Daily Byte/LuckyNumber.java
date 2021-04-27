/*
Given an array, nums, every value appears twice except for one which only appears once. The value that only appears once is the lucky number. Return the lucky number.

Ex: Given the following nums…

nums = [1, 2, 1], return 2.
Ex: Given the following nums…

nums = [1, 3, 1, 2, 2], return 3.
*/


import java.util.*;

public class LuckyNumber {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int x = 0;
		for (int number : nums) {
			x ^= number;
		}
		System.out.println(x);
	}
}

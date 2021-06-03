/*
Given an integer array, A, return a new array representing the same number with K added to it.

Ex: Given the following A and K...

A = [1, 2, 3], K = 10, return [1, 3, 3].
Ex: Given the following A and K...

A = [9], K = 3, return [1, 2].
*/


import java.util.*;

public class ArraySumK {

	public static List<Integer> createNewNumberList(int [] nums, int k) {
		List<Integer> result = new ArrayList<>();
		int number = 0;
		int length = nums.length;
		for (int i=0; i<length; i++) {
			number += nums[i] * ((int)Math.pow(10, length - i - 1));
		}
		System.out.println(number);
		number += k;
		addDigitAndReverse(result, number);
		return result;
	}

	public static void addDigitAndReverse(List<Integer> result, int number) {
		while (number > 0) {
			int rem = number % 10;
			result.add(rem);
			number /= 10;
		}
		Collections.reverse(result);
		System.out.println(result);
	} 

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(createNewNumberList(nums, k));
	}
}
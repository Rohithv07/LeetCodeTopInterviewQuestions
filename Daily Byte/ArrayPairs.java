/*
You are given an integer array, nums, that contains 2N integers. Return the maximum sum you can create by pairing integers together and summing the minimum values in each of the pairs.

Ex: Given the following nums…

nums = [1, 3, 2, 4], return 4 (min(1, 2) + min(3, 4) = 4).
Ex: Given the following nums…

nums = [2, 4, 2, 8, 4, 3], return 9.
*/


import java.util.*;

public class ArrayPairs {

	public static int maxSumFromMinPairElement(int [] nums, int n) {
		if (n == 2)
			return Math.min(nums[0], nums[1]);
		Arrays.sort(nums);
		int sum = 0;
		int index = 0;
		while (index < n) {
			int element1 = nums[index];
			int element2 = nums[index + 1];
			sum += Math.min(element1, element2);
			index += 2;
		}
		return sum;
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(maxSumFromMinPairElement(nums, n));
	}
}

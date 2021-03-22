/*
Given an integer array, nums, return the largest unique value in nums.

Ex: Given the following nums…

nums = [4, 9, 2, 9], return 4.
Ex: Given the following nums…

nums = [8, 1, 10, 1, 4, 8, 4, 10], return -1.
*/

import java.util.*;

public class LargestUniqueValue {

	public static int uniqueLarge(int [] nums) {
		if (nums.length == 1)
			return nums[0];
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int large = -1;
		for (int key : map.keySet()) {
			if (map.get(key) == 1 && large < key) {
				large = key;
			} 
		}
		return large;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(uniqueLarge(nums));
	}
}
/*
Given an array of integers, nums, and a value k, return the number of continuous subarrays that sum to k.

Ex: Given the following nums and k…

nums = [1,1,4], k = 5, return 1.
Ex: Given the following nums and k…

nums = [3, 2, 2, 1, 1, 1], k = 5, return 3.
*/


import java.util.*;

public class ContinuosSums {

	public static int subArrayCount(int [] nums, int target) {
		int sum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int num : nums) {
			sum += num;
			if (map.containsKey(sum - target)) {
				count += map.get(sum - target);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(subArrayCount(nums, target));
	}
}
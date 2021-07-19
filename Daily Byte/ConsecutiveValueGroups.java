/*
Given an array of integers, nums, and a value k, return whether or not the nums can be split into k groups such that all values within the group are consecutive.

Ex: Given the following nums and k…

nums = [2, 4, 1, 3], k = 2, return true (the nums can be split into two groups [1, 2] and [3, 4]).
Ex: Given the following nums and k…

nums = [5, 3, 10], k = 3, return false.
*/

import java.util.*;

public class ConsecutiveValueGroups {

	public static boolean isPossibleToGroup(int [] nums, int n, int k) {
		if (nums == null || n < k)
			return false;
		Map<Integer, Integer> map = new TreeMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int keys : map.keySet()) {
			if (map.get(keys) > 0) {
				for (int i=k-1; i>=0; i--) {
					if (map.getOrDefault(keys + i, 0) < map.get(keys))
						return false;
					map.put(keys + i, map.get(keys + i) - map.get(keys));
				}
			}
		}
		return true;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(isPossibleToGroup(nums, n, k));
	}
}
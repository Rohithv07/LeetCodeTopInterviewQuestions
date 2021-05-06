/*
Given an integer array, nums, and an integer, k, return whether or not it’s possible to divide nums into groups of size k where every group contains consecutive numbers.

Ex: Given the following nums and k…

nums = [1, 2, 2, 1], k = 2, return true ([1, 2] and [1, 2]).
Ex: Given the following nums and k…

nums = [1, 2, 3, 3], k = 2, return false.
*/

import java.util.*;

public class DivideToKGroups {

	public static boolean canWeSplit(int [] nums, int n, int k) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int key : map.keySet()) {
			if (map.get(key) > 0) {
				for (int i=k-1; i>=0; i--) {
					if (map.getOrDefault(key + i, 0) < map.get(key)) 
						return false;
					map.put(key + i, map.get(key + i) - map.get(key));
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
		System.out.println(canWeSplit(nums, n, k));
	}
}

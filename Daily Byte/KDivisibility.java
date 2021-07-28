/*
Given an integer array, nums, and a value, k, return the total number of contiguous subarrays that are divisible by k.

Ex: Given the following nums and k…

nums = [1, 3, 1, 2, 5], k = 7, return 2 ([1, 3, 1, 2] and [2, 5] both sum to 7).
*/

import java.util.*;

public class KDivisibility {

	public static int countSubArrayMethodHashMap(int [] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int prefixSum = 0;
		int count = 0;
		for (int number : nums) {
			prefixSum = ((((prefixSum + number) % k) + k) % k);
			count += map.getOrDefault(prefixSum, 0);
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		return count;
	}

	public static int countSubArrayMethodArray(int [] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		int [] subarray = new int [k];
		subarray[0] = 1;
		int prefixSum = 0;
		int count = 0;
		for (int number : nums) {
			prefixSum = ((((prefixSum + number) % k) + k) % k); // negative number handling
			count += subarray[prefixSum]++;
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
		int k = sc.nextInt();
		//System.out.println(countSubArrayMethodHashMap(nums, k));
		System.out.println(countSubArrayMethodArray(nums, k));
	}
}
/*
Given an array of integers, nums, every value appears three times except one value which only appears once. Return the value that only appears once.

Ex: Given the following array nums…

nums = [1, 2, 2, 2, 3, 3, 3], return 1.
Ex: Given the following array nums…

nums = [3, 3, 2, 5, 2, 2, 5, 3, 9, 5], return 9.
*/


import java.util.*;

public class OneValue {

	public static int findTheUniqueWithOneOccurance(int [] nums, int n) {
		if (n == 1)
			return nums[0];
		if (n == 0)
			return -1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value == 1)
				return key;
		}
		return -1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(findTheUniqueWithOneOccurance(nums, n));
	}
}

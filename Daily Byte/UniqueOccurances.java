/*
Given an integer array, nums, return true if all values within nums occur a unique number of times. Otherwise, return false.

Ex: Given the following nums…

nums = [1, 3, 3, 2, 2, 2], return true (1 appears once, 3 appears twice, two appears 3 times).
Ex: Given the following nums…

nums = [4, 10], return false (both 4 and 10 occur once).
*/


import java.util.*;

public class UniqueOccurances {

	public static boolean isOccuranceUnique(int [] nums, int n) {
		if (n == 1)
			return true;
		Map<Integer, Integer> freq = new HashMap<>();
		Set<Integer> trackFreq = new HashSet<>();
		for (int number : nums) {
			freq.put(number, freq.getOrDefault(number, 0) + 1);
		}
		for (int key : freq.keySet()) {
			int value = freq.get(key);
			if (trackFreq.contains(value))
				return false;
			trackFreq.add(value);
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
		System.out.println(isOccuranceUnique(nums, n));
	}
}
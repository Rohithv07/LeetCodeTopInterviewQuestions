/*
Given an integer array, nums, return all pairs of numbers whose difference equals the minimum difference in the array.

Ex: Given the following nums…

nums = [4, 2, 3], return [[2, 3], [3, 4]] (the minimum difference between any two elements is one and 3 - 2 = 1 and 4 - 3 = 1).
Ex: Given the following nums…

nums = [6, 2, 5, 3, 1], return [[1, 2], [2, 3], [5, 6]].
*/


import java.util.*;

public class SmallestDifference {

	public static List<List<Integer>> pairsWithMinimumDifference(int [] nums, int n) {
		List<List<Integer>> finalResult = new ArrayList<>();
		if (n <= 1)
			return finalResult;
		Arrays.sort(nums);
		int [] runningDiff = new int [n - 1];
		for (int i=0; i<n-1; i++) {
			runningDiff[i] = nums[i + 1] - nums[i];
		}
		int possibleMinimumValue = Integer.MAX_VALUE;
		for (int number : runningDiff) {
			possibleMinimumValue = Math.min(possibleMinimumValue, number);
		}
		for (int i=0; i<n-1; i++) {
			if (runningDiff[i] == possibleMinimumValue) {
				List<Integer> currentPair = new ArrayList<>();
				currentPair.add(nums[i]);
				currentPair.add(nums[i + 1]);
				finalResult.add(currentPair);
			}
		}
		return finalResult;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(pairsWithMinimumDifference(nums, n));
	}
}

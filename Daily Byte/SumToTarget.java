/*
Given a list of nums and a target, return all the unique combinations of nums that sum to target.

Ex: Given the following nums and target...

nums = [8, 2, 2, 4, 5, 6, 3]
target = 9
return [[2,2,5],[2,3,4],[3,6],[4,5]].
*/

import java.util.*;

public class SumToTarget {

	public static List<List<Integer>> combination(int [] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		Arrays.sort(nums);
		backtrackHelper(result, current, nums, 0, target, 0);
		return result;
	}

	public static void backtrackHelper(List<List<Integer>> result, List<Integer> current, int [] nums, int sum, int target, int currentIndex) {
		if (sum == target) {
			result.add(new ArrayList<>(current));
			return;
		}
		if (sum > target)
			return;
		int previousUsed = -1;
		for (int i=currentIndex; i<nums.length; i++) {
				if (previousUsed != nums[i]) {
				current.add(nums[i]);
				backtrackHelper(result, current, nums, sum + nums[i], target, i+1);
				current.remove(current.size() - 1);
				previousUsed = nums[i];
			}
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(combination(nums, target));
	}
}
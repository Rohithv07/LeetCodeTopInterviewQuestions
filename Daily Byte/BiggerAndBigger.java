/*
Given an integer array, nums, return a list containing all subsets of nums that contain at least two elements and have an increasing sequence.

Ex: Given the following nums…

nums = [1, 2, 3], return [[1,2],[1,2,3],[1,3],[2,3]].
Ex: Given the following nums…

nums = [2, 4, 3, 5], return [[2,4],[2,4,5],[2,3],[2,3,5],[2,5],[4,5],[3,5]].
*/


import java.util.*;

public class BiggerAndBigger {

	public static List<List<Integer>> findAllPossibleSubset(int [] nums, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
			for (int i=0; i<n; i++)
			backtrackHelper(result, current, nums, n, 0, nums[0], set);
		
		return result;
	}

	public static void backtrackHelper(List<List<Integer>> result, List<Integer> current, int [] nums, int n, int start, int previous, Set<List<Integer>> set) {
		if (!set.contains(current) && current.size() >= 2) {
			result.add(new ArrayList<>(current));
			set.add(new ArrayList<>(current));
			return;
		}
		int temp = previous;
		for (int i=start; i<n; i++) {
			if (previous <= nums[i]) {
				current.add(nums[i]);
				previous = nums[i];
				backtrackHelper(result, current, nums, n, i+1, previous, set);
				current.remove(current.size() - 1);
				previous = temp;
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
		System.out.println(findAllPossibleSubset(nums, n));
	}
}

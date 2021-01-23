/*
Given a list of integers, nums, return a list containing all triplets that sum to zero.

Ex: Given the following nums...

nums = [0], return [].
Ex: Given the following nums...

nums = [0, -1, 1, 1, 2, -2], return [[-2,0,2],[-2,1,1],[-1,0,1]].
*/

import java.util.*;

public class Triplets {

	public static List<List<Integer>> findThreeSum(int [] nums) {
		if (nums.length == 0)
			return null;
		List<List<Integer>> result = new ArrayList<>();
		// 1.Sort
		Arrays.sort(nums);
		int length = nums.length;
		for (int i=0; i+2<length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // skip same result
			int j = i + 1;
			int k = length - 1;
			int target = -nums[i];
			while (j < k) {
				// a + b = target
				if (nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					j += 1;
					k -= 1;
					while (j < k && nums[j] == nums[j - 1])
						j += 1; // skip same result
					while (j < k && nums[k] == nums[k + 1])
						k -= 1; // skip same result
				}
				else if (nums[j] + nums[k] > target)
					k -= 1;
				else
					j += 1;
			}
		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++)
			nums[i] = sc.nextInt();
		System.out.println(findThreeSum(nums));
	}
}
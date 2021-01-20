/*
Given an integer array that is sorted in ascending order and a value target, return two unique indices (one based) such that the values at those indices sums to the given target.
Note: If no two such indices exist, return null.

Ex: Given the following nums and target…

nums = [1, 2, 5, 7, 9], target = 10, return [1,5].
Ex: Given the following nums and target…

nums = [1, 3, 8], target = 13, return null.
*/


import java.util.*;

public class AGoodPair {

	public static List<Integer> findGoodPair(int [] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> result = new ArrayList<>();
		for (int i=0; i<nums.length; i++) {
			if (map.containsKey(nums[i])) {
				result.add(map.get(nums[i]));
				result.add(i + 1);
				break;
			}
			else {
				map.put(target - nums[i], i + 1);
			}
		}
		return result.isEmpty() ? null : result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(findGoodPair(nums, target));
	}
}
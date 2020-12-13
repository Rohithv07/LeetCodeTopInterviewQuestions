
This question is asked by Google. Given an array, nums, and an integer k, return whether or not two unique indices exist such that nums[i] = nums[j] and the two indices i and jj are at most k elements apart. Ex: Given the following array nums and value k…

nums = [1, 2, 1], k = 1, return false.
Ex: Given the following array nums and value k…

nums = [2, 3, 2], k = 2, return true.


import java.util.*;
class IdenticalElements {

	public static boolean duplicate(int [] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], i);
			else {
				int previousIndex = map.get(nums[i]);
				if (i - previousIndex == k)
					return true;
			}
		}
		return false;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		int k = sc.nextInt();
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(duplicate(nums, k));
	}
}
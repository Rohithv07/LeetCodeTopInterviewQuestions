/*
Given an array of integers, nums, and an integer, k, return the least number of unique numbers left in nums after removing k elements.
Note: At least one integer will exist in nums and k will always be between zero and nums.length.

Ex: Given the following nums and k…

nums = [1, 4, 3, 3], k = 2, return 1 (remove 1 and 4 and only one unique integer is left which is 3).
*/


import java.util.*;

public class LeastUniqueElements {

	public static int findLeastUniqueElement(int [] nums, int k) {
		if (nums.length == 1)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int number : nums) {
			map.put(number, map.getOrDefault(number, 0) + 1);
		}
		int counter = map.size();
		PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a[0]), map.get(b[0])));
		for (int key : map.keySet()) {
			minHeap.offer(new int [] {key, map.get(key)});
		}
		while (k > 0) {
			int [] current = minHeap.poll();
			if (current[1] > 1) {
				current[1]-=1;
				minHeap.offer(new int []{current[0], current[1]});
			}
			k--;
		}
		return minHeap.size();
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(findLeastUniqueElement(nums, k));
	}
}
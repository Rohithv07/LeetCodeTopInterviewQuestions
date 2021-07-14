/*
You are given an integer array, ids, that represents a list of product IDs. Rearrange the array such that no two adjacent product IDs are equal.
Note: It is guaranteed that an answer exists.

Ex: Given the following ids…

ids = [1, 1, 2, 2], return [1, 2, 1, 2] (the ones are separated by the twos. Note [2, 1, 2, 1] is also an acceptable answer).
Ex: Given the following ids…

ids = [4, 1, 3, 3, 2], return [3, 1, 3, 2, 4].
*/

import java.util.*;

public class UpdateProducts {

	public static int [] rearrange(int [] nums) {
		if (nums == null || nums.length == 0)
			return new int []{};
		if (nums.length == 1)
			return nums;
		int length = nums.length;
		int [] result = new int [length];
		Map<Integer, Integer> count = new HashMap<>();
		for (int number : nums) {
			count.put(number, count.getOrDefault(number, 0) + 1);
		}
		PriorityQueue<Integer> frequencySort = new PriorityQueue<>((a, b) -> Integer.compare(count.get(b), count.get(a)));
		for (int key : count.keySet()) {
			frequencySort.offer(key);
		}
		int index = 0;
		while (!frequencySort.isEmpty()) {
			int currentNumber = frequencySort.poll();
			result[index++] = currentNumber;
			count.put(currentNumber, count.get(currentNumber) - 1);
			if (count.get(currentNumber) > 0) {
				frequencySort.offer(currentNumber);
			}

		}
		return result;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int [] result = rearrange(nums);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}
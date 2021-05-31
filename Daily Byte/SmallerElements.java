/*
Given an integer array, nums, for each nums[i] you need to find the number of elements that are strictly smaller than it. Do this for all values in the array and return the result in an array.

Ex: Given the following nums...

nums = [1, 3], return [0, 1] (1 has 0 elements smaller than it and 3 has 1 element smaller than it).
Ex: Given the following nums...

nums = [4, 2, 9, 10, 3], return [2, 0, 3, 4, 1].
*/

import java.util.*;

public class SmallerElements {

	public static int [] getTheNumberOfSmaller(int [] nums, int n) {
		if (n == 1)
			return new int [] {0};
		int [] clonedArray = nums.clone();
		Arrays.sort(clonedArray);
		Map<Integer, Integer> valueToIndex = new HashMap<>();
		for (int i=0; i<n; i++) {
			valueToIndex.put(nums[i], i);
		}
		for (int i=0; i<n; i++) {
			int index = valueToIndex.get(clonedArray[i]);
			nums[index] = i;
		}
		return nums;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int [] result = getTheNumberOfSmaller(nums, n);
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}
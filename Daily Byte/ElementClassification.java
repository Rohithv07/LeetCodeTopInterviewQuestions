/*
Given an integer array, nums, return an array that represents the classifications of each value within nums.
Note: Classifications start at one, the larger the value in nums, the larger the classification, two elements that have the same value have the same classification, and classifications should be made as small as possible.

Ex: Given the following nums…

nums = [7, 9, 8], return [1, 3, 2] (7 is the smallest value so its classification is 3, 9 is the largest value so its classification is 1, and 8 is the second-largest value so its classification is 2). 
Ex: Given the following nums…

nums = [2, 9, 3, 5, 7, 4, 4], return [1, 6, 2, 4, 5, 3, 3].
*/


import java.util.*;

public class ElementClassification {

	public static int [] afterClassification(int [] nums) {
	int length = nums.length;
	int [] result = new int [length];
	int [] clonedArray = nums.clone();
	Arrays.sort(clonedArray);
	Map<Integer, Integer> map = new HashMap<>();
	int rank = 0;
	for (int number : clonedArray) {
		if (!map.containsKey(number)) {
			rank += 1;
			map.put(number, rank);
		}
	}
	for (int i=0; i<length; i++) {
		int rankValue = map.get(nums[i]);
		result[i] = rankValue;
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
		int [] result = afterClassification(nums);
		for (int number : result)
			System.out.print(number + " ");
	}
}


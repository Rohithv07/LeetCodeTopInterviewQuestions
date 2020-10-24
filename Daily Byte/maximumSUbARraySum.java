This question is asked by Facebook. Given an integer array, return the sum of its contiguous subarray that produces the largest value.
Note: Your subarray must contain at least one value.

Ex: Given the following integer arrays…

nums = [-3,8,-8,2], return 8 (8)
nums = [2, 3,-4, 2], return 5 (2 + 3)
nums = [1, 5,-2, -3, 7], return 8 (1 + 5 + (-2) + (-3) + 7)


// the idea here is our Kadanes algorithm

import java.util.*;
public class Solution {
	public static int maxSubArray(int [] array) {
		if (array.length == 0)
			return 0;
		if (array.length == 1)
			return 1;
		int max = array[0];
		int current = max;
		for (int i=1; i<array.length; i++) {
			current = Math.max(current+array[i], array[i]);
			max = Math.max(max, current);
		}
		return max;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] array = new int [n];
		for (int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		System.out.println(maxSubArray(array));
	}
}

// O{lengthOfArray}

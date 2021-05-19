/*
Given an integer array, nums, replace each element with the largest value that occurs to the right of it and return the array.
Note: The rightmost element should be replaced with -1.

Ex: Given the following nums…

nums = [5, 2, 3], return [3, 3, -1].
Ex: Given the following nums…

nums = [10, 2, 5, 8, 9], return [9,9,9,9,-1].
*/

import java.util.*;

public class UpdateArray {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		int [] result = new int [n];
		for (int i=1; i<n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				result[stack.pop()] = nums[i];
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		for (int number : result) {
			System.out.print(number + " ");
		}
	}
}
This question is asked by Amazon. Given an array of integers, nums, sort the array in any manner such that when i is even, nums[i] is even and when i is odd, nums[i] is odd.
Note: It is guaranteed that a valid sorting of nums exists.

Ex: Given the following array nums…

nums = [1, 2, 3, 4], one possible way to sort the array is [2,1,4,3]

import java.util.*;

public class Solution {
	public static int [] numsEvenOddArrayShuffle(int [] nums) {
		if (nums.length % 2 != 0)
			return new int [] {};
		int length = nums.length;
		// since we neede the sorted order, queue will be more suitable
		Queue<Integer> oddStack = new LinkedList<>();
		Queue<Integer> evenStack = new LinkedList<>();
		// traverse through the input array
		for (int number: nums) {
			if (number % 2 == 0)
				evenStack.offer(number);
			else
				oddStack.offer(number);
		}
        if (evenStack.size() != oddStack.size())
            return new int [] {};
		int [] returningArray = new int [length];
		for (int i=0; i<length; i++) {
			if (i % 2 == 0)
				returningArray[i] = evenStack.poll();
			else
				returningArray[i] = oddStack.poll();
		}
		return returningArray;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int [] input = new int [length];
		for (int i=0; i<length; i++)
			input[i] = sc.nextInt();
		int [] result = numsEvenOddArrayShuffle(input);
        for (int number: result)
            System.out.println(number);
	}
}
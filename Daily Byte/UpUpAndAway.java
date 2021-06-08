/*
Given an integer array, nums, return whether or not you can make the array strictly non-decreasing by modifying at most one element.
Note: A non-decreasing array is an array in which nums[i] <= nums[i + 1] for every i.

Ex: Given the following nums…

nums = [3, 1, 2], return true (you could modify three to one).
Ex: Given the following nums…

nums = [4, 2, 1, 3], return false.
*/


import java.util.*;

class UpUpAndAwayImplementation {
	public boolean canBeNonDecreasing(int [] nums, int n) {
		if (n == 1)
			return true;
		int irregularity = 0;
		for (int i=1; i<n && irregularity <= 1; i++) {
			if (nums[i] > nums[i - 1]) {
				continue;
			}
			else if (nums[i] < nums[i - 1]) {
				irregularity += 1;
				if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
					nums[i - 1] = nums[i];
				}
				else {
					nums[i] = nums[i - 1];
				}
			}
		}
		return irregularity <= 1;
	}

	public boolean canBeNonDecreasing2(int [] nums, int n) {
		if (n == 1)
			return true;
		boolean isPossible = false;
		for (int i=1; i<n; i++) {
			if (nums[i] >= nums[i - 1])
				continue;
			if (isPossible)
				return false;
			isPossible = true;
			int lowerBound = (i - 2 >= 0) ? nums[i - 2] : Integer.MIN_VALUE;
			int higherBound = (i + 1 < n) ? nums[i + 1] : Integer.MAX_VALUE;
			if (lowerBound > nums[i] && higherBound < nums[i - 1])
				return false;
		}
		return true;
	}
}


public class UpUpAndAway {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		UpUpAndAwayImplementation upUpAndAwayImplementation = new UpUpAndAwayImplementation();
		//System.out.println(upUpAndAwayImplementation.canBeNonDecreasing(nums, n));
		System.out.println(upUpAndAwayImplementation.canBeNonDecreasing2(nums, n));
	}
}
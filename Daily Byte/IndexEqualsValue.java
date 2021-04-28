/*
Given a sorted integer array, nums, return the index within nums that the index is equal to the value at that index. If no such index exists, return -1.

Ex: Given the following nums…

nums = [0, 4, 8], return 0 (zero occurs at the 0th index).
Ex: Given the following nums…

nums = [1, 3, 7, 12], return -1.
*/

import java.util.*;

public class IndexEqualsValue {

	public static int indexWithSameIndexValue(int [] nums, int n) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == mid)
				return mid;
			else if (nums[mid] > mid)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(indexWithSameIndexValue(nums, n));
	}
}

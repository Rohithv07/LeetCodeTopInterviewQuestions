/*
Given an integer array, nums, return the sum of all subarrays within nums that have an odd length.

Ex: Given the following nums…

nums = [1, 2, 3], return 12 ([1], [2], [3], [1, 2, 3] sum to 12).
Ex: Given the following nums…

nums = [3, 1, 5, 2, 4], return 58.
*/

// ref : https://www.geeksforgeeks.org/sum-of-all-odd-length-subarrays/#:~:text=Therefore%2C%20to%20find%20the%20sum,%5Bi%5D%20to%20the%20sum.

/* HINT : 
For any element at index idx there are (idx + 1) choices on the left side of it and (N – idx) choices on the right side of it.

Therefore, for any element arr[i], the count of arr[i] is (i + 1) * (N – i) in all the subarrays.

So, for an element arr[i], there are ((i + 1) * (N – i) + 1) / 2 sub-arrays with odd length.

Finally, arr[i] will have a total of ((i + 1) * (n – i) + 1) / 2 frequency in the sum.


Therefore, to find the sum of all elements of all the subarrays of odd length, the idea is to iterate over the array and for every ith array element, add [((i + 1) * (n – i) + 1) / 2]*arr[i] to the sum.
*/


import java.util.*;

public class SubArraySum {

	public static int subArraySumWithOddLength(int [] nums, int n) {
		if (n == 1)
			return nums[0];
		int sum = 0;
		for (int i=0; i<n; i++) {
			sum += (((i + 1) * (n - i) + 1) / 2) * nums[i];
		}
		return sum;
	}

	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(subArraySumWithOddLength(nums, n));
	}
}


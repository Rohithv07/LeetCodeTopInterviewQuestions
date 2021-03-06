/*
Given an array of integers, nums, sorted in ascending order, return the element that occurs more than one fourth of the time.
Note: If no element appears more than a fourth of the time, return -1.

Ex: Given the following nums…

nums = [1, 2, 2, 3, 4], return 2.
Ex: Given the following nums…

nums = [1, 2, 3, 4], return -1.
*/

// one typical method is to use hashmap to count the frequency


import java.util.*;

public class OneFourth {

	public static int oneFourth(int [] nums, int n) {
		if (n == 1)
			return nums[0];
		int count = 1;
		int limit = n / 4;
		for (int i=1; i<n; i++) {
			int current = nums[i];
			if (nums[i - 1] == nums[i]) {
				count += 1;
			}
			else {
				count = 1;
			}
			if (count > limit) {
				return nums[i];
			}
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
		System.out.println(oneFourth(nums, n));

	}
}
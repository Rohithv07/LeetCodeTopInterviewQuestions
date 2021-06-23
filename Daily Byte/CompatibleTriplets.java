/*
Given an array of integers, nums, and three additional integers, a, b, and c, return the total number of compatible triplets.
Note: Three integers are said to be a compatible triplet if they are three individual numbers in nums and |nums[i] - nums[j]| <= a, |nums[j] - nums[k]| <= b, and |nums[i] - nums[k]| <= c.

Ex: Given the following nums…

nums = [1, 2, 3], a = 3, b = 2, c = 5, return 1.
*/


import java.util.*;

public class CompatibleTriplets {

	public static int compatibleCount(int [] nums, int a, int b, int c) {
		if (nums == null || nums.length == 0)
			return 0;
		int n = nums.length;
		int count = 0;
		Arrays.sort(nums);
		for (int i=0; i+2 < n; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int num1 = nums[i];
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int num2 = nums[j];
				int num3 = nums[k];
				if (Math.abs(num1 - num2) <= a && Math.abs(num1 - num3) <= c && Math.abs(num2 - num3) <= b) {
					count += 1;
					j += 1;
				}
				else {
					k -= 1;
				}
			}
		}
		return count;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(compatibleCount(nums, a, b, c));
	}
}
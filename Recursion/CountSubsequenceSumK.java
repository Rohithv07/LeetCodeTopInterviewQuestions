// https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7

// Give the number of subsequence which gives a sum K

import java.util.*;

public class CountSubsequenceSumK {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int [] count = new int [1];
		getSubsequenceCount(nums, 0, 0, count, k);
		System.out.println(count[0]);
	}

	private static void getSubsequenceCount(int [] nums, int index, int sum, int [] count, int k) {
		if (index >= nums.length) {
			if (sum == k) {
				count[0] += 1;
			}
			return;
		}
		// picl
		sum += nums[index];
		getSubsequenceCount(nums, index + 1, sum, count, k);

		// not pick
		sum -= nums[index];
		getSubsequenceCount(nums, index + 1, sum, count, k);
	}
}
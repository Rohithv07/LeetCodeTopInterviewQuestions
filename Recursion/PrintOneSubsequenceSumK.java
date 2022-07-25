// https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7

// Print just one subsequence that gives a sum K

import java.util.*;

public class PrintOneSubsequenceSumK {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		List<Integer> result = new ArrayList<>();
		findOneSubsequence(nums, 0, 0, k, result);
	}

	private static boolean findOneSubsequence(int [] nums, int index, int sum, int k, List<Integer> result) {
		if (index >= nums.length) {
			if (sum == k) {
				for (Integer candidate : result) {
					System.out.print(candidate + " ");
				}
				return true;
			}
			return false;
		}
		result.add(nums[index]);
		sum += nums[index];
		if (findOneSubsequence(nums, index + 1, sum, k, result)) {
			return true;
		}
		result.remove(result.size() - 1);
		sum -= nums[index];
		if (findOneSubsequence(nums, index + 1, sum, k, result)) {
			return true;
		}
		return false;
	}
}
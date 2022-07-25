// https://www.youtube.com/watch?v=eQCS_v3bw0Q&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=7

// for a given sum k, print all the subsequence with the given sum k

import java.util.*;

class PrintSubsequenceSumK {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		findAllSubsequence(nums, 0, result, current, 0, k);
		System.out.println(result);
	}

	private static void findAllSubsequence(int [] nums, int index, List<List<Integer>> result, List<Integer> current, int sum, int k) {
		if (index >= nums.length) {
			if (sum == k) {
				result.add(new ArrayList<>(current));
			}
			return;
		}
		// pick the element
		current.add(nums[index]);
		sum += nums[index];
		findAllSubsequence(nums, index + 1, result, current, sum, k);
		// do not pick the element.
		current.remove(current.size() - 1);
		sum -= nums[index];
		findAllSubsequence(nums, index + 1, result, current, sum, k);
	}
}
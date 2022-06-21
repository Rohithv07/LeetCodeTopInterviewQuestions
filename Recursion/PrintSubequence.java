// Recursive program to print all the subsequence

import java.util.*;

public class PrintSubequence {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(printAllSubsequence(nums, n));
	}

	private static List<List<Integer>> printAllSubsequence(int [] nums, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		findSubsequence(result, current, nums, 0, n);
		return result;
	}

	private static void findSubsequence(List<List<Integer>> result, List<Integer> current, int [] nums, int index, int length) {
		if (index >= length) {
			result.add(new ArrayList<>(current));
			return;
		}
		// we have 2 options, consider the current element and move forward
		// do not consider current element and move forward
		current.add(nums[index]); // consider
		findSubsequence(result, current, nums, index + 1, length);
		current.remove(current.size() - 1); // do not consider
		findSubsequence(result, current, nums, index + 1, length);
	}
}
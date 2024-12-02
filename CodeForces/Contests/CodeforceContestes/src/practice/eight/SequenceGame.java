package practice.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 02-Dec-2024
 */
public class SequenceGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			List<Integer> result = findLengthAndArray(nums, n);
			System.out.println(result.get(0));
			for (int i = 1; i < result.size(); i++) {
				System.out.print(result.get(i) + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static List<Integer> findLengthAndArray(int[] nums, int n) {
		List<Integer> result = new ArrayList<>();
		if (n == 1) {
			result.add(1);
			result.add(nums[0]);
			return result;
		}
		result.add(n * 2);
		result.add(nums[0]);
		for (int i = 1; i < n; i++) {
			if (nums[i - 1] <= nums[i]) {
				result.add(nums[i]);
			} else {
				result.add(1);
				result.add(nums[i]);
			}
		}
		int size = result.size();
		result.set(0, size - 1);
		return result;
	}

}

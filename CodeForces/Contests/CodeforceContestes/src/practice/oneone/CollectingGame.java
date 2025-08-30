package practice.oneone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 19-Aug-2025
 */
public class CollectingGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			Integer[][] nums = new Integer[n][2];
			for (int index = 0; index < n; index++) {
				nums[index][0] = sc.nextInt();
				nums[index][1] = index;
			}
			int[] removal = findRemovalCount(nums);
			for (int r : removal) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findRemovalCount(Integer[][] nums) {
		if (nums.length == 1) {
			return new int[] { 0 };
		}
		Arrays.sort(nums, (a1, a2) -> Integer.compare(a1[0], a2[0]));
		int length = nums.length;
		int[] result = new int[length];
		long[] prefix = new long[length];
		prefix[0] = nums[0][0];
		for (int index = 1; index < length; index++) {
			prefix[index] = prefix[index - 1] + nums[index][0];
		}
		for (int index = 0; index < length; index++) {
			int currentCount = index;
			long currentScore = prefix[index];
			int nextPossible = index + 1;
			while (nextPossible < length && currentScore >= nums[nextPossible][0]) {
				currentScore += nums[nextPossible][0];
				currentCount++;
				nextPossible++;
			}
			result[(int) nums[index][1]] = currentCount;
		}
		return result;
	}

}

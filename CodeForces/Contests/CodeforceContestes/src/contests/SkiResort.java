package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Jun-2025
 */
public class SkiResort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextInt();
			long q = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			System.out.println(findNumber(nums, k, q, n));
		}
		sc.close();
	}

	private static long findNumber(int[] nums, long k, long q, int n) {
		int left = 0;
		int right = 0;
		long currentCount = 0;
		while (right < n) {
			int currentNum = nums[right];
			if (currentNum > q) {
				left = right + 1;
			} else {
				long currentWindow = right - left + 1;
				if (currentWindow >= k) {
					currentCount += currentWindow - k + 1;
				}
			}
			right++;
		}
		return currentCount;
	}

}

/**
 * 
 */
package problemsolving1000;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class MinimumExtraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			Long[] nums = new Long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(findTheMinimumExtraction(nums, n));
		}
	}

	private static Long findTheMinimumExtraction(Long[] nums, int n) {
		if (n == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		long maxAnswer = nums[0];
		for (int i = 0; i < n - 1; i++) {
			long currentMin = nums[i + 1] - nums[i];
			if (maxAnswer < currentMin) {
				maxAnswer = currentMin;
			}
		}
		return maxAnswer;
	}
}

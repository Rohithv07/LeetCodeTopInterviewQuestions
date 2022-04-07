/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class Twins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			Arrays.sort(nums);
			System.out.println(findMinNumberOfCoins(nums, n));
	}

	private static int findMinNumberOfCoins(int[] nums, int n) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}
		int currentSum = 0;
		int moves = 0;
		for (int i = n - 1; i >= 0; i--) {
			currentSum += nums[i];
			totalSum -= nums[i];
			moves++;
			if (currentSum > totalSum) {
				return moves;
			}
		}
		return 0;
	}
}

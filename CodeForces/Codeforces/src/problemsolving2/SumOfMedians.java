/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class SumOfMedians {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n * k + 1];
			for (int i = 1; i <= n * k; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMaxMedianSum(nums, n, k));
		}
	}

	private static long findMaxMedianSum(int[] nums, int n, int k) {
		long sum = 0;
		long limit = (n) / 2 + 1;
		int z = n * k + 1;
		for (int i = 0; i < k; i++) {
			z -= limit;
			sum += nums[z];
		}
		return sum;
	}
}

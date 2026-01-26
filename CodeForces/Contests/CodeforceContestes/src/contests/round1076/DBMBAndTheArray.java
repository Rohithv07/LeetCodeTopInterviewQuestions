/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: DBMBAndTheArray.java
 */

package contests.round1076;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class DBMBAndTheArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int x = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			String possible = findIfPossible(nums, x, n, sum);
			System.out.println(possible);
		}
		sc.close();
	}

	private static String findIfPossible(int[] nums, int x, int n, int sum) {
		int totalSum = Arrays.stream(nums).sum();
		if (sum == totalSum) {
			return "YES";
		}
		if (sum < totalSum) {
			return "NO";
		}
		int remaining = totalSum - sum;
		return remaining % x == 0 ? "YES" : "NO";
	}

}

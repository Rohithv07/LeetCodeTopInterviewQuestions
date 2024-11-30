package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 30-Nov-2024
 */
public class JaggedSwaps {

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
			System.out.println(isPossible(nums, n));
		}
		sc.close();
	}

	private static String isPossible(int[] nums, int n) {
		return nums[0] == 1 ? "YES" : "NO";
	}

}

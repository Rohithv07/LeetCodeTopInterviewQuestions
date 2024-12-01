package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Dec-2024
 */
public class HowMuchDoesDaytonaCost {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(isPresent(nums, n, k));
		}
		sc.close();
	}

	private static String isPresent(int[] nums, int n, int k) {
		int[] count = new int[101];
		for (int num : nums) {
			count[num]++;
		}
		return count[k] == 0 ? "NO" : "YES";
	}

}

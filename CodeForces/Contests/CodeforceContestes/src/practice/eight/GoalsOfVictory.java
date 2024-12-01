package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Dec-2024
 */
public class GoalsOfVictory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n - 1];
			for (int i = 0; i < n - 1; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(getEfficiency(nums, n));
		}
		sc.close();
	}

	private static int getEfficiency(int[] nums, int n) {
		int total = 0;
		for (int num : nums) {
			total += num;
		}
		return total * -1;
	}

}

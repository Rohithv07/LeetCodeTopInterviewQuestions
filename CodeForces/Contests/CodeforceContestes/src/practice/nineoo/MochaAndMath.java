package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 05-Jan-2025
 */
public class MochaAndMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(minMaxValue(nums, n));
		}
		sc.close();
	}

	private static int minMaxValue(int[] nums, int n) {
		// 3 7 7 11 13
		int result = nums[0];
		for (int i = 1; i < n; i++) {
			result &= nums[i];
		}
		return result;
	}

}

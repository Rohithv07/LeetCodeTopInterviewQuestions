package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 16-Oct-2025
 */
public class LiHuaPatterns {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[][] nums = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					nums[i][j] = sc.nextInt();
				}
			}
			System.out.println(isPossibleToRotate(nums, k));
		}
		sc.close();
	}

	private static String isPossibleToRotate(int[][] nums, int k) {
		int diff = 0;
		int row = nums.length;
		int col = nums[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int first = nums[i][j];
				int last = nums[row - i - 1][col - j - 1];
				if (first != last) {
					diff++;
				}
			}
		}
		diff /= 2;
		if (diff > k) {
			return "NO";
		}
		int remaining = k - diff;
		if (remaining % 2 == 0) {
			return "YES";
		}
		return row % 2 == 0 ? "NO" : "YES";
	}

}

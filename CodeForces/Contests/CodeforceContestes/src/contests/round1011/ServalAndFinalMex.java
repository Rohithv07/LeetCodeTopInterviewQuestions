package contests.round1011;

import java.util.Scanner;

/**
 * @author rohithvazhathody 22-Mar-2025
 */
public class ServalAndFinalMex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			int[][] result = findSequence(nums, n);
			System.out.println(result.length);
			for (int[] r : result) {
				System.out.println(r[0] + " " + r[1]);
			}
		}
		sc.close();
	}

	private static int[][] findSequence(int[] nums, int n) {
		int countZero = 0;
		int startIndex = -1;
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (num == 0) {
				countZero++;
				if (startIndex == -1) {
					startIndex = i;
				}
			}
		}
		if (countZero == 0) {
			return new int[][] { { 1, n } };
		}
		int[][] result;
		if (nums[0] != 0) {
			result = new int[2][2];
			result[0][0] = 2;
			result[0][1] = n;
			result[1][0] = 1;
			result[1][1] = 2;
			return result;
		}
		if (nums[n - 1] != 0) {
			result = new int[2][2];
			result[0][0] = 1;
			result[0][1] = n - 1;
			result[1][0] = 1;
			result[1][1] = 2;
			return result;
		}
		result = new int[3][2];
		result[0][0] = 1;
		result[0][1] = n / 2;
		result[1][1] = n - (n / 2) + 1;
		result[1][0] = 2;
		result[2][0] = 1;
		result[2][1] = 2;
		return result;
	}

}

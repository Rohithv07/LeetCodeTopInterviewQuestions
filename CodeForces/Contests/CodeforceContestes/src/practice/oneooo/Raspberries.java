package practice.oneooo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 19-Jan-2025
 */
public class Raspberries {

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
			System.out.println(findMinOperation(nums, n, k));
		}
		sc.close();
	}

	private static int findMinOperation(int[] nums, int n, int k) {
		if (k == 1) {
			return 0;
		}
		int minOp = Integer.MAX_VALUE;
		int evenCount = 0;
		for (int num : nums) {
			if (num % 2 == 0) {
				evenCount++;
			}
			int val = (num % k == 0) ? 0 : k - (num % k);
			minOp = Math.min(val, minOp);
		}
		if (k == 4) {
			minOp = Math.min(minOp, Math.max(0, 2 - evenCount));
		}
		return minOp;
	}

}

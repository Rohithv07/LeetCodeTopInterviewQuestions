package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Dec-2024
 */
public class Desorting {

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
			boolean isNotSorted = false;
			for (int i = 1; i < n; i++) {
				if (nums[i - 1] > nums[i]) {
					isNotSorted = true;
					break;
				}
			}
			if (isNotSorted) {
				System.out.println(0);
			}
			else {
				int minDiff = Integer.MAX_VALUE;
				for (int i = 1; i < n; i++) {
					int diff = nums[i] - nums[i - 1];
					minDiff = Math.min(minDiff, diff);
				}
				System.out.println(minDiff / 2 + 1);
			}
		}
		sc.close();
	}

}

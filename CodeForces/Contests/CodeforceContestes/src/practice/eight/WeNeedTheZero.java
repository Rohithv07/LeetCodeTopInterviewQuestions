package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 07-Dec-2024
 */
public class WeNeedTheZero {

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
			int xor = 0;
			for (int num : nums) {
				xor ^= num;
			}
			// if odd, just print the full xor
			if (n % 2 == 1) {
				System.out.println(xor);
			} else {
				// if even, then already full array xor = 0. print any number we like, else -1
				if (xor == 0) {
					System.out.println(xor);
				} else {
					System.out.println(-1);
				}
			}
		}
		sc.close();
	}

}

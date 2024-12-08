package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Dec-2024
 */
public class EverybodyLikesGoodArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			int count = 0;
			for (int i = 1; i < n; i++) {
				long mod1 = nums[i - 1] % 2;
				long mod2 = nums[i] % 2;
				if (mod1 == mod2) {
					count++;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}

}

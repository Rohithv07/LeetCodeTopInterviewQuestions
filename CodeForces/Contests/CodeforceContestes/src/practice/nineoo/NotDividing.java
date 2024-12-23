package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 23-Dec-2024
 */
public class NotDividing {

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
				if (nums[i] == 1) {
					nums[i] += 1;
				}
			}
			if (n == 1) {
				System.out.println(nums[0]);
			} else {
				for (int i = 1; i < n; i++) {
					long current = nums[i];
					long previous = nums[i - 1];
//					if (previous == 1) {
//						nums[i - 1]++;
//						previous = nums[i - 1];
//					}
					if (current % previous == 0) {
						nums[i]++;
					}
				}
				for (long num : nums) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}

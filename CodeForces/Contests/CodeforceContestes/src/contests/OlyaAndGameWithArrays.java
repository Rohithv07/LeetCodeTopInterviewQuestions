package contests;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Jun-2025
 */
public class OlyaAndGameWithArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long minimum = Long.MAX_VALUE;
			long secondMinimum = Long.MAX_VALUE;
			long totaSumSecondMinimum = 0;
			for (int index = 0; index < n; index++) {
				int size = sc.nextInt();
				long[] nums = new long[size];
				for (int i = 0; i < size; i++) {
					nums[i] = sc.nextLong();
				}
				Arrays.sort(nums);
				minimum = Math.min(minimum, nums[0]);
				secondMinimum = Math.min(secondMinimum, nums[1]);
				totaSumSecondMinimum += nums[1];
			}
			System.out.println(totaSumSecondMinimum - secondMinimum + minimum);
		}
		sc.close();
	}

}

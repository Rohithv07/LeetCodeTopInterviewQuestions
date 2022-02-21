package problemsolving;

import java.util.Scanner;

public class PolyCarpAndSumOfSubsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long[] nums = new long[7];
			long[] result = new long[3];
			for (int i = 0; i < 7; i++) {
				nums[i] = sc.nextLong();
			}
			result[0] = nums[0];
			result[1] = nums[1];
			result[2] = nums[6] - result[0] - result[1];
			for (long number : result) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}

package problemsolving;

import java.util.Scanner;

public class PlusOneOnTheSubset {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			long max = 0;
			long min = Long.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
				if (max < nums[i]) {
					max = nums[i];
				}
				if (min > nums[i]) {
					min = nums[i];
				}
			}
			System.out.println(max - min);
		}
	}
}

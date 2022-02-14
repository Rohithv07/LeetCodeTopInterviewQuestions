package problemsolving;

import java.util.*;

public class Cherry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			long product = 1;
			for (int i = 0; i < n; i++) {
				if (i == 0 || i == n - 1) {
					nums[i] = sc.nextLong();
				} else {
					nums[i] = sc.nextLong();
					product = Math.max(product, nums[i] * nums[i - 1]);
				}
			}
			product = Math.max(product, nums[n - 1] * nums[n - 2]);
			System.out.println(product);
		}
	}
}

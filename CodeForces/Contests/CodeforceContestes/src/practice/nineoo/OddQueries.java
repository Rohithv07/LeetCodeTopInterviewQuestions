package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 23-Dec-2024
 */
public class OddQueries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			long[] nums = new long[n + 1];
			long queries[][] = new long[q][3];
			for (int i = 1; i <= n; i++) {
				nums[i] = sc.nextLong();
			}
			for (int i = 0; i < q; i++) {
				queries[i][0] = sc.nextLong();
				queries[i][1] = sc.nextLong();
				queries[i][2] = sc.nextLong();
			}
			isOdd(n, q, nums, queries);
		}
		sc.close();
	}

	private static void isOdd(int n, int q, long[] nums, long[][] queries) {
		long[] prefix = new long[n + 1];
		prefix[1] = nums[1];
		for (int i = 2; i <= n; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
		}
		long totalSum = prefix[n];
		for (long[] query : queries) {
			int l = (int) query[0];
			int r = (int) query[1];
			long k = query[2];
			long current = totalSum - (prefix[r] - prefix[l - 1]) + (k * (r - l + 1));
			if (current % 2 == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}

/**
 * 2 2 1 3 2
 * 
 * 0 0 1 2 2
 * 
 * 2 4 5 8 10
 * 
 * 2 3 3 3 2
 * 
 */
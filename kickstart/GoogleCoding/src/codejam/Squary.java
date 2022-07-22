/**
 * 
 */
package codejam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class Squary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			List<Long> result = findResult(nums, n, k);
			System.out.print("Case #" + t + ": ");
			if (result == null || result.size() == 0) {
				System.out.print("IMPOSSIBLE");
			} else {
				for (long num : result)
					System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static List<Long> findResult(long[] nums, int n, int k) {
		List<Long> result = new ArrayList<>();
		if (n == 1 && k == 1 && nums[0] == 0) {
			result.add(1l);
			return result;
		}
		Arrays.sort(nums);
		if (nums[0] == 0 && nums[n - 1] == 0) {
			result.add(1l);
			return result;
		}
		long current1 = 0;
		long current2 = 0;
		for (long num : nums) {
			current1 += num;
			current2 += (num * num);
		}
		if (current1 == 0) {
			return result;
		}
		if (current1 == current2) {
			result.add(0l);
			return result;
		}
		if (Math.ceil(((double) current2 - ((double) current1 * (double) current1)) / ((double) current1 * 2)) != Math
				.floor(((double) current2 - ((double) current1 * (double) current1)) / ((double) current1 * 2))) {
			return result;
		}
		long x = (current2 - (current1 * current1)) / (current1 * 2);
		result.add(x);
		return result;
	}
}

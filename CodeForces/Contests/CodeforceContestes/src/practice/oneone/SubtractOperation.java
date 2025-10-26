package practice.oneone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 26-Oct-2025
 */
public class SubtractOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			long k = sc.nextLong();
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			System.out.println(isPossibleToForm(nums, k));
		}
		sc.close();
	}

	private static String isPossibleToForm(long[] nums, long k) {
		Map<Long, Long> sumMap = new HashMap<>();
		for (Long num : nums) {
			sumMap.put(num, num);
		}
		for (long num : nums) {
			if (sumMap.containsKey(num - k)) {
				return "YES";
			}
			sumMap.put(num, num);
		}
		return "NO";
	}

}

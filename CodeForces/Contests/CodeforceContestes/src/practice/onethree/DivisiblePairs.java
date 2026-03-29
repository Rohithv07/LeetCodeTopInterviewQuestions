/**
 * @author rohithvazhathody
 * @date 25 Feb 2026
 * Project: CodeforceContestes
 * File: DivisiblePairs.java
 */

package practice.onethree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class DivisiblePairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long y = sc.nextLong();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long countPairs = findCountPairs(nums, x, y);
			System.out.println(countPairs);
		}
		sc.close();
	}

	private static long findCountPairs(long[] nums, long x, long y) {
		int length = nums.length;
		if (length == 1) {
			return 0;
		}
		long pairs = 0;
		Map<String, Long> map = new HashMap<>();
		for (long num : nums) {
			long rX = num % x;
			long rY = num % y;
			long needX = (x - rX) % x;
			long needY = rY;
			String targetTag = needX + "," + needY;
			String currentTag = rX + "," + rY;
			pairs += map.getOrDefault(targetTag, 0l);
			map.put(currentTag, map.getOrDefault(currentTag, 0l) + 1);
		}
		return pairs;
	}

}

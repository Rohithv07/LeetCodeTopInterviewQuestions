package contests.round1042;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 10-Aug-2025
 */
public class MakeItEqual {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long k = sc.nextInt();
			long[] nums1 = new long[n];
			long[] nums2 = new long[n];
			for (int index = 0; index < n; index++) {
				nums1[index] = sc.nextLong();
			}
			for (int index = 0; index < n; index++) {
				nums2[index] = sc.nextLong();
			}
			System.out.println(findIfPossibleToConvert(nums1, nums2, k, n));
		}
		sc.close();
	}

	private static String findIfPossibleToConvert(long[] nums1, long[] nums2, long k, int n) {
		if (Arrays.equals(nums1, nums2)) {
			return "YES";
		}
		Map<Long, Long> freqMapNums = new HashMap<>();
		for (long num : nums1) {
			long val = findRemainder(num, k);
			freqMapNums.put(val, freqMapNums.getOrDefault(val, 0l) + 1);
		}
		for (long num : nums2) {
			long val = findRemainder(num, k);
			freqMapNums.put(val, freqMapNums.getOrDefault(val, 0l) - 1);
		}
		for (Long key : freqMapNums.keySet()) {
			if (freqMapNums.get(key) != 0) {
				return "NO";
			}
		}
		return "YES";
	}

	private static long findRemainder(long num, long k) {
		long remainder = ((num % k) + k) % k;
		if (remainder == 0) {
			return 0l;
		}
		return Math.min(k - remainder, remainder);
	}

}

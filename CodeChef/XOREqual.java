package SeptemberLongChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class XOREqual {

	public static long[] findMinAndEqual(long[] nums, long x, int n) {
		if (n == 1) {
			return new long[] { 1, 0 };
		}
		long equal = 0;
		long count = 0;
		Map<Long, Long> map = new HashMap<>();
		Map<Long, Long> converted = new HashMap<>();
		for (long number : nums) {
			map.put(number, map.getOrDefault(number, 0l) + 1);
			converted.put(number, 1l);
		}
		if (map.size() == 1) {
			return new long[] { n, 0 };
		}
		for (Long key : map.keySet()) {
			if (map.get(key) >= equal) {
				equal = map.get(key);
			}
		}
		if (x == 0) {
			return new long[] { equal, count };
		}
		for (Long key : map.keySet()) {
			if (converted.get(key ^ x) != null && converted.get(key ^ x) == 1) {
				if (map.get(key) + map.get(key ^ x) > equal) {
					equal = map.get(key) + map.get(key ^ x);
					count = Math.min(map.get(key), map.get(key ^ x));
				} else if (map.get(key) + map.get(key ^ x) == equal) {
					if (Math.min(map.get(key), map.get(key ^ x)) < count) {
						count = Math.min(equal, map.get(key ^ x));
					}
				}
			}
		}

		return new long[] { equal, count };
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long x = sc.nextLong();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			long[] result = findMinAndEqual(nums, x, n);
			System.out.println(result[0] + " " + result[1]);
		}
		sc.close();
	}
}

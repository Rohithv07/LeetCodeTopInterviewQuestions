package longChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GoodPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			Map<Long, Long> map = new HashMap<>();
			for (long num : nums) {
				map.put(num, map.getOrDefault(num, 0l) + 1);
			}
			long count = 0;
			for (long key : map.keySet()) {
				long value = map.get(key);
				long sum = (value * (value - 1)) / 2;
				count = count + sum;
			}
			System.out.println(count);
		}
	}
}

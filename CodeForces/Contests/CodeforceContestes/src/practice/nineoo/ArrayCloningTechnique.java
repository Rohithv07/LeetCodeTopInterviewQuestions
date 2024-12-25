package practice.nineoo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Dec-2024
 */
public class ArrayCloningTechnique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(findMinOp(nums, n));
		}
		sc.close();
	}

	private static int findMinOp(long[] nums, int n) {
		if (n == 1) {
			return 0;
		}
		Map<Long, Integer> map = new HashMap<>();
		for (long num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// n = 1-> 0, 2 -> 2, 3 -> 4, 4 -> 5, 5 -> 7, 6 -> 8
		int count = 0;
		for (long key : map.keySet()) {
			count = Math.max(map.get(key), count);
		}
		int answer = 0;
		while (count < n) {
			int dist = Math.min(count, n - count);
			answer += 1 + dist;
			count += dist;
		}
		return answer;
	}

}

/**
 * 1 2 3, 1 2 3 => 1 1 1 3, 2 2 3 => 2 1 1 3, 1 1 3 => 3 1 1 1 => 4
 *
 * 2 5 7 6 3, 2 5 7 6 3 => 1
 * 
 * 2 2 7 6 3, 5 5 7 6 3 => 2
 * 
 * 2 2 7 6 3, 2 2 7 6 3 => 3
 * 
 * 2 2 2 2 3, 7 6 7 6 3 => 4, 5
 * 
 * 2 2 2 2 3, 2 2 2 2 3 => 6
 * 
 * 2 2 2 2 2, 3 2 2 2 3 => 7
 * 
 * 
 * 0 1 3 3 7 0, 0 1 3 3 7 0 => 1 0 0 0 3 7 0, 1 1 3 3 7 3 => 3 0 0 0 3 7 0, 0 0
 * 0 3 7 0 => 4 0 0 0 0 0 0, 3 7 0 3 7 0 => 6
 * 
 * 
 * 4 3 2 1, 4 3 2 1 => 1 4 4 2 1, 3 3 2 1 => 2 4 4 2 1, 4 4 2 1 => 3 4 4 4 4, 2
 * 1 2 1 => 5
 * 
 * 
 * 1 2 3 4 5 6, 1 2 3 4 5 6 => 1 1 1 3 4 5 6, 2 2 3 4 5 6 => 2 1 1 3 4 5 6, 1 1
 * 3 4 5 6 => 3 1 1 1 1 5 6, 3 4 3 4 5 6 => 5 1 1 1 1 5 6, 1 1 1 1 5 6 => 6
 * 
 * 
 */

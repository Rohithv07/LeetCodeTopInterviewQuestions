package contests.hello2025;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author rohithvazhathody 04-Jan-2025
 */
public class GorillaAndExam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			System.out.println(findMinOp(nums, n, k));
		}
		sc.close();
	}

	private static int findMinOp(long[] nums, int n, int k) {
		if (n == 1) {
			return 1;
		}
		if (n == k) {
			return 1;
		}
//		Arrays.sort(nums);
		Map<Long, Integer> map = new HashMap<>();
		for (long num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		if (k == 0) {
			return map.size();
		}
		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (long key : map.keySet()) {
			pq.offer(map.get(key));
		}
		while (!pq.isEmpty() && k > 0) {
			if (k >= pq.peek()) {
				k -= pq.poll();
			} else {
				break;
			}
		}
		count = Math.max(1, pq.size());
		return count;
	}

}

/**
 * 11 4 3 2 1 4 4 3 4 2 1 3 3 3 3 3 3 3 3 3 3 4 4 4
 * 
 * 3 -> 4 2 -> 2 1 -> 2 4 -> 3
 * 
 * 
 */

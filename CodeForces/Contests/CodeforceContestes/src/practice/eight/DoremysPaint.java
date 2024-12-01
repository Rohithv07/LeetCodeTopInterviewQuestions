package practice.eight;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Dec-2024
 */
public class DoremysPaint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(isPossible(nums, n));
		}
		sc.close();
	}

	private static String isPossible(int[] nums, int n) {
		if (n == 2) {
			return "YES";
		}
		if (n == 3 && ((nums[0] == nums[1]) || (nums[1] == nums[2]) || (nums[2] == nums[0]))) {
			return "YES";
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		if (map.size() > 2) {
			return "NO";
		}
		int count1 = -1;
		int count2 = -1;
		for (Integer key : map.keySet()) {
			if (count1 == -1) {
				count1 = map.get(key);
			} else {
				count2 = map.get(key);
			}
		}
		if (count1 == n || count2 == n) {
			return "YES";
		}
		return Math.abs(count1 - count2) <= 1 ? "YES" : "NO";
	}

}

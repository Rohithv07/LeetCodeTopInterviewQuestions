package contests.round987;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Nov-2024
 */
public class PenhickAndModernMonument {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			if (n == 1) {
				System.out.println(0);
			} else {
				Map<Integer, Integer> map = new HashMap<>();
				for (int num : nums) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				}
				int max = -1;
				for (Integer key : map.keySet()) {
					if (max < map.get(key)) {
						max = map.get(key);
					}
				}
				System.out.println(n - max);
			}
		}
		sc.close();

	}

}

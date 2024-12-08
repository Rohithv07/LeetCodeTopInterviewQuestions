package contestes.round992;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Dec-2024
 */
public class GameOfDivision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int num = nums[i];
				if (!map.containsKey(num % k)) {
					map.put(num % k, new ArrayList<>());
				}
				map.get(num % k).add(i + 1);
			}
			int result = -1;
			for (Integer key : map.keySet()) {
				List<Integer> set = map.get(key);
				if (set.size() == 1) {
					result = set.get(0);
					break;
				}
			}
			if (result != -1) {
				System.out.println("YES");
				System.out.println(result);
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}

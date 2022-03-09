/**
 * 
 */
package problemsolving;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class RemoveSmallest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			}
			for (int i = 0; i < n; i++) {
				int number = nums[i];
				if (map.containsKey(number + 1)) {
					map.put(number, map.get(number) - 1);
				}
			}
			int counter = 0;
			for (Integer key : map.keySet()) {
				if (map.get(key) > 0) {
					counter++;
				}
			}
			if (counter == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}

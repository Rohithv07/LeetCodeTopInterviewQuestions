/**
* @author rohithvazhathody
* @date 9 Jan 2026
* Project: CodeforceContestes
* File: Matryoshkas.java
*/

package practice.onetwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 */
public class Matryoshkas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			int minSet = findMinSet(nums);
			System.out.println(minSet);
		}
		sc.close();
	}

	private static int findMinSet(int[] nums) {
		if (nums.length == 1) {
			return 1;
		}
		Map<Integer, Integer> freqMap = new HashMap<>();
		Set<Integer> store = new HashSet<>();
		for (int num : nums) {
			store.add(num);
		}
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		int result = 0;
		for (Integer element : freqMap.keySet()) {
			int currentCount1 = freqMap.get(element);
			int currentCount2 = 0;
			if (store.contains(element - 1)) {
				currentCount2 = freqMap.get(element - 1);
			}
			result += Math.max(currentCount1 - currentCount2, 0);
		}
		return result;
	}

}

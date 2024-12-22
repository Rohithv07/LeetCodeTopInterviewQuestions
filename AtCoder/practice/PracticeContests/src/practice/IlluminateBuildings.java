/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class IlluminateBuildings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		Map<Integer, List<Integer>> track = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			if (track.containsKey(num)) {
				track.get(num).add(i);
			} else {
				track.put(num, new ArrayList<>());
				track.get(num).add(i);
			}
		}
		int counter = 1;
		for (List<Integer> list : track.values()) {
			int size = list.size();
			Map<Integer, Integer> diffCalc = new HashMap<>();
			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					int dist = list.get(j) - list.get(i);
					int prevCount = diffCalc.getOrDefault(list.get(i) * 10000 + dist, 1);
					int newCount = prevCount + 1;

					// Update DP for the current index and difference
					diffCalc.put(list.get(j) * 10000 + dist, newCount);

					// Update global max count
					counter = Math.max(counter, newCount);

				}
			}
		}
		System.out.println(counter);
		sc.close();
	}

}

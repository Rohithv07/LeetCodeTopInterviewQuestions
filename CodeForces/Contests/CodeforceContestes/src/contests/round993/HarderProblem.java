package contests.round993;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class HarderProblem {

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
			int[] b = findArray(nums, n);
			for (int num : b) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[] findArray(int[] nums, int n) {
		int[] result = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> vacant = new ArrayList<>();
		int running = 1;
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], i);
			else
				vacant.add(i);
		}
		for (Integer key : map.keySet()) {
			result[map.get(key)] = key;
		}
		for (Integer index : vacant) {
			while (map.containsKey(running)) {
				running++;
			}
			result[index] = running;
			map.put(running, index);
		}
		return result;

//		for (int i = 0; i < n; i++) {
//			int currentNum = nums[i];
//			count.put(currentNum, count.getOrDefault(currentNum, 0) + 1);
//			if (i == 0) {
//				result[i] = currentNum;
//			}
//			else {
//				if (count.get(currentNum) >= maxFrequency) {
//					result[i] = currentNum;
//				}
//			}
//		}
	}

}

/**
 * 
 * 1 1 1 2
 * 
 * 1 2 1 2
 * 
 * 
 * 1 1 2 2 1 1 3 3 1 1 1 9 2 8 7 1
 * 
 * 1 1 2 2 3
 * 
 * 1 3 2 2 3
 * 
 */
package contests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author rohithvazhathody 02-Jul-2025
 */
public class ShoeShuffling {

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
			int[] result = findValidSuffling(nums, n);
			if (result == null) {
				System.out.println("-1");
			} else {
				for (int num : result) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

	private static int[] findValidSuffling(int[] nums, int n) {
		Map<Integer, Integer> freqMap = findFreqMap(nums);
		int[] result = new int[n];
		for (int key : freqMap.keySet()) {
			if (freqMap.get(key) == 1) {
				return null;
			}
		}
		int i = 0;

		while (i < n) {
			int start = i;
			while (i < n - 1 && nums[i] == nums[i + 1])
				i++;
			if (start != i) {
				result[start] = i + 1;
				for (int j = start + 1; j <= i; j++)
					result[j] = j;
			} else {
				return null;
			}
			i++;
		}

		return result;
	}

	public static void rotateSubarrayRightByOne(int[] arr, int start, int end, int[] result) {
		result[start] = arr[end];
		for (int i = start; i < end; i++) {
			result[i + 1] = arr[i];
		}
	}

	private static Map<Integer, Integer> findFreqMap(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		return freqMap;
	}

}

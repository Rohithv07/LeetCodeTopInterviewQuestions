/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: BinaryDeque.java
 */

package practice.onetwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class BinaryDeque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int neededSum = sc.nextInt();
			int [] nums = new int [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextInt();
			}
			int minimumRemoval = findMinimumRemoval(nums, neededSum);
			System.out.println(minimumRemoval == -1 ? minimumRemoval : n - minimumRemoval);
		}
		sc.close();
	}

	private static int findMinimumRemoval(int[] nums, int neededSum) {
		Map<Integer, Integer> prefixMap = new HashMap<>();
		prefixMap.put(0, -1);
		int maxLength = -1;
		int currentSum = 0;
		int n = nums.length;
		for (int index = 0; index < n; index++) {
			int num = nums[index];
			currentSum += num;
			if (prefixMap.containsKey(currentSum - neededSum)) {
				maxLength = Math.max(maxLength, index - prefixMap.get(currentSum - neededSum));
			}
			if (!prefixMap.containsKey(currentSum)) {
				prefixMap.put(currentSum, index);
			}
		}
		return maxLength;
	}

}


/*
 * 9
 * 0 0 1 0 0 1 1 0 0 0 0 0
 * 
 * c = 7
 * n = 2
 * 
 * 1234
 * 
 * 
 * 0 1 4
 * 
 * 1 1 0 0 1 0 0 1 1 0 0 0 0 0 1 1
 * 
 * 1 2 2 2 3 3 3 4 5 5 5 5 5 5 6 7
 * 7 6 6 6 5 5 5 4 3 3 3 3 3 3 2 1
 * 
 */

/**
 * @author rohithvazhathody
 * @date 26 Feb 2026
 * Project: CodeforceContestes
 * File: RomanticGlasses.java
 */

package practice.onethree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class RomanticGlasses {

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
			String foundRomantic = findRomantic(nums);
			System.out.println(foundRomantic);
		}
		sc.close();
	}

	private static String findRomantic(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "NO";
		}
		Map<Long, Integer> sumMap = new HashMap<>();
		sumMap.put(0l, -1);
		long prefixSum = 0;
		int index = 0;
		for (int num : nums) {
			prefixSum += (index % 2 == 0 ? num : -1 * num);
			if (sumMap.containsKey(prefixSum)) {
				return "YES";
			}
			sumMap.put(prefixSum, index);
			index++;
		}
		return "NO";
	}

}

/*
 * 1 2 11 4 1 5 1 2
 * 
 * 1 3 14 18 19 24 25 27
 * 
 * 
 * 
 * 
 */

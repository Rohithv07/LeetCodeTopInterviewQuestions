/**
 * @author rohithvazhathody
 * @date 25 Feb 2026
 * Project: CodeforceContestes
 * File: RockAndLever.java
 */

package practice.onetwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class RockAndLever {

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
			long countPair = findPairs(nums);
			System.out.println(countPair);
		}
		sc.close();
	}

	private static long findPairs(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return 0;
		}
		long total = 0;
		Map<Integer, Long> map = new HashMap<>();
		for (int num : nums) {
			int msb = 31 - Integer.numberOfLeadingZeros(num);
			total += map.getOrDefault(msb, 0l);
			map.put(msb, map.getOrDefault(msb, 0l) + 1);
		}
		return total;
	}

}

/*
 * i < j ai & aj >= ai ^ aj
 * 
 * 
 * 1 4 3 7 10
 * 
 * 4 & 7 =
 * 
 * 0100 0111
 * 
 * 0100 >= 0011
 * 
 * 0010 >= 1101
 * 
 * 0110 0101
 * 
 * 0100 >= 0011
 * 
 * 
 * 0010 0100
 * 
 * 0000 0110
 * 
 * 0011 0101
 * 
 * 0001
 * 
 * 0110
 * 
 * 
 */

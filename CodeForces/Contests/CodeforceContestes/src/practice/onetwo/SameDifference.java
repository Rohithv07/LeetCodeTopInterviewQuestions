/**
 * @author rohithvazhathody
 * @date 16 Feb 2026
 * Project: CodeforceContestes
 * File: SameDifference.java
 */

package practice.onetwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class SameDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long pairCount = findPairCount(nums);
			System.out.println(pairCount);
		}
		sc.close();
	}

	private static long findPairCount(long[] nums) {
		int length = nums.length;
		Map<Long, Long> diffCountMap = new HashMap<>();
		//diffCountMap.put(0l, 1l);
		long totalCount = 0;
		for (int index = 0; index < length; index++) {
			long diff = nums[index] - index;
			if (diffCountMap.containsKey(diff)) {
				totalCount += diffCountMap.get(diff);
			}
			diffCountMap.put(diff, diffCountMap.getOrDefault(diff, 0l) + 1);
		}
		return totalCount;
	}

}

/*
 * 
 * ai - i = aj - j 0 1 2 3 4 5 1 6 3 4 5 6
 * 
 * 
 * 
 * 1 - 0 = 1,1
 * 
 * 6 - 1 = 5,1 3 - 2 = 1, 2 4 - 3 = 1
 * 
 * 
 * 
 * 
 */

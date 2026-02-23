package contests.round1081;

/**
 * @author rohithvazhathody
 * @date 21 Feb 2026
 * Project: CodeforceContestes
 * File: AllInOneGun.java
 */


import java.util.Scanner;

/**
 * 
 */
public class AllInOneGun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long h = sc.nextLong();
			long k = sc.nextLong();
			long [] nums = new long [n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long minTime = findMinTimeToKillEnemy(nums, h, k);
			System.out.println(minTime);
		}
		sc.close();
	}

	private static long findMinTimeToKillEnemy(long[] nums, long h, long k) {
		int length = nums.length;
		long [] prefixMin = new long [length];
		long [] suffixMax = new long [length];
		int [] minIndex = new int [length];
		int [] maxIndex = new int [length];
		long totalScore = 0;
		prefixMin[0] = nums[0];
		minIndex[0] = 0;
		suffixMax[length - 1] = nums[length - 1];
		maxIndex[length - 1]= length - 1;
		for (int index = 1; index < length; index++) {
			if (prefixMin[index - 1] > nums[index]) {
				prefixMin[index] = nums[index];
				minIndex[index] = index;
			}
			else {
				prefixMin[index] = prefixMin[index - 1];
				minIndex[index] = minIndex[index - 1];
			}
		}
		for (int index = length - 2; index >= 0; index--) {
			if (nums[index] >= suffixMax[index + 1]) {
				suffixMax[index] = nums[index];
				maxIndex[index] = index;
			}
			else {
				suffixMax[index] = suffixMax[index + 1];
				maxIndex[index] = maxIndex[index + 1];
			}
		}
		long [] prefixSum = new long [length];
		prefixSum[0] = nums[0];
		for (int index = 1; index < length; index++) {
			prefixSum[index] = prefixSum[index - 1] + nums[index];
		}
		long totalSum = prefixSum[length - 1];
		long repeat = (h - 1) / totalSum;
	    long remaining = h - (repeat * totalSum);
	    
	    totalScore = repeat * (length + k);
	    
	    for (int index = 0; index < length; index++) {
	    	long currentDamage = prefixSum[index];
	    	if (index < length - 1) {
	    		long swapGain = suffixMax[index + 1] - prefixMin[index];
                if (swapGain > 0) {
                	currentDamage += swapGain;
                }
	    	}
	        if (currentDamage >= remaining) {
	        	return totalScore + (long)index + 1;
	        }
	    }
	    
	    return totalScore + length;
	}

}
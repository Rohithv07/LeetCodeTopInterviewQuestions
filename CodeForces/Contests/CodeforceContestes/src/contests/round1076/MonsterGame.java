/**
 * @author rohithvazhathody
 * @date 25 Jan 2026
 * Project: CodeforceContestes
 * File: MonsterGame.java
 */

package contests.round1076;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class MonsterGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums1 = new int[n];
			int[] nums2 = new int[n];
			for (int index = 0; index < n; index++) {
				nums1[index] = sc.nextInt();
			}
			for (int index = 0; index < n; index++) {
				nums2[index] = sc.nextInt();
			}
			long maxScore = findMaxScore(nums1, nums2);
			System.out.println(maxScore);
		}
		sc.close();
	}

	private static long findMaxScore(int[] nums1, int[] nums2) {
		int length = nums1.length;
		Arrays.sort(nums1);
		long maxScore = 0;
		long strike = 0;
		for (int index = 0; index < length; index++) {
			strike += nums2[index];
			if (strike > length) {
				break;
			}
			long difficulty = nums1[length - (int)strike];
			maxScore = Math.max(maxScore, difficulty * (index + 1));
		}
		return maxScore;
	}

	private static Score findMaximumLevelComplete(int[] nums1, int[] nums2, long strength) {
		int maxLevel = 0;
		boolean canFinsish = true;
		for (int index = 0; index < nums1.length; index++) {
			if (nums2[index] > strength) {
				canFinsish = false;
				break;
			}
			maxLevel++;
		}
		return new Score(canFinsish, maxLevel);
	}

}

class Score {
	boolean willComplete;
	int maxLevel;

	public Score(boolean willCompete, int maxLevel) {
		this.willComplete = willCompete;
		this.maxLevel = maxLevel;
	}
}

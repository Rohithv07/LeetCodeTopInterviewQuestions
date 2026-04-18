/**
 * @author rohithvazhathody
 * @date 29 Mar 2026
 * Project: CodeforceContestes
 * File: SimplySittingOnChairs.java
 */

package contests.round1089;

import java.util.Scanner;

/**
 * 
 */
public class SimplySittingOnChairs {

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
			int maxSeat = findMaxSeat(nums);
			System.out.println(maxSeat);
		}
		sc.close();
	}

	private static int findMaxSeat(int[] nums) {
		int length = nums.length;
		int [] diff = new int [length + 3];
		int maxSittingSeat = 0;
		int runningChair = 0;
		for (int index = 0; index < length; index++) {
			int currentPos = nums[index];
			int chair = index + 1;
			if (currentPos <= chair) {
				diff[chair + 1]++;
				diff[length + 2]--;
			}
			else {
				diff[chair + 1]++;
				diff[currentPos + 1]--;
			}
		}
		for (int chair = 1; chair <= length + 1; chair++) {
			runningChair += diff[chair];
			maxSittingSeat = Math.max(maxSittingSeat, runningChair);
		}
		return maxSittingSeat;
	}

}

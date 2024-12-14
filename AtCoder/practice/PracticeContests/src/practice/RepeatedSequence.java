/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class RepeatedSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long s = sc.nextLong();
		long[] nums = new long[n];
		long totalSum = 0;
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextLong();
			totalSum += nums[i];
		}
		if (s % totalSum == 0) {
			System.out.println("Yes");
			sc.close();
			return;
		}
		long mod = s % totalSum;
		int left = 0;
		int right = 0;
		long runningSum = 0;
		while (right < 2 * n) {
			runningSum += nums[right % n];
			while (runningSum > mod && left <= right) {
				runningSum -= nums[left % n];
				left++;
			}
			if (runningSum == mod) {
				System.out.println("Yes");
				sc.close();
				return;
			}
			right++;
		}
		if (runningSum == mod) {
			System.out.println("Yes");
		}
		else
			System.out.println("No");
		sc.close();

	}

}

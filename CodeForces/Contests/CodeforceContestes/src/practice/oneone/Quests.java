package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 10-Aug-2025
 */
public class Quests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums1 = new int[n];
			int[] nums2 = new int[n];
			for (int index = 0; index < n; index++) {
				nums1[index] = sc.nextInt();
			}
			for (int index = 0; index < n; index++) {
				nums2[index] = sc.nextInt();
			}
			System.out.println(findMaximumExp(nums1, nums2, k, n));
		}
		sc.close();
	}

	private static int findMaximumExp(int[] nums1, int[] nums2, int k, int n) {
		int maximumRepeat = 0;
		int sum = 0;
		int answer = 0;
		for (int index = 0; index < Math.min(n, k); index++) {
			sum += nums1[index];
			maximumRepeat = Math.max(maximumRepeat, nums2[index]);
			answer = Math.max(answer, sum + (k - index - 1) * maximumRepeat);
		}
		return answer;
	}

}

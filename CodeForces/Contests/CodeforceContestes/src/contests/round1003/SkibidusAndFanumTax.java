package contests.round1003;

import java.util.Scanner;

/**
 * @author rohithvazhathody 09-Feb-2025
 */
public class SkibidusAndFanumTax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] nums1 = new int[n];
			int[] nums2 = new int[m];
			for (int i = 0; i < n; i++) {
				nums1[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				nums2[i] = sc.nextInt();
			}
			System.out.println(isPossible(n, m, nums1, nums2));
		}
		sc.close();
	}

	private static String isPossible(int n, int m, int[] nums1, int[] nums2) {
		int foundMin = Math.min(nums1[0], nums2[0] - nums1[0]);
		for (int i = 1; i < n; i++) {
			int min = Math.min(nums1[i], nums2[0] - nums1[i]);
			int max = Math.max(nums1[i], nums2[0] - nums1[i]);
			if (foundMin <= min) {
				foundMin = min;
			} else if (foundMin <= max) {
				foundMin = max;
			} else {
				return "NO";
			}
		}
		return "YES";
	}

}

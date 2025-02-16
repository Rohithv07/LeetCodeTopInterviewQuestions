package contests.round1003;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 09-Feb-2025
 * 
 *         not completed
 */
public class SkibidusAndFanumTax2 {

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
		Arrays.sort(nums2);
		nums1[0] = Math.min(nums1[0], nums2[0] - nums1[0]);
		for (int i = 1; i < n; i++) {
			int currentNum = nums1[i];
			int low = 0;
			int high = m - 1;
			while (low <= high) {
				int middle = low + (high - low) / 2;
				if (nums2[middle] - nums1[i] >= nums1[i - 1]) {
					currentNum = nums2[middle] - nums1[i];
					high = middle - 1;
				} else {
					low = middle + 1;
				}
			}
			if (nums1[i] >= nums1[i - 1]) {
				currentNum = Math.min(nums1[i], currentNum);
			}
			nums1[i] = currentNum;
		}
		for (int i = 0; i < n - 1; i++) {
			if (nums1[i] > nums1[i + 1]) {
				return "NO";
			}
		}
		return "YES";
	}
}

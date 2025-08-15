package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 15-Aug-2025
 */
public class AdjacentXOR {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums1 = new int[n];
			int [] nums2 = new int [n];
			for (int index = 0; index < n; index++) {
				nums1[index] = sc.nextInt();
			}
			for (int index = 0; index < n; index++) {
				nums2[index] = sc.nextInt();
			}
			System.out.println(isConversionPossible(nums1, nums2, n));
		}
		sc.close();
	}

	private static String isConversionPossible(int[] nums1, int[] nums2, int n) {
		for (int index = 0; index + 1 < n; index++) {
			if ((nums1[index] ^ nums1[index + 1]) == nums2[index]) {
				nums1[index] = nums2[index];
			}
		}
		for (int index = n - 2; index >= 0; index--) {
			if ((nums1[index] ^ nums1[index + 1]) == nums2[index]) {
				nums1[index] = nums2[index];
			}
		}
		for (int index = 0; index < n; index++) {
			if (nums1[index] != nums2[index]) {
				return "NO";
			}
		}
		return "YES";
	}

}

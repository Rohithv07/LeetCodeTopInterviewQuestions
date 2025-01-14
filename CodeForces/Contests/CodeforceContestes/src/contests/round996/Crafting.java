package contests.round996;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 12-Jan-2025
 */
public class Crafting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums1 = new int[n];
			for (int i = 0; i < n; i++) {
				nums1[i] = sc.nextInt();
			}
			int[] nums2 = new int[n];
			for (int i = 0; i < n; i++) {
				nums2[i] = sc.nextInt();
			}
			System.out.println(isItPossible(nums1, nums2, n));
		}
		sc.close();
	}

	private static String isItPossible(int[] nums1, int[] nums2, int n) {
		int[] copy = new int[n];
		for (int i = 0; i < n; i++) {
			copy[i] = nums1[i] - nums2[i];
		}
		Arrays.sort(copy);
		return copy[0] + copy[1] >= 0 ? "YES" : "NO";
//		int crafted = 0;
//		for (int i = 0; i < n; i++) {
//			if (nums2[i] > nums1[i]) {
//				crafted += nums2[i] - nums1[i];
//			}
//		}
//		if (crafted <= (totalSum - neededSum)) {
//			return "YES";
//		}
	}

}
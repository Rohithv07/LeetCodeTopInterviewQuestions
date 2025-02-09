package contests;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author rohithvazhathody 09-Feb-2025
 */
public class MilyaAndTwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums1 = new int[length];
			int[] nums2 = new int[length];
			for (int i = 0; i < length; i++) {
				nums1[i] = sc.nextInt();
			}
			for (int i = 0; i < length; i++) {
				nums2[i] = sc.nextInt();
			}
			System.out.println(possibleOrNot(nums1, nums2));
		}
		sc.close();
	}

	private static String possibleOrNot(int[] nums1, int[] nums2) {
		Set<Integer> track1 = new HashSet<>();
		Set<Integer> track2 = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			track1.add(nums1[i]);
			track2.add(nums2[i]);
		}
		return track1.size() + track2.size() < 4 ? "NO" : "YES";
	}

}

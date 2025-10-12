package practice.oneone;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 03-Oct-2025
 */
public class SortTheSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int length = sc.nextInt();
			int[] nums1 = new int[length];
			for (int index = 0; index < length; index++) {
				nums1[index] = sc.nextInt();
			}
			int[] nums2 = new int[length];
			for (int index = 0; index < length; index++) {
				nums2[index] = sc.nextInt();
			}
			int[] range = findRange(nums1, nums2);
			System.out.println(range[0] + " " + range[1]);
		}
		sc.close();
	}

	private static int[] findRange(int[] nums1, int[] nums2) {
		int[] temp = nums1.clone();
		int length = nums1.length;
		Arrays.sort(temp);
		boolean fullySorted = true;
		for (int index = 0; index < length; index++) {
			if (nums2[index] != temp[index]) {
				fullySorted = false;
				break;
			}
		}
		if (fullySorted) {
			return new int[] { 1, length };
		}
		int left = 0;
		int right = length - 1;
		while (nums1[left] == nums2[left]) {
			left++;
		}
		while (nums2[right] == nums1[right]) {
			right--;
		}
		while (left > 0 && nums2[left] >= nums2[left - 1]) {
			left--;
		}
		while (right < length - 1 && nums2[right] <= nums2[right + 1]) {
			right++;
		}
		return new int[] { left + 1, right + 1 };
	}

}

/*
 * 3 4 5 6 6 6 6 5 3 4 5 5 6 6 6 6
 * 
 */

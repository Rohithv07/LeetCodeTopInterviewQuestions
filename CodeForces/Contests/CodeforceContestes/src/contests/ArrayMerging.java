package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Jun-2025
 */
public class ArrayMerging {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int size = sc.nextInt();
			int[] nums1 = new int[size];
			int[] nums2 = new int[size];
			for (int index = 0; index < size; index++) {
				nums1[index] = sc.nextInt();
			}
			for (int index = 0; index < size; index++) {
				nums2[index] = sc.nextInt();
			}
			System.out.println(maxSubarrayLength(nums1, nums2, size));
		}
		sc.close();
	}

	private static long maxSubarrayLength(int[] nums1, int[] nums2, int size) {
		long[] newArray1 = new long[2 * size + 1];
		long[] newArray2 = new long[2 * size + 1];
		subarrayLengthFinder(nums1, newArray1, size);
		subarrayLengthFinder(nums2, newArray2, size);
		long maxLength = -1;
		for (int index = 1; index <= 2 * size; index++) {
			maxLength = Math.max(maxLength, newArray1[index] + newArray2[index]);
		}
		return maxLength;
	}

	private static void subarrayLengthFinder(int[] arr, long[] newArray, int size) {
		int n = arr.length;
		int count = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			} else {
				newArray[arr[i - 1]] = Math.max(count, newArray[arr[i - 1]]);
				count = 1;
			}
		}
		newArray[arr[size - 1]] = Math.max(count, newArray[arr[size - 1]]);
	}

}

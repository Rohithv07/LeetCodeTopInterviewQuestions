package practice.oneone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 26-Oct-2025
 */
public class KalindromeArray {

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
			boolean isKPalindrome = findKPalindrome(nums);
			System.out.println(isKPalindrome ? "YES" : "NO");
		}
		sc.close();
	}

	private static boolean findKPalindrome(int[] nums) {
		int length = nums.length;
		if (length <= 2) {
			return true;
		}
		if (alreadyPalindrome(nums)) {
			return true;
		}
		for (int index = 0; index < length; index++) {
			if (nums[index] != nums[length - index - 1]) {
				if (isPossible(nums, nums[index]) || isPossible(nums, nums[length - index - 1])) {
					return true;
				}
				return false;
			}
		}
		return false;
	}

	private static boolean isPossible(int[] nums, int val) {
		List<Integer> excluded = new ArrayList<>();
		for (int index = 0; index < nums.length; index++) {
			if (nums[index] != val) {
				excluded.add(nums[index]);
			}
		}
		return alreadyPalindrome(excluded.stream().mapToInt(Integer::intValue).toArray());
	}

	private static boolean alreadyPalindrome(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] != nums[right]) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}

package practice.eight;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 07-Dec-2024
 */
public class ServalAndMochasArmy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(isBeautiful(nums, n));
		}
		sc.close();
	}

	private static String isBeautiful(int[] nums, int n) {
		boolean isPossible = false;
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (gcd(nums[i], nums[j]) <= 2) {
					isPossible = true;
					break;
				}
			}
			if (isPossible) {
				break;
			}
		}
		return isPossible ? "YES" : "NO";
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

}

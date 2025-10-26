package practice.oneone;

import java.util.Scanner;

/**
 * @author rohithvazhathody 26-Oct-2025
 */
public class PaintTheArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = sc.nextLong();
			}
			long beautifulColor = findBeautifulColoring(nums);
			System.out.println(beautifulColor);
		}
		sc.close();
	}

	private static long findBeautifulColoring(long[] nums) {
		long gcdOdd = 0;
		long gcdEven = 0;
		int length = nums.length;
		for (int index = 0; index < length; index++) {
			long num = nums[index];
			if (index % 2 == 0) {
				gcdEven = findGCD(num, gcdEven);
			} else {
				gcdOdd = findGCD(num, gcdOdd);
			}
		}
		boolean isDivisible = false;
		for (int index = 1; index < length; index += 2) {
			if (nums[index] % gcdEven == 0) {
				isDivisible = true;
				break;
			}
		}
		if (!isDivisible) {
			return gcdEven;
		}
		isDivisible = false;
		for (int index = 0; index < length; index += 2) {
			if (nums[index] % gcdOdd == 0) {
				isDivisible = true;
				break;
			}
		}
		if (!isDivisible) {
			return gcdOdd;
		}
		return 0;
	}

	private static long findGCD(long num, long gcd) {
		if (gcd == 0) {
			return num;
		}
		return findGCD(gcd, num % gcd);
	}

}

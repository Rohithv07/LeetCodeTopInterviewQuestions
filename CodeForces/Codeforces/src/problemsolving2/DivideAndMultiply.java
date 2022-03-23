package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

public class DivideAndMultiply {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMaxSum(nums, n));
		}
	}

	private static long findMaxSum(int[] nums, int n) {
		long sum = 0;
		if (n == 1) {
			return nums[0];
		}
		long[] copy = new long[n];
		int countOfDivision = 0;
		for (int i = 0; i < n; i++) {
			copy[i] = nums[i];
			while (copy[i] % 2 == 0) {
				copy[i] /= 2;
				countOfDivision++;
			}
		}
		Arrays.sort(copy);
		long pow = (long) Math.pow(2, countOfDivision) * copy[n - 1];
		copy[n - 1] = pow;
		for (long value : copy) {
			sum += value;
		}
		return sum;
	}
}

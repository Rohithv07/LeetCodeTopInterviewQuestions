/*
You are given a code and asked to modify the code to unlock a vault. In addition to the code, you’re also given a value k. To unlock the vault, you must modify each value in code based on the value of k. If k > 0, you must replace the ith value with the sum of the next k values. If k < 0, you must replace the ith value with the sum of the previous k values. If k == 0, you must replace the ith value with the number zero. Return the correct code to unlock the vault.
Note: Values in code are circular meaning that the “next” value after the last value in code is the first value in code and similarly, the previous value to the first value in code is the last value in code.

Ex: Given the following code and value k…

code = [1, 2, 3], k = 2, return [5, 4, 3] (2 + 3, 3 + 1, 1 + 2).
Ex: Given the following code and value k…

code = [4, 1, 3], k = -1, return [3, 4, 1].
*/

import java.util.*;

public class VaultCode {

	public static int [] findCircularSumK(int [] nums, int k) {
		int length = nums.length;
		boolean isReversed = false;
		if (k < 0) {
			reverse(nums);
			k *= -1;
			isReversed = true;
		}
		int [] result = new int [length];
		int [] prefixSum = new int [length];
		prefixSum[0] = nums[0];
		for (int i=1; i<length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}
		for (int i=0; i<length; i++) {
			if (i + k < length) {
				result[i] = prefixSum[i + k] - prefixSum[i];
			}
			else {
				int x = k - (length - i - 1);
				int y = x / length;
				int rem = x % length;
				result[i] = prefixSum[length - 1] - prefixSum[i] + y * prefixSum[length - 1] + (rem - 1 >= 0 ? prefixSum[rem - 1] : 0);
			}
		}
		if (isReversed) {
			reverse(result);
		}
		return result;
	}

	public static void reverse(int [] nums) {
		int i = 0;
		int j = nums.length - 1;
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int [] result = findCircularSumK(nums, k);
		printResult(result);
	}

	public static void printResult(int [] nums) {
		int n = nums.length;
		for (int i=0; i<n; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
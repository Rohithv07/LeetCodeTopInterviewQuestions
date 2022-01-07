package SeptemberLongChallenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * change to main
 * 
 * @author rohithvazhathody
 *
 */
public class ShufflingParities {

	public static int findMaxSum(int[] nums) {
		if (nums.length == 1) {
			return (nums[0] + 1) % 2;
		}
		int sum = 0;
		int n = nums.length;
		int[] random = new int[n];
		Arrays.fill(random, -1);
		int index = 0;
		for (int number : nums) {
			if (number % 2 == 0 && index < n) {
				random[index] = number;
				index += 2;
			}
		}
		index = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] % 2 == 1) {
				while (random[index] != -1) {
					index++;
				}
				random[index] = nums[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (random[i] != -1)
				sum = sum + ((random[i] + i + 1) % 2);
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			System.out.println(findMaxSum(nums));
		}
		sc.close();
	}
}

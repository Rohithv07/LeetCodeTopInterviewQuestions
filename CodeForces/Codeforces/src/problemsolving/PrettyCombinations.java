package problemsolving;

import java.util.Scanner;

public class PrettyCombinations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = i + 1;
			}
			for (int i = 0; i < n - 1; i += 2) {
				swap(nums, i, i + 1);
			}
			if (n % 2 == 1)
				swap(nums, n - 1, n - 2);
			for (int number : nums) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}
}

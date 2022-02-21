package problemsolving;

import java.util.Scanner;

public class ClosingTheGap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				sum += nums[i];
			}
			if (sum % n == 0) {
				System.out.println("0");
			} else {
				System.out.println("1");
			}
		}
	}
}

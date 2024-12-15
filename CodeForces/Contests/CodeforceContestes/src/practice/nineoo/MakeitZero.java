package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class MakeitZero {

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
			if (n % 2 == 0) {
				System.out.println(2);
				System.out.println(1 + " " + n);
				System.out.println(1 + " " + n);
			} else {
				System.out.println(4);
				System.out.println(1 + " " + (n - 1));
				System.out.println(1 + " " + (n - 1));
				System.out.println((n - 1) + " " + (n));
				System.out.println((n - 1) + " " + (n));
			}
		}
		sc.close();
	}

}

// 1^1^9^9^0^1^8
// 9 9 9 9 9 9 9
// 9 9 9 9 9 0 0
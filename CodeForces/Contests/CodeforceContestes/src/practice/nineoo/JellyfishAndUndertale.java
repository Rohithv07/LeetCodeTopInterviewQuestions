package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Dec-2024
 */
public class JellyfishAndUndertale {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			int n = sc.nextInt();
			long[] nums = new long[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextLong();
			}
			long counter = b;
			for (int i = 0; i < n; i++) {
				counter += Math.min(a - 1, nums[i]);
			}
			
			System.out.println(counter);
		}
		sc.close();
	}

}

/*
 * 5 1 1 7 3 3+1, 5 = 4 4+1, 5 = 5 7+5, 5 = 5 7 +4, 5 = 5 7 + 3, 5 = 5 7+2, 5 =
 * 5 7 + 1, 5 = 5
 * 
 * 
 */

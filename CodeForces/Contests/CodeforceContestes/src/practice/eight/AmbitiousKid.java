package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 02-Dec-2024
 */
public class AmbitiousKid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int test = sc.nextInt();
//		while (test-- > 0) {
			int n = sc.nextInt();
			int small = Integer.MAX_VALUE;
			int nums[] = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				small = Math.min(small, Math.abs(nums[i]));
			}
			System.out.println(small);
		//}
		sc.close();
	}

}

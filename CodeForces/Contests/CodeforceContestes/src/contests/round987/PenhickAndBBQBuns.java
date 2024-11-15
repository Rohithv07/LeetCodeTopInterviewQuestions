package contests.round987;


import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Nov-2024
 */
public class PenhickAndBBQBuns {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			long[] nums = new long[n];
			if (n == 3 || n == 1) {
				System.out.println(-1);
			} else {
				long maxSquare = 1;
				for (int i = 1; i * i < n; i++) {
					maxSquare = i;
				}
				if (maxSquare + maxSquare < n) {
					System.out.println(-1);
				}
				else {
					for (int i = 0; i + maxSquare < n; i += maxSquare) {
						
					}
				}
				long fill = 1;
				int i = 0;
				int mod = n % 2;
				for (i = 0; i < n - mod; i += 2) {
					nums[i] = fill;
					nums[i + 1] = fill;
					fill++;
				}
				if (i < n) {
					nums[i] = fill - 1;
				}
				for (i = 0; i < n; i++) {
					System.out.print(nums[i] + " ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}

/*
 * 1 2 3 4 5
 * 1 2 1 2 1
 */


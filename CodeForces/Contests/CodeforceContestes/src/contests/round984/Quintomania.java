package contests.round984;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 02-Nov-2024
 */
public class Quintomania {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int [] nums = new int [n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}
			boolean isMelody = true;
			for (int i = 0; i + 1 < n; i++) {
				int current = nums[i];
				int next = nums[i + 1];
				if ((Math.abs(current - next) != 5) && Math.abs(current - next) != 7) {
					isMelody = false;
					break;
				}
			}
			if (isMelody) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}
}

package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 04-Dec-2024
 */
public class ArrayColoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			int oddCount = 0;
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
				if (nums[i] % 2 == 1) {
					oddCount++;
				}
			}
			if (oddCount % 2 == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}

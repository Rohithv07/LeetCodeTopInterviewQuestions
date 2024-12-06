package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Dec-2024
 */
public class BlankSpace {

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
			int longest = 0;
			for (int i = 0; i < n;) {
				int current = nums[i];
				if (current == 0) {
					int currentLength = 0;
					while (i < n && nums[i] == 0) {
						i++;
						currentLength++;
					}
					longest = Math.max(longest, currentLength);
				}
				else {
					i++;
				}
			}
			System.out.println(longest);
		}
		sc.close();
	}

}

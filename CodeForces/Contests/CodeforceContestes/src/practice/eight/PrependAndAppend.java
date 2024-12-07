package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 07-Dec-2024
 */
public class PrependAndAppend {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int low = 0;
			int high = n - 1;
			while (low < high
					&& ((s.charAt(low) == '0' && s.charAt(high) == '1') || (s.charAt(low) == '1' && s.charAt(high) == '0'))) {
				low++;
				high--;

			}
			if (low > high) {
				System.out.println(0);
			} else {
				System.out.println(high - low + 1);
			}
		}
		sc.close();
	}

}

package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 08-Jun-2025
 */
public class NotQuiteAPalindromicString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			int countZero = 0;
			int countOne = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					countZero++;
				}
				else {
					countOne++;
				}
			}
			int minimum = Math.max(countZero, countOne) - (n / 2);
			int maximum = (countZero / 2) + (countOne / 2);
			if (minimum <= k && (k - minimum) % 2 == 0 && k <= maximum) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		sc.close();
	}

}

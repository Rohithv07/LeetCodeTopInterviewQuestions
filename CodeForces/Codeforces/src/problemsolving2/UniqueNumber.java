/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class UniqueNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			System.out.println(findUnique(x));
		}
	}

	public static String findUnique(int x) {
		if (x < 10) {
			return String.valueOf(x);
		}
		int sum = 0;
		int last = 9;
		StringBuilder sb = new StringBuilder();
		while (sum < x && last > 0) {
			int digit = Math.min(Math.abs(x - sum), last);
			sb.append(digit);
			sum += last;
			last--;
		}
		if (sum < x) {
			return "-1";
		}
		return sb.reverse().toString();
	}
}

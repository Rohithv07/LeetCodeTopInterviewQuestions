/**
 * 
 */
package GoogleKickstart;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class Solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			long d = sc.nextLong();
			long c = sc.nextLong();
			long m = sc.nextLong();
			String s = sc.next();
			System.out.println("Case #" + t + ": " + willDogEat(n, d, c, m, s));
		}
	}

	private static String willDogEat(int n, long d, long c, long m, String s) {
		long countC = 0;
		long countD = 0;
		for (char ch : s.toCharArray()) {
			if (ch == 'C') {
				countC++;
			}
			else {
				countD++;
			}
		}
		if (countD == 0) {
			return "YES";
		}
		for (char ch : s.toCharArray()) {
			if (ch == 'C' && c > 0) {
				c -= 1;
				countC--;
			}
			else if (ch == 'D' && d > 0) {
				d -= 1;
				c += m;
				countD--;
			}
			else if (ch == 'D' && d <= 0) {
				return "NO";
			}
			else if (ch == 'C' && c <= 0) {
				if (countD > 0) {
					return "NO";
				}
				return "YES";
			}
		}
		return countD > 0 ? "NO" : "YES";
	}

}

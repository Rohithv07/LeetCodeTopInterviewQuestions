package contests.round1003;

import java.util.Scanner;

/**
 * @author rohithvazhathody 09-Feb-2025
 */
public class SkibudusAndOhio {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			boolean isThereDuplicate = false;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					isThereDuplicate = true;
					break;
				}
			}
			System.out.println(isThereDuplicate ? 1 : s.length());
		}
		sc.close();
	}

}

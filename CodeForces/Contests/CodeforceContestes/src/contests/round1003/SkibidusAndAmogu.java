package contests.round1003;

import java.util.Scanner;

/**
 * @author rohithvazhathody 09-Feb-2025
 */
public class SkibidusAndAmogu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(s.substring(0, s.length() - 2) + "i");
		}
		sc.close();
	}

}

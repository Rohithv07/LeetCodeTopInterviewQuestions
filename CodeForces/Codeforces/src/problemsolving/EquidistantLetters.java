package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author rohithvazhathody
 *
 */
public class EquidistantLetters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(findTheString(s));
		}
	}

	public static String findTheString(String s) {
		if (s.length() <= 2) {
			return s;
		}
		char[] ch = s.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}

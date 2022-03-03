/**
 * 
 */
package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class TwoSubsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			char[] array = s.toCharArray();
			Arrays.sort(array);
			StringBuilder sb1 = new StringBuilder();
			sb1.append(array[0]);
			boolean weFound = false;
			StringBuilder sb2 = new StringBuilder();
			for (char ch : s.toCharArray()) {
				if (ch == array[0] && !weFound) {
					weFound = true;
				} else {
					sb2.append(ch);
				}
			}
			System.out.println(sb1.toString() + " " + sb2.toString());
		}
	}
}

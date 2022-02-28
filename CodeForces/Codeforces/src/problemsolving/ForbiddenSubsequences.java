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
public class ForbiddenSubsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			int[] count = new int[26];
			for (char ch : s1.toCharArray()) {
				count[ch - 'a'] += 1;
			}
			char[] s1Array = s1.toCharArray();
			Arrays.sort(s1Array);
			if (count[0] == 0 || count[1] == 0 || count[2] == 0 || !s2.equals("abc")) {
				System.out.println(new String(s1Array));
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < count[0]; i++) {
					sb.append("a");
				}
				for (int i = 0; i < count[2]; i++) {
					sb.append("c");
				}
				for (int i = 0; i < count[1]; i++) {
					sb.append("b");
				}
				for (int i = 3; i < 26; i++) {
					for (int j = 0; j < count[i]; j++) {
						sb.append((char) (i + 'a'));
					}
				}
				System.out.println(sb.toString());
			}
		}
	}
}

/**
 * 
 */
package codejam;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class AseDatAb {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = 8;
			String pattern = "01";
			StringBuilder sb1 = new StringBuilder();
			for (int i = 0; i < n; i++) {
				int index = (int) (pattern.length() * Math.random());
				sb1.append(pattern.charAt(index));
			}
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < n; i++) {
				int index = (int) (pattern.length() * Math.random());
				sb2.append(pattern.charAt(index));
			}
			String s = sb1.toString();
			String p = sb2.toString();
			System.out.println(p);
			while (!s.equals("00000000")) {
				int rotation = sc.nextInt();
				String afterRotation = rightrotate(p, rotation);
				System.out.println(afterRotation);
				StringBuilder newSb = new StringBuilder();
				int countOne = 0;
				for (int i = 0; i < n; i++) {
					if (s.charAt(i) == afterRotation.charAt(i)) {
						newSb.append(0);
					} else {
						newSb.append(1);
						countOne++;
					}
				}
				s = newSb.toString();
			}
		}
	}

	private static String leftrotate(String str, int d) {
		String ans = str.substring(d) + str.substring(0, d);
		return ans;
	}

	private static String rightrotate(String str, int d) {
		return leftrotate(str, str.length() - d);
	}

}

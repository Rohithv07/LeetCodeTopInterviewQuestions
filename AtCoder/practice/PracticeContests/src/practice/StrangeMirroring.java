/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class StrangeMirroring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int q = sc.nextInt();
		int length = s.length();
		for (int i = 0; i < q; i++) {
			long k = sc.nextLong();
			k--;
			long block = k / length;
			long part = k % length;
			//System.out.println(part);
			if (Long.bitCount(block) % 2 == 0) {
				System.out.print(s.charAt((int) part) + " ");
			} else {
				System.out.print(flip(s, part, length) + " ");
			}
		}
		System.out.println();
		sc.close();
	}

	private static char flip(String s, long k, int length) {
		if (Character.isLowerCase(s.charAt((int) k))) {
			return Character.toUpperCase((s.charAt((int) k)));
		}
		return Character.toLowerCase(s.charAt((int) k));
	}

}
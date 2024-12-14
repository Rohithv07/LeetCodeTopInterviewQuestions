/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class AAAADAA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char ch1 = sc.next().charAt(0);
		char ch2 = sc.next().charAt(0);
		String s = sc.next();
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch != ch1) {
				sb.append(ch2);
			} else {
				sb.append(ch1);
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}

}

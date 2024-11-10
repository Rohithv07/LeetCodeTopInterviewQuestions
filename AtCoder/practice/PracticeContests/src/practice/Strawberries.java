/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class Strawberries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		int strawberries = 0;
		int healthy = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == 'O') {
				healthy++;
				if (healthy == k) {
					strawberries++;
					healthy = 0;
				}
			}
			else {
				healthy = 0;
			}
		}
		System.out.println(strawberries);
		sc.close();
	}

}

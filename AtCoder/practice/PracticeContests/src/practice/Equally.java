/**
 * 
 */
package practice;

import java.util.Scanner;

/**
 * 
 */
public class Equally {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a == b && b == c) {
			System.out.println("Yes");
		}
		else {
			if ((a + b) == c || (b + c == a) || (a + c == b)) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
		sc.close();
	}

}

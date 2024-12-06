package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 05-Dec-2024
 */
public class Grasshopperonline {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (n % k != 0) {
				System.out.println("1");
				System.out.println(n);
			} else {
				System.out.println("2");
				System.out.print(n - 1 + " 1");
				System.out.println();
			}
		}
		sc.close();
	}

}

package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 04-Dec-2024
 */
public class Buttons {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			String result = "";
			if (a == b) {
				if (c % 2 == 0) {
					result = "Second";
				} else {
					result = "First";
				}
			} else {
				if (a > b) {
					result = "First";
				} else {
					result = "Second";
				}
			}
			System.out.println(result);
		}
		sc.close();
	}

}

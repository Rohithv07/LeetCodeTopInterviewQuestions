package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 19-Jan-2025
 */
public class Fibonancies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			int v1 = a + b;
			int v2 = d - b;
			int v3 = e - d;
			if (v1 == v2 && v3 == v2) {
				System.out.println(3);
			} else if (v1 == v2 || v2 == v3 || v3 == v1) {
				System.out.println(2);
			} else {
				System.out.println(1);
			}
		}
		sc.close();
	}

}

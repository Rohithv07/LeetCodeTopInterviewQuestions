package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 06-Jul-2025
 */
public class MexOrMissUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(findMinimumLength(a, b));
		}
		sc.close();
	}

	private static int findMinimumLength(int a, int b) {
		int xor = 0;
		int n = a - 1;
		if (n % 4 == 0) {
			xor = n;
		}
		else if (n % 4 == 1) {
			xor = 1;
		}
		else if (n % 4 == 2) {
			xor = n + 1;
		}
		else {
			xor = 0;
		}
		if (xor == b) {
			return a;
		}
		if (xor != b) {
			if ((xor ^ b) != a) {
				return a + 1;
			} else {
				return a + 2;
			}
		}
		return 0;
	}

}

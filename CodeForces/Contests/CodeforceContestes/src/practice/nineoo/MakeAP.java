package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 25-Dec-2024
 */
public class MakeAP {

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
			System.out.println(isPossible(a, b, c));

		}
		sc.close();
	}

	private static String isPossible(int a, int b, int c) {
		int newA = b - (c - b);
		if (newA >= a && newA % a == 0 && newA != 0) {
			return "YES";
		}
		int newB = a + (c - a) / 2;
		if (newB >= b && (c - a) % 2 == 0 && newB % b == 0 && newB != 0) {
			return "YES";
		}
		int newC = a + 2 * (b - a);
		if (newC >= c && newC % c == 0 && newC != 0) {
			return "YES";
		}
		return "NO";
	}

}

// a, a + d, a + 2d

// a = x1
// b = x2 = x1 + d

// b - a = x2 - x1 = x1 + d - x1 = d

/*
 * b - a = d -> eq 1
 * 
 * a = c - b c = a + b a = a + b - b
 * 
 * 
 */

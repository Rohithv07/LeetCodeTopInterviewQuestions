package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 16-Dec-2024
 */
public class PermutationSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int result = 0;
			for (int i = 1; i <= n; i++) {
				int x = sc.nextInt();
				result = findGCD(result, Math.abs(x - i));
			}
			System.out.println(result);
		}
		sc.close();
	}

	private static int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

}

/*
 * 4 2 6 7 5 3 1 1 2 3 4 5 6 7
 * 
 * 3 0 3 3 0 3 6
 * 
 * 1 6 7 4 9 2 3 8 5 1 2 3 4 5 6 7 8 9
 * 
 * 0 4 4 0 4 4 4 0 4
 * 
 * 3 10 5 2 9 6 7 8 1 4 1 2 3 4 5 6 7 8 9 10
 * 
 * 2 8 2 2 4 0 0 0 8 6
 */

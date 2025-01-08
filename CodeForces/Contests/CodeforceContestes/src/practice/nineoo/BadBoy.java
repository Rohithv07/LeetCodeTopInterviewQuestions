package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Jan-2025
 */
public class BadBoy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int antRow = sc.nextInt();
			int antCol = sc.nextInt();
			int[] pos = findMaxDist(row, col, antRow, antCol);
			System.out.println(pos[0] + " " + pos[1] + " " + pos[2] + " " + pos[3]);
		}
		sc.close();
	}

	private static int[] findMaxDist(int row, int col, int antRow, int antCol) {
		return new int[] { 1, 1, row, col };
	}

}

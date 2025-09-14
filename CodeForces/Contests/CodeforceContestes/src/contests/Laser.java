package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Sept-2025
 */
public class Laser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int[] horizontal = new int[row];
			int[] vertical = new int[col];
			for (int i = 0; i < row; i++) {
				horizontal[i] = sc.nextInt();
			}
			for (int i = 0; i < col; i++) {
				vertical[i] = sc.nextInt();
			}
			System.out.println(row + col);
		}
		sc.close();
	}

}

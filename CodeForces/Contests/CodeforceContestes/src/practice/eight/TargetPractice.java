package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Dec-2024
 */
public class TargetPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			char[][] mat = new char[10][10];
			for (int i = 0; i < 10; i++) {
				String s = sc.next();
				for (int j = 0; j < 10; j++) {
					mat[i][j] = s.charAt(j);
				}
			}
			int[][] finalMat = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
					{ 1, 2, 3, 3, 3, 3, 3, 3, 2, 1 }, { 1, 2, 3, 4, 4, 4, 4, 3, 2, 1 },
					{ 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 }, { 1, 2, 3, 4, 5, 5, 4, 3, 2, 1 },
					{ 1, 2, 3, 4, 4, 4, 4, 3, 2, 1 }, { 1, 2, 3, 3, 3, 3, 3, 3, 2, 1 },
					{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
			int total = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (mat[i][j] == 'X') {
						total += finalMat[i][j];
					}
				}
			}
			System.out.println(total);

		}
		sc.close();
	}

}

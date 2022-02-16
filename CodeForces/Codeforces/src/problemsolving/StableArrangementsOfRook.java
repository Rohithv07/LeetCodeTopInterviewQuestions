package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

public class StableArrangementsOfRook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			if (k > (n + 1) / 2) {
				System.out.println("-1");
			}
			else {
				char [][] chess = new char [n][n];
				for (int i = 0; i < n; i++)
					Arrays.fill(chess[i], '.');
				for (int i = 0; i < k; i++) {
					chess[2 * i][2 * i] = 'R';
				}
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(chess[i][j]);
					}
					System.out.println();
				}
			}
		}
		sc.close();
	}
}

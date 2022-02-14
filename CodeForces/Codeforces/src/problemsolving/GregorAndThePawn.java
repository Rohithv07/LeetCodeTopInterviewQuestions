package problemsolving;

import java.util.Scanner;

public class GregorAndThePawn {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String enemy = sc.next();
			String gregor = sc.next();
			char[] enemyChar = enemy.toCharArray();
			char[] gregorChar = gregor.toCharArray();
			int pawnLeft = 0;
			for (int i = 0; i < n; i++) {
				if (gregorChar[i] == '0') {
					continue;
				} else if (enemyChar[i] == '0') {
					pawnLeft += 1;
				} else if (i - 1 >= 0 && enemyChar[i - 1] == '1') {
					pawnLeft += 1;
				} else if (i + 1 < n && enemyChar[i + 1] == '1') {
					pawnLeft += 1;
					enemyChar[i + 1] = '2';
				}
			}
			System.out.println(pawnLeft);
		}
	}
}

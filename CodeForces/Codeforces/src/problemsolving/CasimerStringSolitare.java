package problemsolving;

import java.util.Scanner;

public class CasimerStringSolitare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int countA = 0;
			int countB = 0;
			int countC = 0;
			for (char ch : s.toCharArray()) {
				if (ch == 'A') {
					countA += 1;
				} else if (ch == 'B') {
					countB += 1;
				} else {
					countC += 1;
				}
			}
			if (countA + countC == countB) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}

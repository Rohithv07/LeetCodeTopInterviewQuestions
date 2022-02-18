package problemsolving;

import java.util.Scanner;

public class DominoDisaster {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			char [] sArray = s.toCharArray();
			for (int i = 0; i < n; i++) {
				if (sArray[i] == 'U') {
					sArray[i] = 'D';
				}
				else if (sArray[i] == 'D') {
					sArray[i] = 'U';
				}
			}
			System.out.println(new String(sArray));
		}
	}
}

package problemsolving;

import java.util.*;

public class BinaryDecimal {
	public static void main(String[] args) {
		Scanner fs = new Scanner(System.in);
		int t = fs.nextInt();
		while (t-- > 0) {
			int n = fs.nextInt();
			int m = fs.nextInt();
			int r = fs.nextInt();
			int c = fs.nextInt();
			int a[][] = new int[n][m];
			int black = 0;
			for (int i = 0; i < n; i++) {
				String s = fs.next();
				for (int j = 0; j < m; j++) {
					if (s.charAt(j) == 'B') {
						black++;
						a[i][j] = 1;
					}
				}
			}
			r--;
			c--;
			if (a[r][c] == 1)
				System.out.println(0);
			else if (black == 0)
				System.out.println(-1);
			else {
				boolean flag = false;
				for (int i = 0; i < m; i++)
					if (a[r][i] == 1) {
						flag = true;
						break;
					}
				if (!flag) {
					for (int i = 0; i < n; i++)
						if (a[i][c] == 1) {
							flag = true;
							break;
						}
				}
				if (flag)
					System.out.println(1);
				else
					System.out.println(2);
			}
		}
	}
}
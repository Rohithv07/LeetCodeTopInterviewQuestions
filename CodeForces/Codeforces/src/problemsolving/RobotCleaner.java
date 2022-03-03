/**
 * 
 */
package problemsolving;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class RobotCleaner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();
			int time = 0;
			int dr = 1;
			int dc = 1;
			while (r1 != r2 && c1 != c2) {
				time++;
				if (r1 == row) {
					dr = -1;
				}
				if (c1 == col) {
					dc = -1;
				}
				r1 += dr;
				c1 += dc;
			}
			System.out.println(time);
		}
	}
}

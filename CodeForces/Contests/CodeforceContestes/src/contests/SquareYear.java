package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Jun-2025
 */
public class SquareYear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String year = sc.next();
			int correctYear = Integer.parseInt(year);
			int sqrt = (int) Math.sqrt(correctYear);
			if (sqrt * sqrt != correctYear) {
				System.out.println(-1);
			} else {
				if (sqrt == 0) {
					System.out.println(0 + " " + 0);
				} else
					System.out.println(1 + " " + (sqrt - 1));
			}
		}
		sc.close();
	}

}

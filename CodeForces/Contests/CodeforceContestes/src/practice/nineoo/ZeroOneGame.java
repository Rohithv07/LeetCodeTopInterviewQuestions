package practice.nineoo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 12-Jan-2025
 */
public class ZeroOneGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			int count1 = 0;
			int count0 = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					count0++;
				} else {
					count1++;
				}
			}
			if (Math.min(count1, count0) % 2 == 1) {
				System.out.println("DA");
			} else {
				System.out.println("NET");
			}
		}
		sc.close();
	}

}

/**
 * 1011001 -> 0, 1 11001 -> 3, 4 110 -> 1, 2 1
 * 
 * 1 1 2 3 3 3 4
 * 
 * 
 */

package practice.eight;

import java.util.Scanner;

/**
 * @author rohithvazhathody 01-Dec-2024
 */
public class DontTryToCount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int x = sc.nextInt();
			int n = sc.nextInt();
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println(minOperation(s1, s2));
		}
		sc.close();
	}

	private static int minOperation(String s1, String s2) {
		// TODO Auto-generated method stub
		int minOperation = 0;
		int repeat = 0;
		while (repeat <= 5 && !s1.contains(s2)) {
			s1 += s1;
			repeat++;
			minOperation++;
		}
		return repeat > 5 ? -1 : minOperation;
	}

}

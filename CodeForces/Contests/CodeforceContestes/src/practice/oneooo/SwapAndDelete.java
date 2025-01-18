package practice.oneooo;

import java.util.Scanner;

/**
 * 
 * @author rohithvazhathody 19-Jan-2025
 */
public class SwapAndDelete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			String s = sc.next();
			System.out.println(findMinimumCost(s));
		}
		sc.close();
	}

	private static int findMinimumCost(String s) {
		int length = s.length();
		if (length == 1) {
			return 1;
		}
		int countOfOne = 0;
		int countOfZero = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '0') {
				countOfZero++;
			} else {
				countOfOne++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			if (ch == '0' && countOfOne > 0) {
				countOfOne--;
				sb.append(1);
			} else if (ch == '1' && countOfZero > 0) {
				countOfZero--;
				sb.append(0);
			} else if (countOfOne == 0 || countOfZero == 0) {
				break;
			}
		}
		return s.length() - sb.length();
	}

}

/**
 * 0101110001 1010110001 1010001110
 * 
 * 10
 * 
 * 
 * 10 000011
 * 
 * 111100 00
 * 
 */

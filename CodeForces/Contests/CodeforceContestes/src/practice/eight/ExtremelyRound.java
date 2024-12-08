package practice.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author rohithvazhathody 08-Dec-2024
 */
public class ExtremelyRound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
//		List<Integer> round = new ArrayList<>();
//		for (int i = 1; i <= 999999; i++) {
//			String check = String.valueOf(i);
//			boolean isFound = false;
//			int count = 0;
//			for (char ch : check.toCharArray()) {
//				if (ch != '0') {
//					count++;
//					if (count > 1) {
//						isFound = true;
//						break;
//					}
//				}
//			}
//			if (!isFound) {
//				round.add(i);
//			}
//		}
		while (test-- > 0) {
//			long n = sc.nextLong();
//			// 100 -> 10 + 9
//			if (n <= 9) {
//				System.out.println(n);
//			} else {
//				int count = 0;
//				for (Integer num : round) {
//					if (num <= n) {
//						count++;
//					}
//				}
//				System.out.println(count);
//			}
			
			String s = sc.next();
			int result = 9 * (s.length() - 1) + s.charAt(0) - '0';
			System.out.println(result);
		}
		sc.close();
	}

}
// the commented codes is also a possible bruteforce solution

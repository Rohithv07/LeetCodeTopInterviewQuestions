package SeptemberLongChallenge;

import java.util.Scanner;

/**
 * Change to Main
 * 
 * @author rohithvazhathody
 *
 */
public class TravelPass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int inter = sc.nextInt();
			int intra = sc.nextInt();
			String s = sc.next();
			int zeroCount = 0;
			int oneCount = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					zeroCount += 1;
				} else {
					oneCount += 1;
				}
			}
			int result = (zeroCount * inter) + (oneCount * intra);
			System.out.println(result);
		}
		sc.close();
	}
}

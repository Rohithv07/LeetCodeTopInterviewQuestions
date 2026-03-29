/**
 * @author rohithvazhathody
 * @date 22 Mar 2026
 * Project: CodeforceContestes
 * File: ChatBan.java
 */

package practice.onethree;

import java.util.Scanner;

/**
 * 
 */
public class ChatBan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long k = sc.nextLong();
			long x = sc.nextLong();
			long ans = findAnsBeforeBan(k, x);
			System.out.println(ans);
		}
		sc.close();
	}

	private static long findAnsBeforeBan(long k, long x) {
		long low = 1;
		long high = 2 * k - 1;
		long ans = 2 * k - 1;
		while (low <= high) {
			long middle = low + (high - low) / 2;
			if (isPossibleToSendMessage(middle, k, x)) {
				ans = middle;
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return ans;
	}

	private static boolean isPossibleToSendMessage(long middle, long k, long x) {
		long messagesSend = findMessagesToSend(middle, k);
		return messagesSend >= x;
	}

	private static long findMessagesToSend(long limit, long k) {
		if (limit <= k) {
			return limit * (limit + 1) / 2;
		}
		long remaining = (2 * k - 1) - limit;
		long max = k * k;
		return max - (remaining * (remaining + 1) / 2);
	}

}

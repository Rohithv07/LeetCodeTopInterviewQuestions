package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody 15-Jun-2025
 */
public class TrafficLight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			char color = sc.next().charAt(0);
			String s = sc.next();
			if (color == 'g') {
				System.out.println(0);
			} else {
				System.out.println(findMinimumTime(color, n, s));
			}
		}
		sc.close();
	}

	private static int findMinimumTime(char color, int n, String s) {
		s = s + s;
		int timer = 0;
		int maxTimer = Integer.MIN_VALUE;
		int right = 0;
		while (right < n) {
			if (s.charAt(right) != color) {
				right++;
			} else {
				while (s.charAt(right) != 'g') {
					timer++;
					right++;
				}
				maxTimer = Math.max(maxTimer, timer);
				timer = 0;
			}
		}
		return maxTimer;
	}

}

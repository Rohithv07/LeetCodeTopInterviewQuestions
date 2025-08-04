package contests;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * 05-Jul-2025
 */
public class BlackAndWhiteStripes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			System.out.println(findMinCellsColored(s, n, k));
		}
		sc.close();
	}

	private static int findMinCellsColored(String s, int n, int k) {
		if (k == 1 && s.contains("B")) {
			return 0;
		}
		if (k == 1) {
			return 1;
		}
		int [] whiteSum = new int [n + 1];
		whiteSum[0] = s.charAt(0) == 'W' ? 1 : 0;
		int minPaint = n + 1;
		for (int index = 1; index <= n; index++) {
			int white = s.charAt(index - 1) == 'W' ? 1 : 0;
			whiteSum[index] = whiteSum[index - 1] + white;
		}
		for (int index = k; index <= n; index++) {
			minPaint = Math.min(minPaint, whiteSum[index] - whiteSum[index - k]);
		}
		return minPaint;
	}

}

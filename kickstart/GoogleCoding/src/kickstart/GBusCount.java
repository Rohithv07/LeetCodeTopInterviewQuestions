/**
 * 
 */
package kickstart;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 * https://www.youtube.com/watch?v=E2icOW6Ntfo
 *
 */
public class GBusCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int n = sc.nextInt();
			int[][] buses = new int[n][2];
			for (int i = 0; i < n; i++) {
				buses[i][0] = sc.nextInt();
				buses[i][1] = sc.nextInt();
			}
			int[] startCount = new int[5001];
			int[] endCount = new int[5001];
			for (int i = 0; i < n; i++) {
				startCount[buses[i][0]]++;
				endCount[buses[i][1]]++;
			}
			int[] finalBus = new int[5001];
			int total = 0;
			for (int i = 1; i <= 5000; i++) {
				total += startCount[i];
				finalBus[i] = total;
				total -= endCount[i];
			}
			int p = sc.nextInt();
			System.out.print("Case #" + t + ": ");
			for (int i = 0; i < p; i++) {
				int q = sc.nextInt();
				System.out.print(finalBus[q] + " ");
			}
			System.out.println();
		}
	}
}

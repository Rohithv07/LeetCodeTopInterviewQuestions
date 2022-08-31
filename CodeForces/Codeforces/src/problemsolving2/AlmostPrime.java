/**
 * 
 */
package problemsolving2;

import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class AlmostPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] mark = new int[3001];
		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (mark[i] == 0) {
				for (int j = i; j <= n; j+=i) {
					mark[j]++;
				}
			}
			if (mark[i] == 2) {
				count++;
			}
		}
		System.out.println(count);
	}
}

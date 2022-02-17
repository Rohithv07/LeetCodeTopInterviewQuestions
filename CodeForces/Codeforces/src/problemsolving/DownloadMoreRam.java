/**
 * 
 */
package problemsolving;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class DownloadMoreRam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int [] a = new int [n];
			int [] b = new int [n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				b[i] = sc.nextInt();
			}
			Pair [] both = new Pair[n];
			for (int i = 0; i < n; i++) {
				both[i] = new Pair(a[i], b[i]);
			}
			Arrays.sort(both, (pair1, pair2) -> Integer.compare(pair1.a, pair2.a));
			if (k < both[0].a) {
				System.out.println(k);
			}
			else {
				for (int i = 0; i < n; i++) {
					if (k >= both[i].a) {
						k += both[i].b;
					}
					else {
						break;
					}
				}
				System.out.println(k);
			}
		}
	}
}

class Pair {
	int a;
	int b;
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

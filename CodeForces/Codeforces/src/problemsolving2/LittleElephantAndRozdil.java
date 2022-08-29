/**
 * 
 */
package problemsolving2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 *
 */
public class LittleElephantAndRozdil {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pair[] pair = new Pair[n];
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			pair[i] = new Pair(value, i);
		}
		if (n == 1) {
			System.out.println(pair[0].index + 1);
		} else {
			Arrays.sort(pair, (p1, p2) -> Integer.compare(p1.value, p2.value));
			if (pair[0].value == pair[1].value) {
				System.out.println("Still Rozdil");
			} else {
				System.out.println(pair[0].index + 1);
			}
		}
	}
}

class Pair {
	int value;
	int index;

	public Pair(int value, int index) {
		this.index = index;
		this.value = value;
	}
}

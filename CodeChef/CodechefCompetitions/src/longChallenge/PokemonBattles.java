/**
 * 
 */
package longChallenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody
 *
 */
public class PokemonBattles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int n = sc.nextInt();
			Pair land[] = new Pair[n];
			Pair[] water = new Pair[n];
			for (int i = 0; i < n; i++) {
				long value = sc.nextLong();
				land[i] = new Pair(value, i);
			}
			for (int i = 0; i < n; i++) {
				long value = sc.nextInt();
				water[i] = new Pair(value, i);
			}
			System.out.println(findPokemon(land, water, n));
		}
	}

	private static int findPokemon(Pair[] land, Pair[] water, int n) {
		Arrays.sort(land, (l1, l2) -> Long.compare(l2.number, l1.number));
		Arrays.sort(water, (l1, l2) -> Long.compare(l2.number, l1.number));
		
		return 0;
	}
}

class Pair {
	long number;
	int index;

	public Pair(long number, int index) {
		this.number = number;
		this.index = index;
	}
}

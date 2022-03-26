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
public class TheGreatHero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long attack = sc.nextLong();
			long health = sc.nextLong();
			int n = sc.nextInt();
			long[] monsterAttack = new long[n];
			for (int i = 0; i < n; i++) {
				monsterAttack[i] = sc.nextLong();
			}
			long[] monsterHealth = new long[n];
			for (int i = 0; i < n; i++) {
				monsterHealth[i] = sc.nextLong();
			}
			System.out.println(isPossibleToDefeat(attack, health, n, monsterAttack, monsterHealth) ? "YES" : "NO");
		}
	}

	private static boolean isPossibleToDefeat(long attack, long health, int n, long[] monsterAttack,
			long[] monsterHealth) {
		long max = 0;
		for (int i = 0; i < n; i++) {
			long times = (monsterHealth[i] + attack - 1) / attack;
			health -= times * monsterAttack[i];
			max = Math.max(max, monsterAttack[i]);
		}
		return max + health >= 1;
	}
}

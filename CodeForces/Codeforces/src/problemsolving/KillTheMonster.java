package problemsolving;

import java.util.Scanner;

public class KillTheMonster {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long leaderHealth = sc.nextLong();
			long leaderDefence = sc.nextLong();
			long monsterHealth = sc.nextLong();
			long monsterDefence = sc.nextLong();
			long coin = sc.nextLong();
			long upgradeDefence = sc.nextLong();
			long upgradeHealth = sc.nextLong();
			System.out.println(canWin(leaderHealth, leaderDefence, monsterHealth, monsterDefence, coin, upgradeHealth,
					upgradeDefence) ? "YES" : "NO");
		}
	}

	private static boolean canWin(long leaderHealth, long leaderDefence, long monsterHealth, long monsterDefence,
			long coin, long upgradeHealth, long upgradeDefence) {
		for (int i = 0; i <= coin; i++) {
			long newHealth = leaderHealth + (i * upgradeHealth);
			long newDefence = leaderDefence + ((coin - i) * upgradeDefence);
			long hitRatioLeader = (newHealth + monsterDefence - 1) / monsterDefence;
			long hitRatioMonster = (monsterHealth + newDefence - 1) / newDefence;
			if (hitRatioLeader >= hitRatioMonster) {
				return true;
			}
		}
		return false;
	}
}

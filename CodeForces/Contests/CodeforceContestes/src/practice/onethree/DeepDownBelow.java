/**
 * @author rohithvazhathody
 * @date 3 Apr 2026
 * Project: CodeforceContestes
 * File: DeepDownBelow.java
 */

package practice.onethree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 */
public class DeepDownBelow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int caves = sc.nextInt();
			List<int[]> monsters = new ArrayList<>();
			for (int cave = 0; cave < caves; cave++) {
				int monsterCount = sc.nextInt();
				int [] powers = new int [monsterCount];
				for (int count = 0; count < monsterCount; count++) {
					int val = sc.nextInt();
					int armorVal = val - count + 1;
					powers[count] = armorVal;
				}
				Arrays.sort(powers);
				monsters.add(new int [] {powers[monsterCount - 1], monsterCount});
			}
			int minPowers = findMinPowers(monsters, caves);
			System.out.println(minPowers);
		}
		sc.close();
	}

	private static int findMinPowers(List<int[]> monsters, int caves) {
		Collections.sort(monsters, (m1, m2) -> Integer.compare(m1[0], m2[0]));
		int minPowers = monsters.get(0)[0];
		int increase = monsters.get(0)[1];
		for (int index = 1; index < caves; index++) {
			minPowers = Math.max(minPowers, monsters.get(index)[0] - increase);
			increase += monsters.get(index)[1];
		}
		return minPowers;
	}

}

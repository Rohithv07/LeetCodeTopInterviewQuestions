package contests;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rohithvazhathody 14-Jun-2025
 */
public class Monsters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int numberOfMonsters = sc.nextInt();
			int power = sc.nextInt();
			int[] monsterPower = new int[numberOfMonsters];
			for (int index = 0; index < numberOfMonsters; index++) {
				int val = sc.nextInt();
				monsterPower[index] = val % power == 0 ? power : val % power;
			}
			Pair[] monsterPair = new Pair[numberOfMonsters];
			for (int index = 0; index < numberOfMonsters; index++) {
				monsterPair[index] = new Pair(monsterPower[index], index);
			}
			Arrays.sort(monsterPair, (p1, p2) -> {
				if (p1.value == p2.value) {
					return Integer.compare(p1.index, p2.index);
				}
				return Integer.compare(p2.value, p1.value);
			});
			for (Pair pair : monsterPair) {
				System.out.print(pair.index + 1 + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}

class Pair {
	int value;
	int index;

	public Pair(int value, int index) {
		this.value = value;
		this.index = index;
	}
}

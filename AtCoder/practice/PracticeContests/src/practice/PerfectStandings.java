/**
 * 
 */
package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */
public class PerfectStandings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		List<Pair> result = new ArrayList<>();
		Map<Character, Integer> store = new HashMap<>();
		store.put('A', a);
		store.put('B', b);
		store.put('C', c);
		store.put('D', d);
		store.put('E', e);
		char[] problemSet = new char[5];
		problemSet[0] = 'A';
		problemSet[1] = 'B';
		problemSet[2] = 'C';
		problemSet[3] = 'D';
		problemSet[4] = 'E';
		StringBuilder sb;
		for (int i = 1; i < 32; i++) {
			sb = new StringBuilder();
			int currentScore = 0;
			for (int j = 0; j < 5; j++) {
				if ((i & (1 << j)) != 0) {
					currentScore += store.get(problemSet[j]);
					sb.append(problemSet[j]);
				}
			}
			result.add(new Pair(sb.toString(), currentScore));
		}
		result.sort((r1, r2) -> {
			if (r1.score != r2.score) {
				return Integer.compare(r2.score, r1.score);
			}
			return r1.name.compareTo(r2.name);
		});
		for (Pair p : result) {
			System.out.println(p.name);
		}
		sc.close();
	}

}

class Pair {
	String name;
	int score;

	Pair(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

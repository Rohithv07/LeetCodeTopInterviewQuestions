/**
 * @author rohithvazhathody
 * @date 4 Jun 2026
 * Project: CodeforceContestes
 * File: SmiloAndMonsters.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class SmiloAndMonsters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] monsters = new long[n];
			for (int index = 0; index < n; index++) {
				monsters[index] = fastReader.nextLong();
			}
			long minAttacks = findMinAttacks(monsters);
			System.out.println(minAttacks);
		}
	}

	private static long findMinAttacks(long[] monsters) {
		Arrays.sort(monsters);
		int length = monsters.length;
		int strongest = length - 1;
		int weakest = 0;
		long combo = 0;
		long attack = 0;
		while (weakest < strongest) {
			long needed = monsters[strongest] - combo;
			if (monsters[weakest] < needed) {
				combo += monsters[weakest];
				attack += monsters[weakest];
				weakest++;
			} else if (monsters[weakest] == needed) {
				attack += monsters[weakest]; // killing the weak
				attack++; // killing the strongest as well with combo
				weakest++;
				combo = 0;
				strongest--;
			} else {
				attack += needed;
				monsters[weakest] -= needed;
				attack++; // we are again killing the strongest
				strongest--;
				combo = 0;

			}
		}

		if (weakest == strongest) {
			long rem = monsters[weakest];

			// Option A: Just use basic attacks for all of them (costs 'rem' attacks)
			// Option B: Do 'y' basic attacks, then 1 ultimate attack.
			// We need: combo + y >= rem - y => 2y >= rem - combo => y = ceil((rem - combo)
			// / 2)

			// Integer math trick for ceiling division: (A + B - 1) / B
			long y = (rem - combo + 1) / 2;

			// Prevent negative 'y' in case combo is already massive
			y = Math.max(0, y);

			long attacksUsingUltimate = y + 1; // 'y' basic attacks + 1 ultimate

			// Add whichever strategy takes fewer attacks
			attack += Math.min(rem, attacksUsingUltimate);
		}
		return attack;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}

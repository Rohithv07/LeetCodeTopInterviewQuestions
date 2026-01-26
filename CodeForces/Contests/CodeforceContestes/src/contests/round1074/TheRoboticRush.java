/**
 * @author rohithvazhathody
 * @date 18 Jan 2026
 * Project: CodeforceContestes
 * File: TheRoboticRush.java
 */

package contests.round1074;

import java.io.*;
import java.util.*;

// this is not submitted
public class TheRoboticRush {
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
				} catch (IOException e) {
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

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			solve(sc, out);
		}
		out.flush();
	}

	private static void solve(FastReader sc, PrintWriter out) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(b);

		String gdCode = sc.next();

		ArrayList<Integer>[] leftDeath = new ArrayList[k + 1];
		ArrayList<Integer>[] rightDeath = new ArrayList[k + 1];

		for (int i = 0; i <= k; i++) {
			leftDeath[i] = new ArrayList<>();
			rightDeath[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			int pos = a[i];
			int idx = Arrays.binarySearch(b, pos);
			int insertionPoint = -idx - 1;

			if (insertionPoint > 0) {
				long dist = (long) pos - b[insertionPoint - 1];
				if (dist <= k) {
					leftDeath[(int) dist].add(i);
				}
			}

			if (insertionPoint < m) {
				long dist = (long) b[insertionPoint] - pos;
				if (dist <= k) {
					rightDeath[(int) dist].add(i);
				}
			}
		}

		boolean[] dead = new boolean[n];
		int alive = n;
		int cur = 0;
		int minCur = 0;
		int maxCur = 0;

		for (char c : gdCode.toCharArray()) {
			if (c == 'L') {
				cur--;
			} else {
				cur++;
			}

			if (cur < minCur) {
				minCur = cur;
				int dist = -minCur;
				if (dist <= k) {
					for (int robotIdx : leftDeath[dist]) {
						if (!dead[robotIdx]) {
							dead[robotIdx] = true;
							alive--;
						}
					}
				}
			} else if (cur > maxCur) {
				maxCur = cur;
				int dist = maxCur;
				if (dist <= k) {
					for (int robotIdx : rightDeath[dist]) {
						if (!dead[robotIdx]) {
							dead[robotIdx] = true;
							alive--;
						}
					}
				}
			}
			out.print(alive + " ");
		}
		out.println();
	}
}
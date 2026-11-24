/**
 * @author rohithvazhathody
 * @date 10 Nov 2026
 * Project: CodeforceContestes
 * File: EdgyTrees.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class EdgyTrees {

	private static final long MOD = (long) (1e9 + 7);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = 1;
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int k = fastReader.nextInt();
			UnionFind unionFind = new UnionFind(n);
			for (int node = 1; node < n; node++) {
				int u = fastReader.nextInt();
				int v = fastReader.nextInt();
				int color = fastReader.nextInt();
				// only consider red, and we can substract this from the total
				if (color == 0) {
					unionFind.union(u, v);
				}
			}
			long totalSeq = power(n, k);
			long bad = 0;
			for (int i = 1; i <= n; i++) {
				if (unionFind.parent[i] == i) {
					bad = (bad + power(unionFind.size[i], k)) % MOD;
				}
			}

			out.println((totalSeq - bad + MOD) % MOD);
		}
		out.flush();
		out.close();
	}

	static long power(long base, long exp) {
		long res = 1;
		base %= MOD;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				res = (res * base) % MOD;
			}
			base = (base * base) % MOD;
			exp >>= 1;
		}
		return res;
	}

	static class UnionFind {
		int[] parent;
		int[] size;

		public UnionFind(int n) {
			parent = new int[n + 1];
			size = new int[n + 1];
			for (int index = 0; index <= n; index++) {
				parent[index] = index;
				size[index] = 1;
			}
		}

		public int find(int p) {
			if (p != parent[p]) {
				parent[p] = find(parent[p]);
			}
			return parent[p];
		}

		public void union(int p1, int p2) {
			int root1 = find(p1);
			int root2 = find(p2);
			if (root1 == root2) {
				return;
			}
			if (size[root1] < size[root2]) {
				parent[root1] = root2;
				size[root2] += size[root1];
			} else {
				parent[root2] = root1;
				size[root1] += size[root2];
			}
		}

		public boolean isConnected(int p1, int p2) {
			return find(p1) == find(p2);
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return st.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}

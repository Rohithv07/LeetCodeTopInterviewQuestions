/**
 * @author rohithvazhathody
 * @date 18 Jul 2026
 * Project: CodeforceContestes
 * File: ThirteethLabourOfHeracles.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class ThirteethLabourOfHeracles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] weight = new long[n + 1];
			for (int index = 1; index <= n; index++) {
				weight[index] = fastReader.nextLong();
			}
			int[] degree = new int[n + 1];
			for (int index = 0; index + 1 < n; index++) {
				int u = fastReader.nextInt();
				int v = fastReader.nextInt();
				degree[u]++;
				degree[v]++;
			}
			long[] maximalColoring = findMaxColoring(weight, degree);
			for (long num : maximalColoring) {
				out.print(num + " ");
			}
			out.println();
		}
		out.flush();
		out.close();
	}

	private static long[] findMaxColoring(long[] weight, int[] degree) {
		int length = weight.length - 1;
		long currentSum = Arrays.stream(weight).sum();
		long[] extra = new long[length - 2];
		int index = 0;
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j < degree[i]; j++) {
				extra[index++] = weight[i];
			}
		}
		Arrays.sort(extra);
		long[] result = new long[length - 1];
		result[0] = currentSum;
		int next = 1;
		for (index = length - 3; index >= 0; index--) {
			currentSum += extra[index];
			result[next++] = currentSum;
		}
		return result;
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

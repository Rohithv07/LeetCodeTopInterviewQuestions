/**
 * @author rohithvazhathody
 * @date 8 Aug 2026
 * Project: CodeforceContestes
 * File: IncDecXor.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 */
public class IncDecXor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fastReader.nextInt();
		int q = fastReader.nextInt();
		int[][] queries = new int[q][2];
		for (int index = 0; index < q; index++) {
			queries[index][0] = fastReader.nextInt();
			if (queries[index][0] == 1)
				queries[index][1] = fastReader.nextInt();
		}
		int[] result = findXOR(n, queries);
		for (int num : result) {
			out.println(num + " ");
		}
		out.flush();
		out.close();
	}

	private static int[] findXOR(int n, int[][] queries) {
		int q = queries.length;
		int[] result = new int[q];
		int[] nums = new int[n];
		int totalXor = 0;
		int queryIndex = 0;
		Set<Integer> track = new HashSet<>();
		for (int[] query : queries) {
			int operation = query[0];
			if (operation == 1) {
				int index = query[1] - 1;
				totalXor ^= nums[index];
				nums[index] += 1;
				totalXor ^= nums[index];
				track.add(index);
			} else {
				List<Integer> remove = new ArrayList<>();
				for (int val : track) {
					totalXor ^= nums[val];
					nums[val]--;
					totalXor ^= nums[val];
					if (nums[val] == 0) {
						remove.add(val);
					}
				}
				for (int val : remove) {
					track.remove(val);
				}
			}
			result[queryIndex++] = totalXor;
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

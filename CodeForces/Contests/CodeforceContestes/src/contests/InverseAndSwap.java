/**
 * @author rohithvazhathody
 * @date 8 Aug 2026
 * Project: CodeforceContestes
 * File: InverseAndSwap.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class InverseAndSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fastReader.nextInt();
		int q = fastReader.nextInt();
		int[] nums = new int[n + 1];
		int[] inverse = new int[n + 1];
		for (int index = 1; index <= n; index++) {
			nums[index] = fastReader.nextInt();
			inverse[nums[index]] = index;
		}
		int[] result = findResult(n, q, nums, inverse, fastReader);
		for (int index = 1; index <= n; index++) {
			int num = result[index];
			out.print(num + " ");
		}
		out.println();
		out.flush();
		out.close();
	}

	private static int[] findResult(int n, int q, int[] nums, int[] inverse, FastReader fastReader) {
		int[] sourceOfTruth = nums;
		int[] inverseTruth = inverse;
		while (q-- > 0) {
			int type = fastReader.nextInt();
			if (type == 1) {
				int val1 = fastReader.nextInt();
				int val2 = fastReader.nextInt();
				int currentMainVal1 = sourceOfTruth[val1];
				int currentMainVal2 = sourceOfTruth[val2];
				sourceOfTruth[val1] = currentMainVal2;
				sourceOfTruth[val2] = currentMainVal1;
				inverseTruth[currentMainVal2] = val1;
				inverseTruth[currentMainVal1] = val2;
			} else {
				int[] temp = sourceOfTruth;
				sourceOfTruth = inverseTruth;
				inverseTruth = temp;
			}
		}
		return sourceOfTruth;
	}

	private static void swap(int[] sourceOfTruth, int[] inverseTruth) {
		int[] temp = sourceOfTruth;
		sourceOfTruth = inverseTruth;
		inverseTruth = temp;
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

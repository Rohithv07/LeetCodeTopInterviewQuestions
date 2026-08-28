/**
 * @author rohithvazhathody
 * @date 5 Aug 2026
 * Project: CodeforceContestes
 * File: MarenolII.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class MarenolII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			String a = fastReader.next();
			String b = fastReader.next();
			long minOperation = findMinOperation(a, b);
			out.println(minOperation);
		}
		out.flush();
		out.close();
	}

	private static long findMinOperation(String a, String b) {
		if (a.equals(b)) {
			return 0;
		}
		int length = a.length();
		if (length < 3) {
			return a.equals(b) ? 0 : -1;
		}
		List<Integer> evenIndicesA = new ArrayList<>();
		List<Integer> oddIndicesA = new ArrayList<>();
		List<Integer> evenIndicesB = new ArrayList<>();
		List<Integer> oddIndicesB = new ArrayList<>();
		for (int index = 0; index < length; index++) {
			char chA = a.charAt(index);
			char chB = b.charAt(index);
			if (index % 2 == 0) {
				if (chA == '1') {
					evenIndicesA.add(index);
				}
				if (chB == '1') {
					evenIndicesB.add(index);
				}
			} else {
				if (chA == '1') {
					oddIndicesA.add(index);
				}
				if (chB == '1') {
					oddIndicesB.add(index);
				}
			}
		}
		if ((evenIndicesA.size() != evenIndicesB.size()) || (oddIndicesA.size() != oddIndicesB.size())) {
			return -1;
		}
		long result = 0;
		for (int index = 0; index < evenIndicesA.size(); index++) {
			int indexA = evenIndicesA.get(index);
			int indexB = evenIndicesB.get(index);
			result += Math.abs(indexA - indexB);
		}
		for (int index = 0; index < oddIndicesA.size(); index++) {
			int indexA = oddIndicesA.get(index);
			int indexB = oddIndicesB.get(index);
			result += Math.abs(indexA - indexB);
		}
		return result / 2;
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

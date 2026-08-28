/**
 * @author rohithvazhathody
 * @date 8 Aug 2026
 * Project: CodeforceContestes
 * File: Monocolor.java
 */

package contests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * 
 */
public class Monocolor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int n = fastReader.nextInt();
		int [] nums = new int [n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		int maxFreqNum = -1;
		int maxFreq = -1;
		for (int key : freqMap.keySet()) {
			int val = freqMap.get(key);
			if (val > maxFreq) {
				maxFreq = val;
				maxFreqNum = key;
			}
		}
		out.println(n - maxFreq);
		out.flush();
		out.close();
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

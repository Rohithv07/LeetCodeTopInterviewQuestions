/**
 * @author rohithvazhathody
 * @date 4 Jun 2026
 * Project: CodeforceContestes
 * File: Greetings.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 */
public class Greetings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[][] line = new long[n][2];
			for (int index = 0; index < n; index++) {
				line[index][0] = fastReader.nextLong();
				line[index][1] = fastReader.nextLong();
			}
			long meetingCount = findMeetingCount(line);
			System.out.println(meetingCount);
		}
	}

	private static long findMeetingCount(long[][] line) {
		int length = line.length;
		// sort by starting position
		Arrays.sort(line, (l1, l2) -> Long.compare(l1[0], l2[0]));
		long[] destination = new long[length];
		for (int index = 0; index < length; index++) {
			destination[index] = line[index][1];
		}
		long[] intermediate = new long[length];
		return countTotal(destination, intermediate, 0, length - 1);
	}

	private static long countTotal(long[] destination, long[] intermediate, int low, int high) {
		if (low >= high) {
			return 0;
		}
		long count = 0;
		int middle = low + (high - low) / 2;
		count += countTotal(destination, intermediate, low, middle);
		count += countTotal(destination, intermediate, middle + 1, high);
		count += merge(destination, intermediate, low, middle, high);
		return count;
	}

	private static long merge(long[] destination, long[] intermediate, int low, int middle, int high) {
		for (int index = low; index <= high; index++) {
			intermediate[index] = destination[index];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		long count = 0;
		while (i <= middle && j <= high) {
			long left = intermediate[i];
			long right = intermediate[j];
			if (left <= right) {
				destination[k++] = left;
				i++;
			}
			else {
				destination[k++] = right;
				count += (middle + 1 - i);
				j++;
			}
		}
		while (i <= middle) {
			destination[k++] = intermediate[i++];
		}
		return count;
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

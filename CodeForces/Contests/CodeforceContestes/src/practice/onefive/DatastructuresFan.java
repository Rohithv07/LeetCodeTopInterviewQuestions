/**
 * @author rohithvazhathody
 * @date 6 Jun 2026
 * Project: CodeforceContestes
 * File: DatastructuresFan.java
 */

package practice.onefive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class DatastructuresFan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int[] nums = new int[n + 1];
			for (int index = 1; index <= n; index++) {
				nums[index] = fastReader.nextInt();
			}
			String s = fastReader.next();
			List<Integer> result = findQueryResult(nums, s, fastReader);
			for (Integer val : result) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	private static List<Integer> findQueryResult(int[] nums, String s, FastReader fastReader) {
		int length = nums.length - 1;
		int xr0 = 0;
		int xr1 = 0;
		int[] prefix = new int[length + 1];
		List<Integer> result = new ArrayList<>();
		for (int index = 1; index <= length; index++) {
			char ch = s.charAt(index - 1);
			if (ch == '1') {
				xr1 ^= nums[index];
			} else {
				xr0 ^= nums[index];
			}
			prefix[index] = prefix[index - 1] ^ nums[index];
		}
		int query = fastReader.nextInt();
		while (query-- > 0) {
			int type = fastReader.nextInt();
			if (type == 1) {
				int l = fastReader.nextInt();
				int r = fastReader.nextInt();
				int rangeXOR = prefix[r] ^ prefix[l - 1];
				xr0 ^= rangeXOR;
				xr1 ^= rangeXOR;
			} else {
				int g = fastReader.nextInt();
				result.add(g == 0 ? xr0 : xr1);
			}
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

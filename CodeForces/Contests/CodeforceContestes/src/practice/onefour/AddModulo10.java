/**
 * @author rohithvazhathody
 * @date 2 May 2026
 * Project: CodeforceContestes
 * File: AddModulo10.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 */
public class AddModulo10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			long[] nums = new long[n];
			for (int index = 0; index < n; index++) {
				nums[index] = fastReader.nextLong();
			}
			String isEqual = findIfEqual(nums);
			System.out.println(isEqual);
		}
	}

	private static String findIfEqual(long[] nums) {
		// first convert all odd to even by doing a single opperation
		int length = nums.length;
		boolean hasAllZero = true;
		for (int index = 0; index < length; index++) {
			long currentNum = nums[index];
			if (currentNum % 2 == 1) {
				long nextNum = currentNum + (currentNum % 10);
				nums[index] = nextNum;
			}
		}
		// no we may have 0,2,4,6,8
		// if all are zero, then all numbers must be equal else no
		for (int index = 0; index < length; index++) {
			long currentNum = nums[index];
			if (currentNum % 10 != 0) {
				hasAllZero = false;
				break;
			}
		}
		// if all has zero, then check if all elements are equal
		if (hasAllZero) {
			for (int index = 1; index < length; index++) {
				if (nums[index] != nums[index - 1]) {
					return "NO";
				}
			}
			return "YES";
		}
		// make the elements to a common remainder 2 or 4 or 6 or 8 as per our wish,
		// here making it as 2
		for (int index = 0; index < length; index++) {
			long currentNum = nums[index];
			while (currentNum % 10 != 2 && currentNum % 10 != 0) {
				currentNum = (currentNum + (currentNum % 10));
			}
			nums[index] = currentNum;
		}
		// now see if all have same remainder when divided by 20 becuase in one cycle we
		// increase ai by 20 (2 + 4 + 6 + 8)
		long currentRemainder = nums[0] % 20;
		for (int index = 1; index < length; index++) {
			long currentNum = nums[index];
			if (currentNum % 20 != currentRemainder) {
				return "NO";
			}
		}
		return "YES";
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		public String next() {
			try {
				while (st == null || !st.hasMoreElements()) {
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

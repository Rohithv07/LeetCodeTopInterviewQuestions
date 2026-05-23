/**
 * @author rohithvazhathody
 * @date 30 Apr 2026
 * Project: CodeforceContestes
 * File: BracketColoring.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class BracketColoring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			String s = fastReader.next();
			List<Integer> possible = findColoring(s);
			System.out.println(possible.get(0));
			if (possible.size() > 1) {
				for (int index = 1; index < possible.size(); index++) {
					System.out.print(possible.get(index) + " ");
				}
				System.out.println();
			}
		}
	}

	private static List<Integer> findColoring(String s) {
		List<Integer> result = new ArrayList<>();
		int opening = 0;
		int closing = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				opening++;
			} else {
				closing++;
			}
		}
		if (opening != closing) {
			result.add(-1);
			return result;
		}
		List<Integer> color = new ArrayList<>();
		boolean has1Used = false;
		boolean has2Used = false;
		int balance = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				if (balance >= 0) {
					color.add(1);
					has1Used = true;
					balance++;
				} else {
					color.add(2);
					has2Used = true;
					balance++;
				}
			} else {
				if (balance > 0) {
					color.add(1);
					has1Used = true;
					balance--;
				} else {
					color.add(2);
					has2Used = true;
					balance--;
				}
			}
		}
		if (has1Used && has2Used) {
			result.add(2);
			result.addAll(color);
		}
		else {
			result.add(1);
			for (int index = 0; index < s.length(); index++) {
				result.add(1);
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

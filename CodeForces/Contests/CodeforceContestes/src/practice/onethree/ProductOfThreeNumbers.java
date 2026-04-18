/**
 * @author rohithvazhathody
 * @date 18 Apr 2026
 * Project: CodeforceContestes
 * File: ProductOfThreeNumbers.java
 */

package practice.onethree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 */
public class ProductOfThreeNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			List<Integer> product = findProduct(n);
			if (product == null || product.size() < 3) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
				System.out.println(product.get(0) + " " + product.get(1) + " " + product.get(2));
			}
		}
	}

	private static List<Integer> findProduct(int n) {
		Set<Integer> visited = new HashSet<>();
		for (int num = 2; num * num <= n; num++) {
			if (n % num == 0) {
				visited.add(num);
				n /= num;
				if (visited.size() == 2) {
					break;
				}
				// product *= num;
			}
		}
		if (n == 1 || visited.size() < 2 || visited.contains(n)) {
			return null;
		}
		visited.add(n);
		return new ArrayList<>(visited);
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

/**
 * @author rohithvazhathody
 * @date 30 May 2026
 * Project: CodeforceContestes
 * File: LostNumbers.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 
 */
public class LostNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int [] result = new int [6];
		List<Integer> special = new ArrayList<>(Arrays.asList(4, 8, 15, 16, 23, 42));
		Map<Integer, int []> productPair = new HashMap<>();
		for (int index1 = 0; index1 < 6; index1++) {
			for (int index2 = index1 + 1; index2 < 6; index2++) {
				int product = special.get(index1) * special.get(index2);
				productPair.put(product, new int [] {special.get(index1), special.get(index2)});
			}
		}
		int[] p1 = productPair.get(query(fastReader, 0, 1)); 
		int[] p2 = productPair.get(query(fastReader, 1, 2)); 
		
		result[1] = common(p1, p2); 
		result[0] = other(p1, result[1]); 
		result[2] = other(p2, result[1]); 

		p1 = productPair.get(query(fastReader, 3, 4)); 
		p2 = productPair.get(query(fastReader, 4, 5)); 
		result[4] = common(p1, p2); 
		result[3] = other(p1, result[4]); 
		result[5] = other(p2, result[4]); 
		
		System.out.print("! "); 
		for (int x : result) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.flush();
		
	}
	
	public static int query(FastReader in, int i, int j) {
		System.out.println("? " + (i + 1) + " " + (j + 1)); // ask product of a[i] and a[j]
		System.out.flush(); // ensure the judge receives the query
		return in.nextInt(); // read product a[i] * a[j]
	}

	public static int common(int[] a, int[] b) { // return the shared element between two pairs
		return (a[0] == b[0] || a[0] == b[1]) ? a[0] : a[1];
	}

	public static int other(int[] p, int a) { // return the other value in the pair given one of them
		return p[0] == a ? p[1] : p[0];
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

/**
 * @author rohithvazhathody
 * @date 31 May 2026
 * Project: CodeforceContestes
 * File: Queen.java
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
public class Queen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		List<List<Integer>> graph = new ArrayList<>();
		for (int index = 0; index < n; index++) {
			graph.add(new ArrayList<>());
		}
		boolean [] good = new boolean [n];
		for (int index = 0; index < n; index++) {
			int node = fastReader.nextInt();
			int goodOrBad = fastReader.nextInt();
			good[index] = goodOrBad == 1;
			if (node != -1) {
				graph.get(node - 1).add(index);
			}
		}
		boolean anyNodeFoundToDelete = false;
		for (int index = 0; index < n; index++) {
			if (!good[index]) {
				continue;
			}
			boolean notFound = true;
			List<Integer> children = graph.get(index);
			for (Integer child : children) {
				if (!good[child]) {
					notFound = false;
					break;
				}
			}
			if (notFound) {
				if (anyNodeFoundToDelete) {
					System.out.print(" ");
				}
				System.out.print(index + 1);
				anyNodeFoundToDelete = true;
			}
		}
		if (!anyNodeFoundToDelete) {
			System.out.println("-1");
		}
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

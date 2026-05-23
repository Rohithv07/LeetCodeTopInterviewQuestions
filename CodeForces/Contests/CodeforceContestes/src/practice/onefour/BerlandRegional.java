/**
 * @author rohithvazhathody
 * @date 4 May 2026
 * Project: CodeforceContestes
 * File: BerlandRegional.java
 */

package practice.onefour;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class BerlandRegional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int test = fastReader.nextInt();
		while (test-- > 0) {
			int n = fastReader.nextInt();
			int [] university = new int [n];
			int [] skill = new int [n];
			for (int index = 0; index < n; index++) {
				university[index] = fastReader.nextInt();
			}
			for (int index = 0; index < n; index++) {
				skill[index] = fastReader.nextInt();
			}
			long [] total = findTotalSkill(skill, university);
			for (long val : total) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	private static long[] findTotalSkill(int[] skill, int[] university) {
		int length = skill.length;
		long [] result = new long [length];
		List<List<Integer>> skillList = new ArrayList<>();
		for (int index = 0; index < length; index++) {
			skillList.add(new ArrayList<>());
		}
		for (int index = 0; index < length; index++) {
			skillList.get(university[index] - 1).add(skill[index]);
		}
		for (List<Integer> eachSkill : skillList) {
			Collections.sort(eachSkill, Collections.reverseOrder());
		}
		List<List<Long>> prefixSum = new ArrayList<>();
		for (int index = 0; index < length; index++) {
			prefixSum.add(new ArrayList<>());
		}
		for (int index = 0; index < length; index++) {
			List<Integer> currentSkill = skillList.get(index);
			for (int next = 0; next < currentSkill.size(); next++) {
				if (next == 0) {
					prefixSum.get(index).add((long)currentSkill.get(next));
				}
				else {
					prefixSum.get(index).add(prefixSum.get(index).get(next - 1) + currentSkill.get(next));
				}
			}
		}
		for (int index = 0; index < length; index++) {
			List<Integer> currentSkill = skillList.get(index);
			if (currentSkill == null || currentSkill.size() == 0) {
				continue;
			}
			else {
				int size = currentSkill.size();
				for (int k = 1; k <= size; k++) {
					int usableStudents = (size / k) * k; 
					if (usableStudents > 0) {
						result[k - 1] += prefixSum.get(index).get(usableStudents - 1); 
					}
				}
			}
		}
		//System.out.println(prefixSum);
		return result;
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

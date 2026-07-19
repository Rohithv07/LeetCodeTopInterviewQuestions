/**
 * @author rohithvazhathody
 * @date 13 Jun 2026
 * Project: CodeforceContestes
 * File: RMQSQ.java
 */

package AdvancedAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 */
public class RMQSQ {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		int[] nums = new int[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextInt();
		}
		int query = fastReader.nextInt();
		int[][] queries = new int[query][2];
		for (int index = 0; index < query; index++) {
			queries[index][0] = fastReader.nextInt();
			queries[index][1] = fastReader.nextInt();
		}
		List<Integer> minList = findMinList(nums, queries);
		for (int min : minList) {
			System.out.println(min);
		}
	}

	private static List<Integer> findMinList(int[] nums, int[][] queries) {
		List<Integer> result = new ArrayList<>();
		SegmentTree segmentTree = new SegmentTree(nums);
		segmentTree.buildTree(1, 0, nums.length - 1);
		for (int[] query : queries) {
			int minValue = segmentTree.getMin(1, 0, nums.length - 1, query[0], query[1]);
			result.add(minValue);
		}
		return result;
	}

	static class SegmentTree {
		int[] segment;
		int[] arr;

		public SegmentTree(int[] arr) {
			this.arr = arr;
			int length = arr.length;
			segment = new int[4 * length + 1];
		}

		public void buildTree(int segmentIndex, int start, int end) {
			if (start == end) {
				segment[segmentIndex] = arr[start];
				return;
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			buildTree(leftIndex, start, middle);
			buildTree(rightIndex, middle + 1, end);
			segment[segmentIndex] = Math.min(segment[leftIndex], segment[rightIndex]);
		}

		public int getMin(int segmentIndex, int start, int end, int queryStart, int queryEnd) {
			// completely outside
			if (queryStart > end || queryEnd < start) {
				return Integer.MAX_VALUE;
			}
			// completely inside
			if (queryStart <= start && end <= queryEnd) {
				return segment[segmentIndex];
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			int leftMin = getMin(leftIndex, start, middle, queryStart, queryEnd);
			int rightMin = getMin(rightIndex, middle + 1, end, queryStart, queryEnd);
			return Math.min(leftMin, rightMin);
		}
	}

	static class FastReader {
		BufferedReader bufferedReader;
		StringTokenizer st;

		public FastReader() {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(bufferedReader.readLine());
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

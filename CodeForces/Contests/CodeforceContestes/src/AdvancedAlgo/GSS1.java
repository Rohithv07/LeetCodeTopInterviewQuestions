/**
 * @author rohithvazhathody
 * @date 13 Jun 2026
 * Project: CodeforceContestes
 * File: GSS1.java
 */

package AdvancedAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 
 */
public class GSS1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader fastReader = new FastReader();
		int n = fastReader.nextInt();
		long[] nums = new long[n];
		for (int index = 0; index < n; index++) {
			nums[index] = fastReader.nextLong();
		}
		int query = fastReader.nextInt();
		findMaxSubarraySum(nums, query, fastReader);
	}

	private static void findMaxSubarraySum(long[] nums, int query, FastReader fastReader) {
		SegmentTree segmentTree = new SegmentTree(nums);
		int length = nums.length;
		segmentTree.buildTree(1, 0, length - 1);
		PrintWriter out = new PrintWriter(System.out);
		for (int index = 0; index < query; index++) {
			SegmentNode resultNode = segmentTree.query(1, 0, length - 1, fastReader.nextInt() - 1,
					fastReader.nextInt() - 1);
			out.println(resultNode.maxSum);
		}
		out.flush();
		out.close();
	}

	static class SegmentNode {
		long totalSum;
		long maxPrefixSum;
		long maxSuffixSum;
		long maxSum;

		public SegmentNode(long val) {
			totalSum = val;
			maxPrefixSum = val;
			maxSuffixSum = val;
			maxSum = val;
		}

		public SegmentNode() {

		}
	}

	static class SegmentTree {
		long[] arr;
		SegmentNode[] segmentNode;

		public SegmentTree(long[] arr) {
			this.arr = arr;
			int length = arr.length;
			segmentNode = new SegmentNode[4 * length + 1];
		}

		public void buildTree(int segmentIndex, int start, int end) {
			if (start == end) {
				segmentNode[segmentIndex] = new SegmentNode(arr[start]);
				return;
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			buildTree(leftIndex, start, middle);
			buildTree(rightIndex, middle + 1, end);
			segmentNode[segmentIndex] = mergeSegmentNode(segmentNode[leftIndex], segmentNode[rightIndex]);
		}

		public SegmentNode query(int segmentIndex, int start, int end, int queryStart, int queryEnd) {
			// completely outside
			if (queryStart > end || queryEnd < start) {
				return null;
			}
			// completely inside
			if (queryStart <= start && end <= queryEnd) {
				return segmentNode[segmentIndex];
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			SegmentNode leftNode = query(leftIndex, start, middle, queryStart, queryEnd);
			SegmentNode rightNode = query(rightIndex, middle + 1, end, queryStart, queryEnd);
			return mergeSegmentNode(leftNode, rightNode);
		}

		private SegmentNode mergeSegmentNode(SegmentNode leftNode, SegmentNode rightNode) {
			if (leftNode == null) {
				return rightNode;
			}
			if (rightNode == null) {
				return leftNode;
			}
			SegmentNode parentNode = new SegmentNode();
			parentNode.totalSum = leftNode.totalSum + rightNode.totalSum;
			parentNode.maxPrefixSum = Math.max(leftNode.maxPrefixSum, leftNode.totalSum + rightNode.maxPrefixSum);
			parentNode.maxSuffixSum = Math.max(rightNode.maxSuffixSum, rightNode.totalSum + leftNode.maxSuffixSum);
			long combinedMax = leftNode.maxSuffixSum + rightNode.maxPrefixSum;
			parentNode.maxSum = Math.max(leftNode.maxSum, Math.max(rightNode.maxSum, combinedMax));
			return parentNode;
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

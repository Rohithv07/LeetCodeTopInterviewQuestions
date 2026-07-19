/**
 * @author rohithvazhathody
 * @date 11 Jun 2026
 * Project: CodeforceContestes
 * File: SegmentTreeBuildAndQuery.java
 */

package AdvancedAlgo;

/**
 * 
 */
public class SegmentTreeBuildAndQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	static class SegmentTree {
		int[] segment;
		int[] arr;

		public SegmentTree(int n, int[] arr) {
			segment = new int[4 * n + 1];
			this.arr = arr;
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
			// current index will be min(leftChild which is 2 * middle index and rightChild
			// which is 2 * middle + 1 index)
			segment[segmentIndex] = Math.min(segment[leftIndex], segment[rightIndex]);
		}

		public int query(int segmentIndex, int start, int end, int low, int high) {
			// case 1 : completely outside
			if (low > end || high < start) {
				return Integer.MAX_VALUE;
			}
			// case 2 : completely inside
			if (low <= start && end <= high) {
				return segment[segmentIndex];
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			int leftMin = query(leftIndex, start, middle, low, high);
			int rightMin = query(rightIndex, middle + 1, end, low, high);
			return Math.min(leftMin, rightMin);
		}
	}

}

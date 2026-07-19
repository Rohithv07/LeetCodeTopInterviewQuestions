/**
 * @author rohithvazhathody
 * @date 14 Jun 2026
 * Project: CodeforceContestes
 * File: SegmentTreePointUpdate.java
 */

package AdvancedAlgo;

/**
 * 
 */
public class SegmentTreePointUpdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	static class SegmentTree {
		int [] arr;
		int [] segment;
		
		public SegmentTree(int [] arr) {
			this.arr = arr;
			int length = arr.length;
			segment = new int [4 * length + 1];
		}
		
		public void build(int segmentIndex, int start, int end) {
			if (start == end) {
				segment[segmentIndex] = arr[start];
				return;
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			build(leftIndex, start, middle);
			build(rightIndex, middle + 1, end);
			segment[segmentIndex] = Math.min(segment[leftIndex], segment[rightIndex]);
		}
		
		public int getMin(int segmentIndex, int start, int end, int queryStart, int queryEnd) {
			// completely outside
			if (queryEnd < start || queryStart > end) {
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
		
		public void pointUpdate(int segmentIndex, int start, int end, int queryIndex, int newValue) {
			if (start == end) {
				arr[start] = newValue;
				segment[segmentIndex] = arr[start];
				return;
			}
			int middle = start + (end - start) / 2;
			int leftIndex = 2 * segmentIndex;
			int rightIndex = 2 * segmentIndex + 1;
			if (queryIndex <= middle) {
				pointUpdate(leftIndex, start, middle, queryIndex, newValue);
			}
			else {
				pointUpdate(rightIndex, middle + 1, end, queryIndex, newValue);
			}
			segment[segmentIndex] = Math.min(segment[leftIndex], segment[rightIndex]);
		}
	}

}

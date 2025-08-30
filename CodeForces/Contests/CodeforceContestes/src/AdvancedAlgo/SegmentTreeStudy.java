package AdvancedAlgo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 16-Aug-2025
 */
public class SegmentTreeStudy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int index = 0; index < n; index++) {
			nums[index] = sc.nextInt();
		}
		SegmentTreeStudyImpl segmentTreeStudyImpl = new SegmentTreeStudyImpl(nums);
		segmentTreeStudyImpl.buildSegmentTree(0, 0, n - 1);
		int queryCount = sc.nextInt();
		while (queryCount-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int maxInRange = segmentTreeStudyImpl.findQueryResult(0, 0, n - 1, l, r);
			System.out.println(maxInRange);
		}
		sc.close();
	}

}

class SegmentTreeStudyImpl {
	private int[] segmentTree;
	private int[] nums;

	public SegmentTreeStudyImpl(int[] nums) {
		int length = nums.length;
		this.nums = nums;
		segmentTree = new int[4 * length];
	}

	public int findQueryResult(int currentIndex, int low, int high, int l, int r) {
		if (low >= l && high <= r) {
			return segmentTree[currentIndex];
		}
		if (low > r || high < l) {
			return Integer.MIN_VALUE;
		}
		int middle = low + (high - low) / 2;
		int leftIndex = 2 * currentIndex + 1;
		int rightIndex = 2 * currentIndex + 2;
		int leftMaxValue = findQueryResult(leftIndex, low, middle, l, r);
		int rightMaxValue = findQueryResult(rightIndex, middle + 1, high, l, r);
		return Math.max(leftMaxValue, rightMaxValue);
	}

	public void buildSegmentTree(int currentIndex, int low, int high) {
		if (low == high) {
			segmentTree[currentIndex] = nums[low];
			return;
		}
		int middle = low + (high - low) / 2;
		int leftIndex = 2 * currentIndex + 1;
		int rightIndex = 2 * currentIndex + 2;
		buildSegmentTree(leftIndex, low, middle);
		buildSegmentTree(rightIndex, middle + 1, high);
		segmentTree[currentIndex] = Math.max(segmentTree[leftIndex], segmentTree[rightIndex]);
	}
}

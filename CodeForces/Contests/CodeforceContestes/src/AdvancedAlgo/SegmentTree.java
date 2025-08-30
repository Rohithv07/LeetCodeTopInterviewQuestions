package AdvancedAlgo;

import java.util.Scanner;

/**
 * @author rohithvazhathody 16-Aug-2025
 */
public class SegmentTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int index = 0; index < size; index++) {
			nums[index] = sc.nextInt();
		}
		SegmentTreeImpl segmentTreeImpl = new SegmentTreeImpl(nums);
		segmentTreeImpl.build(0, 0, size - 1);
		int queryCount = sc.nextInt();
		while (queryCount-- > 0) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			System.out.println(segmentTreeImpl.query(0, 0, size - 1, l, r));
			System.out.println(segmentTreeImpl.querySum(0, 0, size - 1, l, r));
		}
		sc.close();
	}

}

class SegmentTreeImpl {
	private int[] segmentTree;
	private int[] nums;
	private int[] lazyNode;

	public SegmentTreeImpl(int[] nums) {
		this.nums = nums;
		segmentTree = new int[4 * nums.length];
		lazyNode = new int[4 * nums.length];
	}

	/**
	 * 3 possibilites we have 1. If it is completely lying in the range, then return
	 * that index value 2. If is is completely outside the range, then return very
	 * small value 3. If it overlaps, then traverse both left and right side of the
	 * segment tree
	 * 
	 * @param index
	 * @param low
	 * @param high
	 * @param l
	 * @param r
	 * @return
	 */
	public int query(int index, int low, int high, int l, int r) {
		if (low >= l && high <= r) {
			return segmentTree[index];
		}
		if (high < l || low > r) {
			return Integer.MIN_VALUE;
		}
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		int middle = low + (high - low) / 2;
		int left = query(leftIndex, low, middle, l, r);
		int right = query(rightIndex, middle + 1, high, l, r);
		return Math.max(left, right);
	}

	public int querySum(int currentIndex, int low, int high, int l, int r) {
		if (low >= l && high <= r) {
			return segmentTree[currentIndex];
		}
		if (high < l || low > r) {
			return 0;
		}
		int middle = low + (high - low) / 2;
		int leftIndex = 2 * currentIndex + 1;
		int rightIndex = 2 * currentIndex + 2;
		int leftSum = querySum(leftIndex, low, middle, l, r);
		int rightSum = querySum(rightIndex, middle + 1, high, l, r);
		return leftSum + rightSum;
	}

	/**
	 * This is applicable for range sum. For range max, we can just set the lazy
	 * value instead of any addition
	 * 
	 * @param index
	 * @param low
	 * @param high
	 * @param l
	 * @param r
	 * @param value
	 */
	public void lazyRangeUpdate(int index, int low, int high, int l, int r, int value) {
		// if there is elements in the lazy node
		if (lazyNode[index] != 0) {
			segmentTree[index] += (high - low + 1) * lazyNode[index];
			if (low != high) {
				// if not needed, update the lazy for the child
				int leftIndex = 2 * index + 1;
				int rightIndex = 2 * index + 2;
				lazyNode[leftIndex] += lazyNode[index];
				lazyNode[rightIndex] += lazyNode[index];
			}
			lazyNode[index] = 0;

		}
		// completely outisde
		if (r < low || l > high || low > high) {
			return;
		}
		// inside our range
		if (low >= l && high <= r) {
			segmentTree[index] += (high - low + 1) * value;
			if (low != high) {
				int leftIndex = 2 * index + 1;
				int rightIndex = 2 * index + 2;
				lazyNode[leftIndex] += value;
				lazyNode[rightIndex] += value;
			}
			return;
		}
		// overlaps, then explore both side
		int middle = low + (high - low) / 2;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		lazyRangeUpdate(leftIndex, low, middle, l, r, value);
		lazyRangeUpdate(rightIndex, middle + 1, high, l, r, value);
		segmentTree[index] = segmentTree[leftIndex] + segmentTree[rightIndex];

	}

	public int querySumRange(int index, int low, int high, int l, int r, int value) {
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		if (lazyNode[index] != 0) {
			segmentTree[index] += (high - low + 1) * lazyNode[index];
			if (low != high) {
				lazyNode[leftIndex] += lazyNode[index];
				lazyNode[rightIndex] += lazyNode[index];
			}
			lazyNode[index] = 0;
		}
		// outisde right
		if (low > r || high < l) {
			return 0;
		}
		// inside range
		if (low >= l && high <= r) {
			return segmentTree[index];
		}
		int middle = low + (high - low) / 2;
		int leftSum = querySumRange(leftIndex, low, middle, l, r, value);
		int rightSum = querySumRange(rightIndex, middle + 1, high, l, r, value);
		return leftSum + rightSum;
	}

	/**
	 * Point update is if we need to update a single value and not range
	 * 
	 * @param index
	 * @param low
	 * @param high
	 * @param node
	 * @param value
	 */
	public void pointUpdate(int index, int low, int high, int node, int value) {
		if (low == high) {
			segmentTree[index] += value;
			return;
		}
		int middle = low + (high - low) / 2;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		if (node <= middle && node >= low) {
			// in left half
			pointUpdate(leftIndex, low, middle, node, value);
		} else {
			// in the right half
			pointUpdate(rightIndex, middle + 1, high, node, value);
		}
		segmentTree[index] = segmentTree[leftIndex] + segmentTree[rightIndex];
	}

	public void build(int index, int low, int high) {
		if (low == high) {
			segmentTree[index] = nums[low];
			return;
		}
		int middle = low + (high - low) / 2;
		int leftIndex = 2 * index + 1;
		int rightIndex = 2 * index + 2;
		build(leftIndex, low, middle);
		build(rightIndex, middle + 1, high);
		segmentTree[index] = Math.max(segmentTree[leftIndex], segmentTree[rightIndex]);
		// if this is for sum, then it should be built as segmentTree[index] =
		// segmentTree[leftIndex] + segmentTree[rightIndex]
	}
}

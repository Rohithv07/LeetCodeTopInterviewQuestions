/**
 * @author rohithvazhathody
 * @date 14 Feb 2026
 * Project: CodeforceContestes
 * File: SegTreeOops.java
 */

package AdvancedAlgo;

/**
 * 
 */
public class SegTreeOops {
	int leftMost;
	int rightMost;
	SegTreeOops lChild;
	SegTreeOops rChild;
	int sum;

	public SegTreeOops(int leftMost, int rightMost, int[] a) {
		this.leftMost = leftMost;
		this.rightMost = rightMost;
		if (leftMost == rightMost) {
			sum = a[leftMost];
		} else {
			int middle = leftMost + (rightMost - leftMost) / 2;
			lChild = new SegTreeOops(leftMost, middle, a);
			rChild = new SegTreeOops(middle + 1, rightMost, a);
			recalculate();
		}
	}

	public void recalculate() {
		if (leftMost == rightMost) {
			return;
		}
		sum = lChild.sum + rChild.sum;
	}

	public void pointUpdate(int index, int newVal) {
		if (leftMost == rightMost) {
			sum = newVal;
			return;
		}
		if (index <= lChild.rightMost) {
			lChild.pointUpdate(index, newVal);
		} else {
			rChild.pointUpdate(index, newVal);
		}
		recalculate();
	}

	public int rangeSum(int left, int right) {
		// entirely separated
		if (left > rightMost || right < leftMost) {
			return 0;
		}
		// entirely covers us
		if (left <= leftMost && right >= rightMost) {
			return sum;
		}
		// we don't know, ask the child
		return lChild.rangeSum(left, right) + rChild.rangeSum(left, right);
	}
}

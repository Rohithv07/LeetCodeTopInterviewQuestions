package AdvancedAlgo;

/**
 * @author rohithvazhathody 15-Aug-2025
 */
public class FenwickTree {

	private int[] fenwickTree;

	public FenwickTree(int n) {
		fenwickTree = new int[n];
	}

	public void update(int index, int num) {
		int length = fenwickTree.length;
		while (index < length) {
			fenwickTree[index] += num;
			index = index + (index & (-index));
		}
	}

	public int findSum(int index) {
		int totalSum = 0;
		while (index > 0) {
			totalSum += fenwickTree[index];
			index = index - (index & (-index));
		}
		return totalSum;
	}

	public int findLowerBound(int num) {
		int n = fenwickTree.length - 1;
		int currentIndex = 0;
		int previousSum = 0;

		// get largest power of 2 <= n
		// here we can also compute the exponent and got through it like
		/*
		 * 
		 * for (int index = (int)(Math.log10(n) / Math.log10(2)); index >= 0; index--) {
		 * if (fenwickTree[currentIndex + (1 << index)] + previousSum < num) {
		 * currentIndex = (currentIndex + (1 << index)); previousSum +=
		 * fenwickTree[currentIndex]; } }
		 */
		int maxPow = Integer.highestOneBit(n);

		for (int step = maxPow; step > 0; step >>= 1) {
			if (currentIndex + step <= n && previousSum + fenwickTree[currentIndex + step] < num) {
				previousSum += fenwickTree[currentIndex + step];
				currentIndex += step;
			}
		}
		return currentIndex + 1;
	}

}

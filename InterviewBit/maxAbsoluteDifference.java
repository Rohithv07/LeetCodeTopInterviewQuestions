You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

For example,

A=[1, 3, -1]

f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

So, we return 5.

public class Solution {
    public int maxArr(int[] A) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i=0; i<A.length; i++) {
            max1 = Math.max(max1, A[i]+i);
            min1 = Math.min(min1, A[i]+i);
            max2 = Math.max(max2, A[i]-i);
            min2 = Math.min(min2, A[i]-i);
        }
        return Math.max(Math.abs(max1-min1), Math.abs(max2-min2));
    }
}


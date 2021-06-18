/*
You are given a list of intervals as a two dimensional matrix. Each interval contains two values, first a start time and second an end time. An interval [a, b] is “covered” by another interval [c, d] if and only if c <= a and b <= d. Given these intervals, return the count of intervals that are not covered by any other interval.

Ex: Given the following intervals…

intervals = [[1, 2], [0, 4]], return 1 ([0, 4] is the only remaining interval).
Ex: Given the following intervals…

intervals = [[8, 10], [4, 6], [1, 2]], return 3.
*/


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        int end = Integer.MIN_VALUE;
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        int count = 0;
        for (int [] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
                count += 1;
            }
        }
        // as per the above question, we only need to return count
        // here it is the answer same as non overlapping intervals in leetcode
        return intervals.length - count;
    }
}
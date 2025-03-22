/*
 * Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of the non-overlapping intervals 
 * that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

1 3  => 1 - 6
2 6  => 8 - 10
8 10 
15 18 => 15 18

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

*/

import java.util.*;

public class MergeIntervals {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int [][] interval = new int [length][2];
        for (int i = 0; i < length; i++) {
            interval[i][0] = sc.nextInt();
            interval[i][1] = sc.nextInt();
        }
        int [][] mergedInterval = findMergeInterval(interval, length);
        for (int [] merged : mergedInterval) {
            System.out.println(merged[0] + " " + merged[1]);
        }
        sc.close();
    }

    private static int [][] findMergeInterval(int [][] intervals, int length) {
        if (length == 0 || intervals == null) {
            return new int [][]{};
        }
        if (length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> {
            return Integer.compare(i1[0], i2[0]);
        });
        List<int[]> currentIntervalList = new ArrayList<>();
        int [] currentInterval = intervals[0];
        currentIntervalList.add(intervals[0]);
        for (int [] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            }
            else {
                currentInterval = interval;
                currentIntervalList.add(currentInterval);
            }
        }
        int [][] result = new int [currentIntervalList.size()][2];
        int index = 0;
        for (int [] interval : currentIntervalList) {
            result[index][0] = interval[0];
            result[index][1] = interval[1];
            index++;
        }
        return result;
    }
}


// TC : O(NLogN) + O(N) + O(resultSize)
// SC : O(N) + O(N)

























/*

class Solution {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (intervals == null || length == 0) {
            return new int [][]{};
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int []> result = new ArrayList<>();
        int [] current = new int [2];
        current[0] = intervals[0][0];
        current[1] = intervals[0][1];
        result.add(current);
        for (int [] interval : intervals) {
            int c1 = current[0];
            int c2 = current[1];
            int next1 = interval[0];
            int next2 = interval[1];
            if (c2 >= next1) {
                current[1] = Math.max(c2, next2);
            }
            else {
                current = interval;
                result.add(current);
            }
        }
        return result.toArray(new int [result.size()][2]);
    }
}
 
 */

 
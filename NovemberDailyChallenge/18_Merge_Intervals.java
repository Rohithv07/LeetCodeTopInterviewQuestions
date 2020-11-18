Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104



class Solution {
    public int[][] merge(int[][] intervals) {
        // sort based on th efirst number
        int row = intervals.length;
        if (row <= 1)
            return intervals;
        int col = intervals[0].length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> output = new ArrayList<>();
        int [] current = intervals[0];
        output.add(current); // adding the very first element
        for (int [] interval : intervals) {
            int currentBeg = current[0];
            int currentEnd = current[1];
            int nextBeg = interval[0];
            int nextEnd = interval[1];
            if (currentEnd >= nextBeg) {
                current[1] = Math.max(currentEnd, nextEnd);
            }
            else {
                current = interval;
                output.add(current);
            }
        }
        return output.toArray(new int [output.size()][]);
    }
}
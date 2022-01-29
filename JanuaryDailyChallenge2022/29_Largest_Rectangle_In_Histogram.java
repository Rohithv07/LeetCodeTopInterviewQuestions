Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104


class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int maxHeight = 0;
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<=length; i++) {
            while (!stack.isEmpty() && (i == length || heights[stack.peek()] >= heights[i])) {
                int h = heights[stack.pop()];
                int w = 0;
                if (stack.isEmpty()) {
                    w = i;
                }
                else {
                    w = i - stack.peek() - 1;
                }
                maxHeight = Math.max(maxHeight, h * w);
            }
            stack.push(i);
        }
        return maxHeight;
    }
}
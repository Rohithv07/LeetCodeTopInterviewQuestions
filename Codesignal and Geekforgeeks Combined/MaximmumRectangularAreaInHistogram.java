Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit, there will be N bars height of each bar will be given by the array arr.

Example 1:

Input:
N = 7
arr[] = {6,2,5,4,5,1,6}
Output: 12
Explanation: 


Example 2:

Input:
N = 8
arr[] = {7 2 8 9 1 3 6 5}
Output: 16
Explanation: Maximum size of the histogram 
will be 8  and there will be 2 consecutive 
histogram. And hence the area of the 
histogram will be 8x2 = 16.
Your Task:
The task is to complete the function getMaxArea() which takes the array arr[] and its size N as inputs and finds the largest rectangular area possible and returns the answer.

Expected Time Complxity : O(N)
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 106
1 ≤ arr[i] ≤ 1012



class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        if (hist == null || n == 0) {
            return 0;
        }
        long [] left = new long [(int)n];
        long [] right = new long [(int)n];
        left[0] = -1;
        right[right.length - 1] = n;
        long maxArea = 0;
        for (int i=1; i<n; i++) {
            long current = i - 1;
            while (current >= 0 && hist[(int)current] >= hist[i]) {
                current = left[(int)current];
            }
            left[i] = current;
        }
        for (int i=right.length-2; i>=0; i--) {
            long current = i + 1;
            while (current < right.length && hist[(int)current] >= hist[i]) {
                current = right[(int)current];
            }
            right[i] = current;
        }
        for (int i=0; i<(int)n; i++) {
            maxArea = Math.max(maxArea, hist[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }
        
}

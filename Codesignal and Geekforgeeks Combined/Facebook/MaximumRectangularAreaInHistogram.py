Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit.

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

class Solution:
    
    #Function to find largest rectangular area possible in a given histogram.
    def getMaxArea(self,histogram):
        #code here
        n = len(histogram)
        left = [0] * n
        right = [0] * n
        left[0] = -1
        right[n - 1] = n
        maxHeight = 0
        for i in range(1, n):
            current = i - 1
            while current >= 0 and histogram[current] >= histogram[i]:
                current = left[current]
            left[i] = current
        for i in range(n - 2, -1, -1): #decrement by 1
            current = i + 1
            while current < n and histogram[current] >= histogram[i]:
                current = right[current]
            right[i] = current
        for i in range (n):
            maxHeight = max(maxHeight, histogram[i] * (right[i] - left[i] - 1))
        return maxHeight
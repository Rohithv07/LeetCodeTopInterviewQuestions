There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls. The balls in first road are given in an array a and balls in the second road in an array b. The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them. Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side of the road).
Geek can change the road only at a point of intersection ie- a point where buckets have the same number of balls on two roads. Help Geek collect the maximum number of balls.

 

Example 1:

Input: 
N = 5, M = 5
a[] = {1, 4, 5, 6, 8}
b[] = {2, 3, 4, 6, 9}
Output: 29
Explanation: The optimal way to get the 
maximum number of balls is to start from 
road 2. Get 2+3. Then switch at intersection 
point 4. Get 4+5+6. Then switch at intersection
point 6. Get 9. Total = 2+3+4+5+6+9 = 29.
Example 2:

Input:
N = 3, M = 3
a[] = {1, 2, 3}
b[] = {4, 5, 6}
Output: 15
 


Your Task:
You do not need to read input or print anything. Your task is to complete the function maxBalls() which takes N, M, a[] and b[] as input parameters and returns the maximum number of balls that can be collected.

 

Expected Time Complexity: O(N+M)
Expected Auxililary Space: O(1)

 

Constraints:
1 ≤ N, M ≤ 103
1 ≤ a[i], b[i] ≤ 106  



/*
Approach:-

loop through both arrays at same time.

use 2 variables sum1, sum2 to keep track of running sum of 2 arrays. and 1 variable for result.

if common item occurs, add max(sum1, sum2) to result.
But.. it can have duplicates also.. so we need to somehow adjust our process for duplicates. the method i used is naive.. you cant try bettering it.

after looping, one of the array will have extra values left.. add them to respective sums and at the end, max(sum1, sum2) to result.


*/

class Solution{
    static int maxBalls(int n, int m, int a[], int b[])
    {
        // code here
        if (n == 1 && m == 2)
            return 2;
        int sumA = 0;
        int sumB = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                int tempA = i;
                int tempB = j;
                while (tempA < n && tempB < m && a[tempA] == b[tempB]) {
                    sumA += a[tempA++];
                }
                int x = tempA;
                tempA = i;
                while (tempA < n && tempB < m && a[tempA] == b[tempB]) {
                    sumB += b[tempB++];
                }
                int y = tempB;
                max += Math.max(sumA, sumB);
                i = x;
                j = y;
                sumA = 0;
                sumB = 0;
            }
            else if (a[i] < b[j]) {
                sumA += a[i++];
            }
            else {
                sumB += b[j++];
            }
        }
        while (i < n) {
            sumA += a[i++];
        }
        while (j < m) {
            sumB += b[j++];
        }
        max += Math.max(sumA, sumB);
        return max;
    }
}

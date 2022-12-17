Given a really large number N, break it into 3 whole numbers such that they sum up to the original number and find the number of ways to do so. Since this number can be very large, return it modulo 109+7. 

 

Example 1:

Input:
N = 2
Output:
6
Explanation:
Possible ways to break the number:
0 + 0 + 2 = 2 
0 + 2 + 0 = 2
2 + 0 + 0 = 2
0 + 1 + 1 = 2
1 + 1 + 0 = 2
1 + 0 + 1 = 2
 

 

Example 2:

Input:
N = 3
Output:
10
Explanation:
Possible ways to break the number:
0+0+3 = 3
0+3+0 = 3
3+0+0 = 3
0+1+2 = 3
0+2+1 = 3
1+0+2 = 3
1+2+0 = 3
2+0+1 = 3
2+1+0 = 3
1+1+1 = 3
 

 

Your Task:

You don't need to read input or print anything. Your task is to complete the function waysToBreakNumber() which takes an integer N and returns the possible ways to break the number in 3 parts.

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 109


class Solution:
    def waysToBreakNumber(self, n):
        #code here
        return ((n + 1) * (n + 2) // 2) % (10 ** 9 + 7)
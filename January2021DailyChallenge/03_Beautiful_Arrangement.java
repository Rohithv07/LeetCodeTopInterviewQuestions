Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Given an integer n, return the number of the beautiful arrangements that you can construct.

 

Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 15



class Solution {
    public int countArrangement(int n) {
        if (n == 1)
            return 1;
        int [] count = new int [1];
        int [] visited = new int [n+1];
        backtrack(n, 1, count, visited);
        return count[0];
    }
    
    public void backtrack(int n, int position, int [] count, int [] visited) {
        if (position > n) {
            count[0] += 1;
            return;
        }
        for (int i=1; i<=n; i++) {
            if (visited[i] == 0 && (i % position == 0 || position % i == 0)) {
                visited[i] = 1;
                backtrack(n, position + 1, count, visited);
                visited[i] = 0;
            }
        }
    }
}




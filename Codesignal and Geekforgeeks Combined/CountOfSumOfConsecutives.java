Given a number N, the task is find the number of ways to represent this number as a sum of 2 or more consecutive natural numbers.

 

Example 1:

Input:
N = 10
Output:
1
Explanation:
10 can be reprsented as sum of two or
more consecutive numbers in only one
way. 10 = 1+2+3+4.
Example 2:

Input:
N = 15
Output:
3
Explanation:
15 can be reprsented as sum of two or
more consecutive numbers in 3 ways.
(15 = 1+2+3+4+5); (15 = 4+5+6); (15 = 7+8).
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function getCount() which takes an Integer n as input and returns the answer.

 

Expected Time Complexity: O(sqrt(N))
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 108


//User function Template for Java

class Solution {
    static int getCount(int n) {
        // code here
        int count = 0;
        // a + a + 1 + a + 2 + .... + a + l
        // n = (L + 1)a + l * l + 1 / 2
        // /(n - (l*(l+1)/2) / (l+1) = a. Run a loop from 1 to L*(L+1)/2
        for (int l=1; (l *(l + 1) / 2) < n; l++) {
            double value = (l * (l + 1) / 2.0);
            double current = (n - value) / (l + 1);
            if (Math.ceil(current) == current)
                count += 1;
        }
        return count;
    }
}
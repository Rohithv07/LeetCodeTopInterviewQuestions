Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required. 


Example 1:

Input: N = 43
Output: 20 20 2 1
Explaination: 
Minimum number of coins and notes needed 
to make 43. 

Example 2:

Input: N = 1000
Output: 500 500
Explaination: minimum possible notes
is 2 notes of 500.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minPartition() which takes the value N as input parameter and returns a list of integers in decreasing order.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 106





// User function Template for Java

class Solution{
    static List<Integer> minPartition(int n)
    {
        // code here
        // this only works for these denominations
        // if other denominations comes up as follow up, then dp must be used
        int [] denomination = new int []{2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            for (int i = 0; i < 10; i++) {
                if (denomination[i] <= n) {
                    n -= denomination[i];
                    result.add(denomination[i]);
                    break;
                }
            }
        }
        return result;
    }
}
A number is called a stepping number if all adjacent digits have an absolute difference of 1, e.g. '321' is a Stepping Number while 421 is not. Given two integers n and m, find the count of all the stepping numbers in the range [n, m].

Example 1:

Input: n = 0, m = 21
Output: 13
Explanation: Stepping no's are 0 1 2 3 4 5
6 7 8 9 10 12 21
Example 2:

Input: n = 10, m = 15
Output: 2
Explanation: Stepping no's are 10, 12

Your Task:  
You don't need to read input or print anything. Your task is to complete the function steppingNumbers() which takes the integer n and integer m as input parameters and returns the number of stepping numbers in the range between n and m.

Expected Time Complexity: O(log(M))
Expected Auxiliary Space: O(SN) where SN is the number of stepping numbers in the range


Constraints:
0 ≤ N < M ≤ 107



//User function Template for Java

class Solution{
    int steppingNumbers(int n, int m){
        // code here
        int [] result = new int [1];
        // every single digit is a stepping number
        // so do dfs on every single digit number and then we can cover all the rest
        for (int i = 0; i < 10; i++) {
            dfsHelper(i, n, m, result);
        }
        return result[0];
    }
    
    private void dfsHelper(int num, int n, int m, int [] result) {
        if (num >= n && num <= m) {
            result[0]++;
        }
        if (num > m || num == 0) {
            return;
        }
        int lastDigit = num % 10;
        int addOne = num * 10 + lastDigit + 1;
        int subtractOne = num * 10 + lastDigit - 1;
        if (lastDigit == 0) {
            dfsHelper(addOne, n, m, result);
        }
        else if (lastDigit == 9) {
            dfsHelper(subtractOne, n, m, result);
        }
        else {
            dfsHelper(subtractOne, n, m, result);
            dfsHelper(addOne, n, m, result);
        }
    }
}

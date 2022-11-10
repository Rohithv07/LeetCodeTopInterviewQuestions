Given a number N. Find if it can be expressed as sum of two prime numbers.

Example 1:

Input: N = 34
Output: "Yes" 
Explanation: 34 can be expressed as 
sum of two prime numbers.
Example 2:

Input: N = 23
Output: "No"
Explanation: 23 cannnot be expressed as
sum of two prime numbers. 

Your Task:  
You dont need to read input or print anything. Complete the function isSumOfTwo() which takes N as input parameter and returns "Yes" if can be expressed as sum of two prime numbers. else return "No".

Expected Time Complexity: O(N*sqrt(N))
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105


//User function Template for Java
class Solution {
    static String isSumOfTwo(int n){
        // code here
        if (n <= 3) {
            return "No";
        }
        boolean [] prime = new boolean [n + 1];
        for (int i = 2; i * i < n; i++) {
            if (!prime[i]) {
                for (int j = i; j * i < n; j++) {
                    prime[i * j] = true;
                }
            }
        }
        int left = 2;
        int right = n;
        while (left <= right) {
            boolean isLeftPrime = prime[left];
            boolean isRightPrime = prime[right];
            if (!isLeftPrime && !isRightPrime) {
                int total = left + right;
                if (total > n) {
                    right--;
                }
                else if (total < n) {
                    left++;
                }
                else {
                    return "Yes";
                }
            }
            else if (!isLeftPrime) {
                right--;
            }
            else if (!isRightPrime) {
                left++;
            }
            else {
                left++;
                right--;
            }
        }
        return "No";
    }
}
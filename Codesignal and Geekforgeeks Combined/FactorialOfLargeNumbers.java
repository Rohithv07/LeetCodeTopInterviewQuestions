Given an integer N, find its factorial.

Example 1:

Input: N = 5
Output: 120
Explanation : 5! = 1*2*3*4*5 = 120
Example 2:

Input: N = 10
Output: 3628800
Explanation :
10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

Your Task:
You don't need to read input or print anything. Complete the function factorial() that takes integer N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.


Expected Time Complexity : O(N2)
Expected Auxilliary Space : O(1)


Constraints:
1 ≤ N ≤ 1000

//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int n){
        //code here
        ArrayList<Integer> result = new ArrayList<>();
        if (n <= 1) {
            result.add(1);
            return result;
        }
        result.add(1);
        for (int i=2; i<=n; i++) {
            int carry = 0;
            for (int j=0; j<result.size(); j++) {
                int temp = result.get(j) * i + carry;
                carry = temp / 10;
                result.set(j, temp % 10);
            }
            while (carry > 0) {
                result.add(carry % 10);
                carry /= 10;
            }
        }
        Collections.reverse(result);
        return result;
    }
}
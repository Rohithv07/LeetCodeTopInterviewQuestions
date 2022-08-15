A(X) for positive integer X is the sum of factorials of its digits. For example, A(154) = 1! + 5! + 4!= 145.
Given a number N, find the minimum number X such that A(X) = N. You have to return a list of digits which represent the number X.

Example 1:

Input: N = 40321
Output: 18
Explanation: A(18)=1!+ 8! =40321 
Note that A(80) and A(81) are also 
40321, But 18 is the smallest 
number.
Example 2:

Input: N = 5040
Output: 7
Explanation: A(7) = 7! = 5040.
Your Task:
You don't need to read or print anything. Your task is to complete the function FactDigit() which takes N as input parameter and returns a list of digits which represent the number X.

Expected Time Complexity: O(X) where X ≤ 106
Expected Space Complexity: O(X)

Constraints:
1 ≤ N ≤ 109




// we will be storing the factorials of first 9 numbers for quick access
// then we will start using the bigger number first and its factorials
// then we just reverse the result we got

class Solution
{
    ArrayList<Integer> FactDigit(int n)
    {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int [] fact = new int [] {1,1,2,6,24,120,720,5040, 40320, 362880};
        int starter = 9;
        while (n > 0) {
            if (n < fact[starter]) {
                starter--;
            }
            else {
                result.add(starter);
                n -= fact[starter];
            }
        }
        Collections.reverse(result);
        return result;
    }
}
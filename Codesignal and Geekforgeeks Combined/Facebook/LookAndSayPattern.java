Given an integer n. Return the nth row of the following look-and-say pattern.
1
11
21
1211
111221


Example 1:

Input:
n = 5
Output: 111221
Explanation: The 5th row of the given pattern
will be 111221.
Example 2:

Input:
n = 3
Output: 21
Explanation: The 3rd row of the given pattern
will be 21.

Your Task:  
You dont need to read input or print anything. Complete the function lookandsay() which takes integer n as input parameter and returns a string denoting the contents of the nth row of given pattern.


Expected Time Complexity: O(2n)
Expected Auxiliary Space: O(2n-1)  


Constraints:
1 ≤ n ≤ 30




class Solution{
    static String lookandsay(int n) {
        //your code here
        if (n == 1)
            return "1";
        String answer = "1";
        for (int i=2; i<=n; i++) {
            answer = helper(answer);
        }
        return answer;
    }
    
    static String helper(String answer) {
        char ch = answer.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<answer.length(); i++) {
            if (answer.charAt(i) != ch) {
                sb.append(count).append(ch);
                ch = answer.charAt(i);
                count = 1;
            }
            else {
                count += 1;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }
}
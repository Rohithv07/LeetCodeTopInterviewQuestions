Given a number k and string num of digits (0 to 9) denoting a positive integer. Find a string denoting the lowest integer number possible by removing k digits from num, without changing their order.
Note: num will not contain any leading zero.

 

Example 1:

Input:
k = 2
num = "143729"
Output: "1329"
Explanation: 1329 is the minimum number
possible after removing '4' and '7'.
 

Example 2:

Input:
k = 3
num = "10056"
Output: "0"
Explanation: 0 is the minimum number
possible after removing '1' , '5' and '6'.
 

Your Task:  
You dont need to read input or print anything. Complete the function buildLowestNumber() which accepts string num and integer k as input parameters and returns a string denoting the smallest integer possible after removing k digits from num without changing the order.


Expected Time Complexity: O(Length of num) 
Expected Auxiliary Space: O(Length of num) 


Constraints:
1 <= Length of num <= 105
0 <= k < Length of num


//User function Template for Java

class Solution {
    static String buildLowestNumber(String s, int n) {
        // code here
        Stack<Character> stack = new Stack<>();
        int removal = 0;
        for (char ch : s.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() - '0' > ch - '0' && removal < n) {
                removal++;
                stack.pop();
            }
            stack.push(ch);
        }
        while (removal < n && !stack.isEmpty()) {
            stack.pop();
            removal++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            sb.append(ch);
        }
        
        String result = sb.reverse().toString();
        int i = 0;
        while (i < result.length() && result.charAt(i) == '0') {
            i++;
        }
        if (i == result.length()) {
            return "0";
        }
        return result.substring(i);
    }
}
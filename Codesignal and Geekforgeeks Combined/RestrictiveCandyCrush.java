Given a string S and an integer K, the task is to reduce the string by applying the following operation:
Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
K = 2
S = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geegsforgeeks" -> "gksforgks"
Example 2:

Input:
K = 2
S = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
Your Task:  
You don't need to read input or print anything. Complete the function Reduced_String() which takes integer K and string S as input parameters and returns the reduced string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)

Constraints:
1 ≤ |S| ≤ 105
1 ≤ K ≤ |S|





// user made class
class Pair {
    char ch;
    int freq;
    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution
{
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        if (k == 1)
            return "";
        int count = 0;
        Stack<Pair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().freq == k) {
                char current = stack.peek().ch;
                while (!stack.isEmpty() && stack.peek().ch == current)
                    stack.pop();
            }
            if (!stack.isEmpty() && stack.peek().ch == c) {
                Pair pair = new Pair(c, stack.peek().freq + 1);
                stack.push(pair);
            }
            else {
                Pair pair = new Pair(c, 1);
                stack.push(pair);
            }
        }
        if (!stack.isEmpty() && stack.peek().freq == k) {
            char current = stack.peek().ch;
            while (!stack.isEmpty() && stack.peek().ch == current)
                stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().ch);
        }
        return sb.reverse().toString();
    }
}

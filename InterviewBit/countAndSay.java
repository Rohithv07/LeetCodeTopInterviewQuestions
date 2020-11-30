The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

public class Solution {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String answer = "1";
        for (int i=2; i<=n; i++) 
            answer = helper(answer);
        return answer;
    }
    public String helper(String s) {
        char ch = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) != ch) {
                sb.append(count).append(ch);
                ch = s.charAt(i);
                count = 1;
            }
            else
                count += 1;
        }
        sb.append(count).append(ch);
        return sb.toString();
    }
}


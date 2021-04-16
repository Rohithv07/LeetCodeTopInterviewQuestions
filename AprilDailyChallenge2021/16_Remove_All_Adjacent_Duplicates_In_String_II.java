Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.



class Pair {
    char ch;
    int count;
    
    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count += 1;
            }
            else {
                stack.push(new Pair(c, 1));
            }
            if (stack.peek().count == k) {
                stack.pop();
            }
        }
        while (!stack.isEmpty()) {
            Pair current = stack.pop();
            for (int i=0; i<current.count; i++)
                sb.append(current.ch);
        }
        return sb.reverse().toString();
    }
}

Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals required to convert the string into a balanced expression.
A reversal means changing '{' to '}' or vice-versa.

Example 1:

Input:
S = "}{{}}{{{"
Output: 3
Explanation: One way to balance is:
"{{{}}{}}". There is no balanced sequence
that can be formed in lesser reversals.
â€‹Example 2:

Input: 
S = "{{}{{{}{{}}{{"
Output: -1
Explanation: There's no way we can balance
this sequence of braces.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countRev() which takes the string S as input parameter and returns the minimum number of reversals required to balance the bracket sequence. If balancing is not possible, return -1. 

Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ |S| ≤ 105



// this is the pseudo code using stack

if(s.length()&1) return -1;
    stack<char> track;
    int ans = 0;
    for(char c: s) {
        if(track.empty()) {
            if(c == '}') ans++;
            track.push('{');
        } else {
            if(c == '}' && track.top() == '{')
                track.pop();
            else 
            track.push(c);
        }
    }
    return ans + track.size()/2;

 // but this can be easily done without using stack


class Sol
{
    int countRev (String s)
    {
        // your code here   
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() % 2 == 1) {
            return -1;
        }
        int countOfOpening = 0;
        int countOfClosing = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '{') {
                countOfOpening += 1;
            }
            else if (countOfOpening == 0 && ch == '}') {
                countOfClosing += 1;
            }
            else {
                countOfOpening -= 1;
            }
        }
        return (countOfOpening + 1)/ 2 + (countOfClosing + 1) / 2;
    }
}
Given a string containing uppercase alphabets and integer digits (from 0 to 9), the task is to print the alphabets in the lexicographical order followed by the sum of digits.

Example 1:

Input: S = "AC2BEW3"
Output: "ABCEW5"
Explanation: 2 + 3 = 5 and we print all
alphabets in the lexicographical order. 
Example 2:

Input: S = "ACCBA10D2EW30"
Output: "AABCCDEW6"
Explanation: 0+1+2+3 = 6 and we print all
alphabets in the lexicographical order. 

Your Task:  
You don't need to read input or print anything. Your task is to complete the function arrangeString() which takes the string S as inputs and returns the modified string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(26)

Constraints:
1 ≤ |S| ≤ 105
S contains only upper case alphabets and digits.


class Solution
{
    public String arrangeString(String s)
        {
            //code here.
            if (s == null || s.length() == 0) {
                return "";
            }
            int [] count = new int [26];
            int sum = 0;
            for (char ch : s.toCharArray()) {
                if (ch >= '0' && ch <= '9') {
                    sum += ch - '0';
                }
                else {
                    count[ch - 'A'] += 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<26; i++) {
                int currentCount = count[i];
                if (currentCount > 0) {
                    while (currentCount -- > 0) {
                        sb.append((char)(i + 'A'));
                    }
                }
            }
            sb.append(sum);
            return sb.toString();
        }
}

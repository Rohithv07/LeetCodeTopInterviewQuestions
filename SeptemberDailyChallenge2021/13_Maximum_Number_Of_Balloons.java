Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.



class Solution {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }
        int [] count = new int [26];
        for (char ch : text.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        int minInstance = count[0];
        minInstance = Math.min(count[1], minInstance);
        minInstance = Math.min(count[11] / 2, minInstance);
        minInstance = Math.min(count[14] / 2, minInstance);
        minInstance = Math.min(count[13], minInstance);
        return minInstance;
    }
}
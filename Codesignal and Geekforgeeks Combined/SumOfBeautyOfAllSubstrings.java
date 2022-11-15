Given a string S, return the sum of beauty of all its substrings.
The beauty of a string is defined as the difference in frequencies between the most frequent and least frequent characters.

For example, the beauty of string "aaac" is 3 - 1 = 2.
Example 1:

Input:
S = "aaac"
Output:
3
Explanation: The substrings with non - zero beauty are ["aaac","aac"] where beauty of "aaac" is 2 and beauty of "aac" is 1.
 

Example 2:

Input:
S = "geeksforgeeks"
Output:
62
Your Task:
You don't need to read input or print anything. Your task is to complete the function beautySum() which takes string S as input paramters and returns the sum of beauty of all its substrings. 

Expected Time Complexity: O(|S|2)
Expected Auxiliary Space: O(1)

Constraints: 
1 ≤ |S| ≤ 500
S only contains lower case alphabets.



class Solution {
    public static int beautySum(String s) {
        // code here
        int sum = 0;
        int left = 0;
        int right = 0;
        int length = s.length();
        int [] count;
        for (left = 0; left < length; left++) {
            count = new int [26];
            for (right = left; right < length; right++) {
                count[s.charAt(right) - 'a']++;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    max = Math.max(max, count[k]);
                    min = count[k] != 0 ? Math.min(min, count[k]) : min;
                }
                sum += (max - min);
            }
        }
        
        return sum;
    }
}
        

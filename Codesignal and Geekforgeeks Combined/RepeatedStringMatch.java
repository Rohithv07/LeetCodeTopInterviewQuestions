Given two strings A and B, find the minimum number of times A has to be repeated such that B becomes a substring of the repeated A. If B cannot be a substring of A no matter how many times it is repeated, return -1.

Example 1:

Input: A = "abcd", B = "cdabcdab"
Output: 3
Explanation: After repeating A three times, 
we get "abcdabcdabcd".
Example 2:

Input: A = "aa", B = "a"
Output: 1
Explanation: B is already a substring of A.
Your Task:  
You don't need to read input or print anything. Complete the function repeatedStringMatch() which takes strings A and B as input parameters and returns the minimum number of operations to complete the task. If it is not possible then return -1.

Expected Time Complexity: O(|A| * |B|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |A|, |B| ≤ 4 * 103



class Solution 
{ 
	static int repeatedStringMatch(String a, String b) 
	{ 
        // Your code goes here
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return 0;
        }
        int counter = 1;
        int length = a.length();
        for (int i=0; i<(b.length() / length) + 2; i++) {
            if (a.contains(b))
                return counter;
            counter += 1;
            a += a.substring(0, length);
        }
        return -1;
	} 
} 
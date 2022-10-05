Given a string S consisting of only lowercase characters. Find the lexicographically smallest string after removing exactly k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k character.
NOTE: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return -1.

Example 1:

Input: S = "fooland", k = 2
Output: "and" 
Explanation: As the size of the string = 7
which is not a power of 2, hence k = 4.
After removing 4 characters from the given 
string, the lexicographically smallest
string is "and".
Example 2:

Input: S = "code", k = 4
Output: "cd"
Explanation: As the length of the string = 4, 
which is 2 to the power 2, hence k = 2.
Hence, lexicographically smallest string after 
removal of 2 characters is "cd".

Your Task:  
You dont need to read input or print anything. Complete the function lexicographicallySmallest() which takes S and k as input parameters and returns the lexicographically smallest string after removing k characters.

Expected Time Complexity: O(n+k), n is size of the string
Expected Auxiliary Space: O(n)

Constraints:
1<= |S| <=105
1<= k <= 105


// User function Template for Java
class Solution {
    static String lexicographicallySmallest(String s, int k) {
        // code here
        int length = s.length();
        if (isPowerOf2(length)) {
            k /= 2;
        }
        else {
            k *= 2;
        }
        //System.out.println(k);
        
        if (k >= length) {
            return "-1";
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int removed = 0;
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty() || removed == k) {
                stack.push(ch);
            }
            else {
                while (!stack.isEmpty() && removed < k && stack.peek() > ch) {
                    removed++;
                    stack.pop();
                }
                stack.push(ch);
            }
        }
        while (removed < k && !stack.isEmpty()) {
            removed++;
            stack.pop();
        }
        if (stack.isEmpty()) {
            return "-1";
        }
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
    
    static boolean isPowerOf2(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        return (num & (num - 1)) == 0;
    }
}
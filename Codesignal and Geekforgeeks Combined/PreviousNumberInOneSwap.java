Given a non-negative number N in the form of string. The task is to apply at most one swap operation on the number N so that the result is just a previous possible number.

Note:  Leading zeros are not allowed.

 

Example 1:

Input :
S = "12435"
Output: 
12345
Explanation:
Although the number 12354 
will be the largest smaller 
number from 12435. But it is 
not possible to make it using 
only one swap. So swap 
4 and 3 and get 12345.
 

Example 2:

Input: 
S = " 12345"
Output: 
-1
Explanation:
Digits are in increasing order. 
So it is not possible to 
make a smaller number from it.
 

Your Task:

You don't need to read input or print anything. Your task is to complete the function previousNumber() which takes the string S and returns the previous number of S. If no such number exists return -1;

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

 

Constraints:
2<=|Number length |<=105





/**
 * Solution without using any extra space..
 * find the pivot(point where decreasing sequence ends from right side) 
 * and suffix(point just smaller than pivot from right side) and swap them.

PS: It is assured that if pivot exists..
then definitely suffix will also exist..Make sure to handle the 
corner cases (99999000000) as well..
 * 
 */

//User function Template for Java
class Solution{
    static String previousNumber(String s){
        // code here
        int length = s.length();
        int pivot = findPivot(s, length);
        if (pivot != -1) {
            int suffix = findSuffix(s, length, s.charAt(pivot));
            String result = swap(s, pivot, suffix);
            if (result.charAt(0) == '0') {
                return "-1";
            }
            return result;
        }
        return "-1";
    }
    
    static int findPivot(String s, int n) {
        for (int i = n - 1; i > 0; i--) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return i - 1;
            }
        }
        return -1;
    }
    
    static int findSuffix(String s, int n, char target) {
        for (int i = n - 2; i >= 0; i--) {
            char previous = s.charAt(i + 1);
            if (s.charAt(i) == previous) {
                continue;
            }
            if (s.charAt(i + 1) < target) {
                return i + 1;
            }
        }
        return -1;
    }
    
    static String swap(String s, int i, int j) {
        char [] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        String result = new String(ch);
        return result;
    }
}

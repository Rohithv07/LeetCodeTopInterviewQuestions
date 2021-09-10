Given a string str and another string patt. Find the first position (considering 0-based indexing) of the character in patt that is present at the minimum index in str.


Example 1:

Input:
str = geeksforgeeks
patt = set
Output: 1
Explanation: e is the character which is
present in given patt "geeksforgeeks"
and is first found in str "set". First Position
of e in str is 1. 
Example 2:

Input:
str = adcffaet
patt = onkl
Output: -1
Explanation: There are none of the
characters which is common in patt
and str.

Your Task:
You only need to complete the function minIndexChar() that returns the index of answer in str or returns -1 in case no character of patt is present in str.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).


Constraints:
1 ≤ |str|,|patt| ≤ 105



// other possible methods, we can just make use of a int array of size 256
// another possible methods is we can track patt first and then check for the character in str which is more time sabing
class Solution
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        // Your code here
        if (str == null || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> mapIndex = new HashMap<>();
        for (int i=0; i<str.length(); i++) {
            char current = str.charAt(i);
            if (mapIndex.containsKey(current)) {
                int previousIndex = mapIndex.get(current);
                if (previousIndex < i) {
                    continue;
                }
                else {
                    mapIndex.put(current, i);
                }
            }
            else {
                mapIndex.put(current, i);
            }
        }
        int result = Integer.MAX_VALUE;
        for (char ch : patt.toCharArray()) {
            if (mapIndex.containsKey(ch)) {
                result = Math.min(result, mapIndex.get(ch));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
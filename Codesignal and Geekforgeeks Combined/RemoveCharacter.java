Given two strings string1 and string2, remove those characters from first string(string1) which are present in second string(string2). Both the strings are different and contain only lowercase characters.
NOTE: Size of  first string is always greater than the size of  second string( |string1| > |string2|).
 

Example 1:

Input:
string1 = "computer"
string2 = "cat"
Output: "ompuer"
Explanation: After removing characters(c, a, t)
from string1 we get "ompuer".
Example 2:

Input:
string1 = "occurrence"
string2 = "car"
Output: "ouene"
Explanation: After removing characters
(c, a, r) from string1 we get "ouene".
 

Your Task:  
You dont need to read input or print anything. Complete the function removeChars() which takes string1 and string2 as input parameter and returns the result string after removing characters from string2  from string1.


Expected Time Complexity:O( |String1| + |String2| )
Expected Auxiliary Space: O(K),Where K = Constant   


Constraints:
1 <= |String1| , |String2| <= 50


//User function Template for Java
class Solution{
    static String removeChars(String string1, String string2){
        // code here
        // using set
        Set<Character> set = new HashSet<>();
        for (char ch : string2.toCharArray()) {
            set.add(ch);
        }
        StringBuilder result = new StringBuilder();
        for (char ch : string1.toCharArray()) {
            if (!set.contains(ch))
                result.append(ch);
        }
        return result.toString();
        
        
        // using count array
        int [] count = new int [26];
        for (char ch : string2.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        StringBuilder result = new StringBuilder();
        for (char ch : string1.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
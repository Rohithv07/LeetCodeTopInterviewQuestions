Given a string S containing lowercase english alphabet characters. The task is to calculate the number of distinct strings that can be obtained after performing exactly one swap.
In one swap,Geek can pick two distinct index i and j (i.e 1 < i < j < |S| ) of the string, then swap the characters at the position i and j.

 

Example 1:

Input:
S = "geek"
Output: 
6
Explanation: 
After one swap, There are only 6 distinct strings 
possible.(i.e "egek","eegk","geek","geke","gkee" and 
"keeg")
 

Example 2:

Input:
S = "ab"
Output: 
1
Explanation:
Only one string is possible after one swap(i.e "ba")
 

Your Task: 
You don't need to read input or print anything. Complete the function countStrings( ) which takes the string S as input parameters and returns the required answer.

 

Expected Time Complexity: O(|S|) .
Expected Auxiliary Space: O(1) .

 

Constraints:
2 ≤ |S| ≤ 105
S contains lowercase characters


class Solution 
{ 
    long countStrings(String s) 
    { 
        // code here
        int length = s.length();
        long repeat = 0;
        long answer = 0;
        long [] count = new long [26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 1;
            if (count[ch - 'a'] > 1) {
                repeat = 1;
            }
        }
        for (long num : count) {
            answer += (length - num) * num;
        } 
        return answer / 2 + repeat;
    }
}
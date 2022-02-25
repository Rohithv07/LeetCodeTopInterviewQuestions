There are two kinds of bots A and B in a 1-D array. A bot can only move left while B can only move right. There are also empty spaces in between represented by #. But its also given that the bots cannot cross over each other.

Given the initial state and final state, we should tell if the transformation is possible.

NOTE: There can be many bots of the same type in a particular array. 


Example 1:

Input:
s1 = #B#A#
s2 = ##BA#
Output: Yes
Explanation: Because we can reach the 
final state by moving 'B' to the 
right one step.

Example 2:

Input:
s1 = #B#A#
s2 = #A#B# 
Output: No
Explanation: Because the robots 
cannot cross each other.


Your Task:  
You don't need to read input or print anything. Your task is to complete the function moveRobots() which takes the initial and final states as strings s1 and s2 respectively and returns if a valid transformation can be done. Return "Yes" if possible, else "No".

 

Expected Time Complexity: O(|s1|)
Expected Auxiliary Space: O(|s1|)

 

Constraints:
1 <= |s1| = |s2| <= 105
The strings only consists of 'A', 'B' and '#'.


class Solution{
    public static String moveRobots(String s1, String s2){
        //code here
        int i = 0;
        int j = 0;
        int n = s1.length();
        while (i < n && j < n) {
            while (i < n && s1.charAt(i) == '#') {
                i += 1;
            }
            while (j < n && s2.charAt(j) == '#') {
                j += 1;
            }
            if (i < n && j < n) {
                if (s1.charAt(i) != s2.charAt(j)) {
                    return "No";
                }
                if (s1.charAt(i) == 'B' && i > j) {
                    return "No";
                }
                else if (s1.charAt(i) == 'A' && i < j) {
                    return "No";
                }
                else {
                    i += 1;
                    j += 1;
                }
            }
            else {
                break;
            }
        }
        return (i == n || j == n) ? "Yes" : "No";
    }
}
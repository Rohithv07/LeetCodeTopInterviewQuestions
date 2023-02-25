A special compression mechanism can arbitrarily delete 0 or more characters and replace them with the deleted character count.
Given two strings, S and T where S is a normal string and T is a compressed string, determine if the compressed string  T is valid for the plaintext string S. 


Example 1:

Input:
S = "GEEKSFORGEEKS"
T = "G7G3S"
Output:
1
Explanation:
We can clearly see that T is a valid 
compressed string for S.

Example 2:

Input:
S = "DFS"
T = "D1D"
Output :
0
Explanation:
T is not a valid compressed string.

Your Task:  
You don't need to read input or print anything. Your task is to complete the function checkCompressed() which takes 2 strings S and T as input parameters and returns integer 1 if T is a valid compression of S and 0 otherwise.


Expected Time Complexity: O(|T|)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ |S| ≤ 106
1 ≤ |T| ≤ 106
All characters are either capital or numeric.


//User function Template for Java

class Solution {
    static int checkCompressed(String s, String t) {
        // code here
        if (s.equals(t)) {
            return 1;
        }
        int lengthT = t.length();
        int lengthS = s.length();
        int index = 0;
        int trackingIndex = 0;
        while (index < lengthT) {
            int moving = 0;
            if (!Character.isLetter(t.charAt(index))) {
                while (index < lengthT && !Character.isLetter(t.charAt(index))) {
                    int number = t.charAt(index) - '0';
                    moving = (moving * 10) + number;
                    index++;
                }
                trackingIndex += moving;
            }
            else {
                if (trackingIndex >= lengthS || (s.charAt(trackingIndex) != t.charAt(index))) {
                    return 0;
                }
                index++;
                trackingIndex++;
            }
        }
        return trackingIndex == lengthS ? 1 : 0;
    }
}
/*
VAN
VA1


*/
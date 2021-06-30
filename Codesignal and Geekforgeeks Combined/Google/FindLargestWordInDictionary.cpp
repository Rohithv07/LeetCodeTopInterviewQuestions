Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:

Input: d = {"ale", "apple", "monkey", "plea"}
       S = "abpcplea"
Output: "apple" 
Explanation: After deleting "b", "c"
"a" S became "apple" which is present
in d.
Example 2:

Input: d = {"a", "b", "c"}
       S = "abpcplea"
Output: "a"
Explanation: After deleting "b", "p"
"c", "p", "l", "e", "a" S became 
"a" which is present in d.

Your Task:  
You dont need to read input or print anything. Complete the function findLongestWord() which takes S and d as input parameter and returns the longest word.

Expected Time Complexity: O(n*x)
Expected Auxiliary Space: O(x)

Constraints:
1<= n,x <=1000



class Solution {
  public:
    string findLongestWord(string s, vector<string> d) {
        // code here
        int index = -1;
        int max = 0;
        sort(d.begin(), d.end());
        for (int i=0; i<d.size(); i++) {
            int length = lengthOfSubsequence(s, d[i]);
            if (max < length) {
                max = length;
                index = i;
            }
        }
        return index != -1 ? d[index] : "";
    }
    
    int lengthOfSubsequence(string s1, string s2) {
        int lengthS1 = s1.size();
        int lengthS2 = s2.size();
        int i = 0;
        int j = 0;
        while (i < lengthS1 && j < lengthS2) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        if (j == lengthS2)
            return lengthS2;
        return INT_MIN;
    }
};

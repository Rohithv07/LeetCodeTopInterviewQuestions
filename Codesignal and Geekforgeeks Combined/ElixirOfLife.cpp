Flamel is making the Elixir of Life but he is missing a secret ingredient, a set of contiguous plants (substring) from the Garden of Eden. The garden consists of various plants represented by string S where each letter represents a different plant.  But the prophecy has predicted that the correct set of plants required to make the potion will appear in the same contiguous pattern (substring) at the beginning of the forest (prefix), the end of the forest (suffix), and will also be the most frequent sequence present in the entire forest.

Identify the substring of plants required to make the elixir and find out the number of times it appears in the forest. 

Example 1:

Input: S = "ababaaaab"
Output: 3
Explanation: substring "ab" is a prefix, 
a suffix and appears 3 times.

Example 2:

Input: S = "aaaa"
Output: 4
Explanation: substring "aaaa" occurs 1 time, 
substring "aaa" occurs 2 times, substring 
"aa" occurs 3 times, substring "a" occurs 
4 times. All of them are proper prefixes 
and suffixes. But, "a" has the maximum 
frequency.
Example 3:

Input: S = "abcdef"
Output: 1

Your Task: 
You don't need to read input or print anything. Complete the function maxFrequency() which takes string S as input parameter and returns the answer

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)
Constraints: 
1 ≤ |S| ≤ 105



class Solution
{
    public:
    int maxFrequency(string S)
    {
    	// code here
    	int result = 0;
    	string required;
    	int length = S.length();
    	for (int i=1; i<length; i++) {
    	    if (S.substr(0, i) == S.substr(length - i, i)) {
    	        required = S.substr(0, i);
    	        break;
    	    }
    	}
    	for (int i=0; i<=length - required.length(); i++) {
    	    if (S[i] == required[0]) {
    	        int j = 0;
    	        for (j=0; j<required.length(); j++) {
    	            if (required[j] != S[i + j])
    	                break;
    	        }
    	        if (j == required.length())
    	            result += 1;
    	    }
    	}
    	return result;
    }
};

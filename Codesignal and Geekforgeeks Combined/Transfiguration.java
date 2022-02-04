Professor McGonagall teaches transfiguration at Hogwarts. She has given Harry the task of changing himself into a cat. She explains that the trick is to analyze your own DNA and change it into the DNA of a cat. The transfigure spell can be used to pick any one character from the DNA string, remove it and insert it in the beginning. 
Help Harry calculates minimum number of times he needs to use the spell to change himself into a cat.

Example 1:

Input: 
A = "GEEKSFORGEEKS" 
B = "FORGEEKSGEEKS"
Output: 3
Explanation:The conversion can take place 
in 3 operations:
1. Pick 'R' and place it at the front, 
   A="RGEEKSFOGEEKS"
2. Pick 'O' and place it at the front, 
   A="ORGEEKSFGEEKS"
3. Pick 'F' and place it at the front, 
   A="FORGEEKSGEEKS"
Example 2:

Input: 
A = "ABC" 
B = "BCA"
Output: 2
Explanation: The conversion can take place 
in 2 operations:
1. Pick 'C' and place it at the front, 
   A = "CAB"
2. Pick 'B' and place it at the front, 
   A = "BCA"
Your Task:  
You don't need to read input or print anything. Complete the function transfigure() which takes strings A and B as input parameters and returns the minimum number of spells needed. If it is not possible to convert A to B then return -1.

Expected Time Complexity: O(max(|A|, |B|))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |A|, |B| ≤ 105
A and B consists of lowercase and uppercase letters of english alphabet only.

class Solution
{
    int transfigure (String a, String b)
    {
    	// Your code goes here.
    	if (a.equals(b)) {
    	    return 0;
    	}
    	if (a.length() != b.length()) {
    	    return -1;
    	}
    	int [] count = new int [256];
    	for (char ch : a.toCharArray()) {
    	    count[ch] += 1;
    	}
    	for (char ch : b.toCharArray()) {
    	    count[ch] -= 1;
    	}
    	for (int number : count) {
    	    if (number != 0) {
    	        return -1;
    	    }
    	}
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	int moves = 0;
    	while (i >= 0 && j >= 0) {
    	    if (a.charAt(i) == b.charAt(j)) {
    	        i--;
    	        j--;
    	    }
    	    else {
    	        moves++;
    	        i--;
    	    }
    	}
    	return moves;
    }
}
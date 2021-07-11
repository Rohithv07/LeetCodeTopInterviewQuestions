
Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.

Note: You are not allowed to use inbuilt function.

Example 1:

Input:
str = 123
Output: 123

Example 2:

Input:
str = 21a
Output: -1
Explanation: Output is -1 as all
characters are not digit only.
Your Task:
Complete the function atoi() which takes a string as input parameter and returns integer value of it. if the input string is not a numerical string then returns 1..

Expected Time Complexity: O(|S|), |S| = length of string str.
Expected Auxiliary Space: O(1)

Constraints:
1<=length of S<=10


class Solution
{
    int atoi(String str)
    {
	// Your code here
	    int length = str.length();
	    int number = 0;
	    boolean isNegative = false;
	    int limit = 0;
	    if (str.charAt(0) == '-') {
	        limit = length - 2;
	        isNegative = true;
	    }
	    else
	        limit = length - 1;
	    for (char ch : str.toCharArray()) {
	        if (ch == '-')
	            continue;
	        int currentNumber = ch - '0';
	        if (currentNumber < 0 || currentNumber > 9)
	            return -1;
	        
	        number += (currentNumber) * (int)(Math.pow(10, limit--));
	    }
	    return isNegative ? -1 * number : number;
    }
}

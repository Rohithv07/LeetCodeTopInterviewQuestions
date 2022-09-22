Geek has a string Sof size Nconsisting of characters from '0'to '9'. He wants to minimise the length of the string. In each minimising operation, geek can remove any two consecutive characters if they are of the form {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"}.
Find the minimum possible length of the string after applying minimising operations. 
 

Example 1:

Input: 
N = 5 
S = "12213"
Output: 1
Explanation: Geek can get the string of 
length 1 in two minimising operation,
In 1st operation Geek will remove "12" 
from "12213" then Geek left with "213"
In 2nd operation Geek will remove "21" 
from "213" then Geek left with "3"
 

Example 2:

Input: 
N = 4
S = "1350"
Output: 4
Explanation: Can't remove any character.
 

Your Task:  
You don't need to read input or print anything. Complete the functionminLength() which takes N and S as input parameters and returns the the minimum possible length of the string.


Expected Time Complexity: O(N)
Expected Auxiliary Space:O(N)
 

Constraints:
1 ≤ N ≤ 105


//User function Template for Java

class Solution { 
    public int minLength(String s, int n) { 
    	// code here 
    	if (s == null || n == 0) {
    	    return 0;
    	}
    	if (n == 1) {
    	    return 1;
    	}
    	Stack<Character> stack = new Stack<>();
    	for (char ch : s.toCharArray()) {
    	    if (stack.isEmpty()) {
    	        stack.push(ch);
    	    }
    	    else {
    	        if ((stack.peek() == '1' && ch == '2') || (stack.peek() == '2' && ch == '1')) {
    	            stack.pop();
    	        }
    	        else if ((stack.peek() == '3' && ch == '4') || (stack.peek() == '4' && ch == '3')) {
    	            stack.pop();
    	        }
    	        else if ((stack.peek() == '5' && ch == '6') || (stack.peek() == '6' && ch == '5')) {
    	            stack.pop();
    	        }
    	        else if ((stack.peek() == '7' && ch == '8') || (stack.peek() == '8' && ch == '7')) {
    	            stack.pop();
    	        }
    	        else if ((stack.peek() == '0' && ch == '9') || (stack.peek() == '9' && ch == '0')) {
    	            stack.pop();
    	        }
    	        else {
    	            stack.push(ch);
    	        }
    	    }
    	}
    	return stack.size();
    }
}
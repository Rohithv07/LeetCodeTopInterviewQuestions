A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person. Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
 

Example 1:

Input:
N = 3
M[][] = {{0 1 0},
         {0 0 0}, 
         {0 1 0}}
Output: 1
Explanation: 0th and 2nd person both
know 1. Therefore, 1 is the celebrity. 

Example 2:

Input:
N = 2
M[][] = {{0 1},
         {1 0}}
Output: -1
Explanation: The two people at the party both
know each other. None of them is a celebrity.

Your Task:
You don't need to read input or print anything. Complete the function celebrity() which takes the matrix M and its size N as input parameters and returns the index of the celebrity. If no such celebrity is present, return -1.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
2 <= N <= 3000
0 <= M[][] <= 1


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int m[][], int n)
    {
    	// code here
    	if (m == null || n == 0)
    	    return -1;
    	    
    	// O(n) space complexity
    	Stack<Integer> stack = new Stack<>();
    	for (int i=0; i<n; i++) {
    	    stack.push(i);
    	}
    	while (stack.size() >= 2) {
    	    int index1 = stack.pop();
    	    int index2 = stack.pop();
    	    if (m[index1][index2] == 0) {
    	        stack.push(index1);
    	    }
    	    else {
    	        stack.push(index2);
    	    }
    	}
    	int answer = stack.peek();
    	for (int i=0; i<n; i++) {
    	    if (i != answer) {
    	        if (m[i][answer] == 0 || m[answer][i] == 1)
    	            return -1;
    	    }
    	}
    	return answer;
    
    // O(1) space complexity
    int i = 0;
    int j = n - 1;
    while (i < j) {
        if (m[i][j] == 1)
            i += 1;
        else
            j -= 1;
    }
    for (int k = 0; k < n; k++) {
        if (k == i)
            continue;
        if (m[k][i] != 1 || m[i][k] == 1)
            return -1;
    }
    return i;
    	
    }
}



class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int m[][], int n)
    {
        // code here 
        if (m == null || n == 0) {
            return 0;
        }
        int assumptionOfCelebrity = 0;
        for (int i=0; i<n; i++) {
            if (m[assumptionOfCelebrity][i] == 1) {
                assumptionOfCelebrity = i;
            }
        }
        for (int i=0; i<n; i++) {
            if (i != assumptionOfCelebrity && (m[assumptionOfCelebrity][i] == 1 || m[i][assumptionOfCelebrity] == 0)) {
                return -1;
            }
        }
        return assumptionOfCelebrity;
    }
}
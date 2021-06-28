Imagine you have a special keyboard with the following keys: 

Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.

Find maximum numbers of A's that can be produced by pressing keys on the special keyboard N times. 


Example 1:

Input: N = 3
Output: 3
Explaination: Press key 1 three times.

Example 2:

Input: N = 7
Output: 9
Explaination: The best key sequence is 
key 1, key 1, key 1, key 2, key 3,
key4, key 4.

Your Task:
You do not need to read input or print anything. Your task is to complete the function optimalKeys() which takes N as input parameter and returns the maximum number of A's that can be on the screen after performing N operations.


Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)


Constraints:
1 < N < 75

/* 
Recursive relation

for (b = N - 3; b >= 1; b--) {
            // If the breakpoint is s at b'th
            // keystroke then the optimal string
            // would have length
            // (n-b-1)*screen[b-1];
            int curr = (N - b - 1) * findoptimal(b);
            if (curr > max)
                max = curr;
        }
        return max;
*/


class Solution{
    static int optimalKeys(int n){
        // code here
        if (n <= 6)
            return n;
        int [] dp = new int [n];
        for (int i=1; i<=6; i++) {
            dp[i - 1] = i;
        }
        //[1, 2, 3, 4 ,5 ,6, .......]
        for (int i=7; i<=n; i++) {
            // effect of pressing contrl+v for 1 time, 2 time, 3 time
            dp[i - 1] = Math.max(2 * dp[i-4], Math.max(3 * dp[i-5], 4 * dp[i-6]));
        }
        return dp[n - 1];
    }
}

/*
4
1 1 1 1
5
1 1 1 1 1

10
1 1 1 1 1  1 sec c 6 6 6 
1 1 1 1 se c 4 4 4 4 
*/

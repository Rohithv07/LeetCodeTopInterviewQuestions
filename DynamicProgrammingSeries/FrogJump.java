// https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

// https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4



/*
This is the recursive way
Here we are asked to find the minimum energy the frog can take to reach from 1 to N and the frog can jump either i + 1 or i + 2.
And here we surely need to find different possible ways, which is count all ways and we boiled down the problem to recursion.

Steps 
1. Represent the values in terms of index. We are given an array, so we have the index.
2. Do all the steps on that index. SO the steps is the frog can jump either i + 1 or i + 2. If we start from the back, then i - 1 or i - 2.
ie left = f(i - 1) + abs(h[i] - h[i - 1])
right = f(i - 2) + abs(h[i] - h[i - 2])
3. Do the operation, our task is to find the minimum, so take the mnimum everytime from all the possible ways.
min(left, right)

But there are so many overlapping subproblems, so our attention will go to dynamic programming
*/


public class Solution {
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
       return recursion(n - 1, heights);
    }
    
    private static int recursion(int index, int [] heights) {
        if (index == 0) {
            return 0;
        }
        if (index == 1) {
            return Math.abs(heights[index] - heights[index - 1]);
        }
        int left = recursion(index - 1, heights) + Math.abs(heights[index] - heights[index - 1]);
           int right = recursion(index - 2, heights) + Math.abs(heights[index] - heights[index - 2]);
        return Math.min(left, right);
    }

}



/*
We have the recurrance formula. Now all we need is to apply memoization here. So only the index is changing inside the function, which can bring to a conclusion that it is a 1d dp.
Now inside the rcusrion, just store the min(left, right) to the dp and also just have a precheck inside the function that whether we have precomputed it before or not.
dp[i] != -1 or not. if not return dp[i] and don't go on and solving the same steps that we have done long before.

TC : O(N)
SC : O(stack space) + O(N)

*/


import java.util.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        if (n == 1) {
            return heights[0];
        }
        int [] dp = new int [n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = Math.abs(heights[0] - heights[1]);
        return findMinimumJump(heights, n - 1, dp);
        // Write your code here..
    }
    
    private static int findMinimumJump(int [] heights, int i, int []dp) {
        if (i < 2) {
            return dp[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int left = findMinimumJump(heights, i - 1, dp) + Math.abs(heights[i] - heights[i - 1]);
        int right = findMinimumJump(heights, i - 2, dp) + Math.abs(heights[i] - heights[i - 2]);
        return dp[i] = Math.min(left, right);
    }

}


/*
We have the memoization solution,
just convert it into a tabulation one.

TC -> O(N)
SC -> O(N) 

*/


import java.util.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        if (n == 1) {
            return heights[0];
        }
        int [] dp = new int [n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[0] - heights[1]);
        for (int i = 2; i < n; i++) {
            int singleStep = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int twoStep = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(singleStep, twoStep);
        }
        return dp[n - 1];
    }

}



/*
Space optimisation,
we are just having two steps, either i - 1or i - 2.
So whenever such scenarios arises, just remove the dp array and just use two variables. One varibale for the single step and the other for the double step

TC -> O(N)
SC -> O(1) 

*/


import java.util.*;
public class Solution {
    public static int frogJump(int n, int heights[]) {
        if (n == 1) {
            return heights[0];
        }
        int previous = 0;
        int previousPrevious = 0;
        for (int i = 1; i < n; i++) {
            int singleStep = previous + Math.abs(heights[i] - heights[i - 1]);
            int twoStep = Integer.MAX_VALUE;
            if (i > 1) {
                 twoStep = previousPrevious + Math.abs(heights[i] - heights[i - 2]);
            }
            int result = Math.min(singleStep, twoStep);
            previousPrevious = previous;
            previous = result;
        }
        return previous;
    }

}
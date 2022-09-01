// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

// https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6



/*

Here we are concerned about the subsequence sum, 
under one condition none of the elements should be adjancet.
So we have a kind of pick element or do not pick kind of a state to 
find all the subseqnece + if we pick the element at index, 
we skip index - 1 and continue with index - 2 as if we again pick 
index - 1th element, then it would become adjacent and 
if we do not pick the element at index, then we are free 
to continue and explore with the index - 1 as it would not 
lead us to violate the adjacent rule mentinoned.

But this won't be sufficient to try all the subsequnce and over 
computing same steps again and again due to overlapping.
So this leads us to memoization

*/



import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
        int length = nums.size();
        if (length == 1) {
            return nums.get(0);
        }
        return findMaximumSum(nums, length - 1);
	}
    
    private static int findMaximumSum(ArrayList<Integer> nums, int index) {
        // if we reach index = 0, that means we haven't picked index = 1 as the elements cannot be adjacent
        if (index == 0) {
            return nums.get(index);
        }
        if (index < 0) {
            return 0;
        }
        int pickThisElement = nums.get(index) + findMaximumSum(nums, index - 2); // as we cannot have any adjacent element
        int notPickThisElement = findMaximumSum(nums, index - 1);
        return Math.max(pickThisElement, notPickThisElement);
    }
}





/*

So its the normal way how we do for all other dp problems.
We just make use of a dp array to store the result and 
if we come across computing the same calculation again, 
our dp array comes in handy and help out with us to provide 
the previously obtained result without computing it again.

dp[i] means max sum we can get from 0 to i elements

TC : O(N)
SC : O(N) + O(stack space)

*/



import java.util.*;
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int length = nums.size();
        if (length == 1) {
            return nums.get(0);
        }
        int [] dp = new int [length];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);
        return findMaximumSum(nums, length - 1, dp);
    }
    
    private static int findMaximumSum(ArrayList<Integer> nums, int index, int [] dp) {
        // if we reach index = 0, that means we haven't picked index = 1 as the elements cannot be adjacent
        if (index == 0) {
            return dp[0];
        }
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int pickThisElement = nums.get(index) + findMaximumSum(nums, index - 2, dp); // as we cannot have any adjacent element
        int notPickThisElement = findMaximumSum(nums, index - 1, dp);
        return dp[index] = Math.max(pickThisElement, notPickThisElement);
    }
}



/*
Now just convert the memoization to dp tabulation.
Start from the base case and change every function call to dp.

TC : O(N)
SC : O(N)

*/


import java.util.*;
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int length = nums.size();
        if (length == 1) {
            return nums.get(0);
        }
        int [] dp = new int [length];
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);
        for (int i = 1; i < length; i++) {
            int pickElement = nums.get(i);
            // to handle edge case when i = 1;
            if (i > 1) {
                pickElement += dp[i - 2];
            }
            int notPickElement = dp[i - 1];
            dp[i] = Math.max(pickElement, notPickElement);
        }
        return dp[length - 1];
    }
}



/*
Here we only depends on dp[i - 1] and dp[i - 2] values.

So we can just take out the dp array and use 2 variables x and y 
for example and use them for the compuatation. 

TC : O(N)
SC : O(1)

*/


import java.util.*;
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int length = nums.size();
        if (length == 1) {
            return nums.get(0);
        }
        // the previous previous value
        int fromBeginning = nums.get(0);
        // the previous value
        int nextOfBeginning = Math.max(nums.get(0), nums.get(1));
        for (int i = 2; i < length; i++) {
            // if we pick the element, then we add it with previous previous value
            int pickElement = nums.get(i) + fromBeginning;
            // if we are not picking, then we just take the previous value
            int notPickElement = nextOfBeginning;
            // the previous previous value will be update with the current previous
            fromBeginning = nextOfBeginning;
            // and the previous will be updated with the max(pick, nonpick)
            nextOfBeginning = Math.max(pickElement, notPickElement);
        }
        return nextOfBeginning;
    }
}


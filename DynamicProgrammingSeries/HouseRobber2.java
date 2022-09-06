// https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7








1. Recursion


/*

Since last element is the adjacent of the first element, we can have 3 observations.

1. In our answer, there will not be both first and last element together.
2. If we leave the first element, then its solving house robber 1 from index 1 to n.
3. If we leave the last element, then its solving house robber 1 from index 0 to n - 1.

So our final answer will be max(step2, step3).

But this recursive solution will gives TLE as there are so many overlapping subproblems

*/


class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
         if (length == 1) {
            return nums[0];
        }
        // the first option is do not consider the first element, but the last element
        // the second option is we consider first element, but not the last element.
        return Math.max(findMaxWealthNotTakingFirstOrLast(nums, 1, length - 1), findMaxWealthNotTakingFirstOrLast(nums, 0, length - 2));
    }
    
    private int findMaxWealthNotTakingFirstOrLast(int [] nums, int start, int end) {
        if (end < start) {
            return 0;
        }
        if (end == start) {
            return nums[start];
        }
        int pickThisElement = nums[end] + findMaxWealthNotTakingFirstOrLast(nums, start, end - 2);
        int notPickThisElement = findMaxWealthNotTakingFirstOrLast(nums, start, end - 1);
        return Math.max(pickThisElement, notPickThisElement);
    }
}
2. Memoization

/*

Use 2 dp tables. One to track the results while we are not cosnidering the first element and the first one while we are considering the first element.

Then just apply the dp tables and save the result at the very end where we are doing the return statement.

TC : O(N)
SC : O(N) + O(N) + O(Stack Space)
*/


class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
         if (length == 1) {
            return nums[0];
        }
        int [] dp1 = new int [length];
        Arrays.fill(dp1, -1);
        // dp1 will be for the case where we do not consider the first element
        dp1[0] = nums[1];
        int [] dp2 = new int [length];
        Arrays.fill(dp2, -1);
        // dp2 will be for the case where we consider the first element
        dp2[0] = nums[0];
        // the first option is do not consider the first element, but the last element
        // the second option is we consider first element, but not the last element.
        return Math.max(findMaxWealthNotTakingFirstOrLast(nums, 1, length - 1, dp1), findMaxWealthNotTakingFirstOrLast(nums, 0, length - 2, dp2));
    }
    
    private int findMaxWealthNotTakingFirstOrLast(int [] nums, int start, int end, int [] dp) {
        if (end < start) {
            return 0;
        }
        if (end == start) {
            return nums[start];
        }
        if (dp[end] != -1) {
            return dp[end];
        }
        int pickThisElement = nums[end] + findMaxWealthNotTakingFirstOrLast(nums, start, end - 2, dp);
        int notPickThisElement = findMaxWealthNotTakingFirstOrLast(nums, start, end - 1, dp);
        return dp[end] = Math.max(pickThisElement, notPickThisElement);
    }
}
3. Tabulation

/*

Now we can go for the tabulation method and get rid of the extra stack space we are using

TC : O(N)
SC : O(N) + O(N) [Didn;t considered the temp arraylist created] 
*/

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        // storing the elements to two separate list
        for(int i=0; i<length; i++){

            if(i != 0) arr1.add(nums[i]);
            if(i != length - 1) arr2.add(nums[i]);
        }
        int [] dp1 = new int [length];
        Arrays.fill(dp1, -1);
        int [] dp2 = new int [length];
        Arrays.fill(dp2, -1);
        return Math.max(maxResultLeavingNotLeavingFirstLast(arr1, dp1), 
                      maxResultLeavingNotLeavingFirstLast(arr2, dp2));
    }
    
    // just the house robber logic
    private int maxResultLeavingNotLeavingFirstLast(ArrayList<Integer> nums, int [] dp) {
        dp[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            int pickElement = nums.get(i);
            if (i > 1) {
                pickElement += dp[i - 2];
            }
            int notPickElement = dp[i - 1];
            dp[i] = Math.max(pickElement, notPickElement);
        }
        return dp[nums.size() - 1];
    }
}
4. Space Optimized

/*

We can make 1 more observation that, we only care about the previous house and the previous previous house. So instead of the dp arrays, we can just make use of two variable and apply the same logic which will reduce our space further
*/

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        return Math.max(maxResultLeavingNotLeavingFirstLast(nums, 1, length - 1), 
                      maxResultLeavingNotLeavingFirstLast(nums, 0, length - 2));
    }
    
    // just the house robber logic
    private int maxResultLeavingNotLeavingFirstLast(int [] nums, int start, int end) {
        int previous = nums[start];
        int previousPrevious = 0;
        for (int i = start + 1; i <= end; i++) {
            int pick = nums[i] + previousPrevious;
            int notPick = previous;
            int result = Math.max(pick, notPick);
            previousPrevious = previous;
            previous = result;
        }
        return previous;
    }
}
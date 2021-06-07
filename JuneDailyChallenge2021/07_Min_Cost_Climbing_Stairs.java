class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0 || cost == null)
            return 0;
        int [] dp = new int [cost.length + 1];
        for (int i=2; i<=cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
        
        // constant space
        int downOne = 0;
        int downTwo = 0;
        for (int i=2; i<=cost.length; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp;
        }
        return downOne;
    }
}

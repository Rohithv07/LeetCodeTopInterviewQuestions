We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 

Example 1:



Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
Output: 120
Explanation: The subset chosen is the first and fourth job. 
Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
Example 2:



Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
Output: 150
Explanation: The subset chosen is the first, fourth and fifth job. 
Profit obtained 150 = 20 + 70 + 60.
Example 3:



Input: startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
Output: 6
 

Constraints:

1 <= startTime.length == endTime.length == profit.length <= 5 * 104
1 <= startTime[i] < endTime[i] <= 109
1 <= profit[i] <= 104



class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int [][] job = new int [n][3];
        for (int i=0; i<n; i++) {
            job[i][0] = startTime[i];
            job[i][1] = endTime[i];
            job[i][2] = profit[i];
        }
        Arrays.sort(job, (a, b) -> Integer.compare(a[1], b[1]));
        int [] dp = new int [n];
        dp[0] = job[0][2];
        for (int i=1; i<n; i++) {
            int currentProfit = job[i][2];
            int l = search(i, job);
            if (l != -1) {
                currentProfit += dp[l];
            }
            dp[i] = Math.max(dp[i - 1], currentProfit);
        }
        return dp[n - 1];
    }
    
    public int search(int index, int [][] job) {
        int start = 0;
        int end = index - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (job[mid][1] <= job[index][0]) {
                if (job[mid + 1][1] <= job[index][0]) {
                    start = mid + 1;
                }
                else {
                    return mid;
                }
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
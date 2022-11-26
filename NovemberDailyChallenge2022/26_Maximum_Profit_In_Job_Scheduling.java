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
        int length = startTime.length;
        int [][] jobs = new int [length][3];
        for (int i=0; i<length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (job1, job2) -> Integer.compare(job1[1], job2[1]));
        int [] profitDp = new int [length];
        profitDp[0] = jobs[0][2];
        for (int i=1; i<length; i++) {
            int currentProfit = jobs[i][2];
            int nextIndex = binarySearch(i, jobs);
            if (nextIndex != -1) {
                currentProfit += profitDp[nextIndex];
            }
            profitDp[i] = Math.max(profitDp[i - 1], currentProfit);
        }
        return profitDp[length - 1];
    }
    
    public int binarySearch(int i, int [][] jobs) {
        int low = 0;
        int high = i - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (jobs[middle][1] <= jobs[i][0]) {
                if (jobs[middle + 1][1] <= jobs[i][0]) {
                    low = middle + 1;
                }
                else {
                    return middle;
                }
            }
            else {
                high = middle - 1;
            }
        }
        return -1;
    }
}
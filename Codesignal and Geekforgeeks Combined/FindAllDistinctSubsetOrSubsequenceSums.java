Given a set of integers, find all distinct sums that can be generated from the subsets of the given sets.
 

Example 1:

Input: nums = {1,2}
Output: {0,1,2,3}
Explanation: Four distinct sums can be
calculated which are 0, 1, 2 and 3.
0 if we do not choose any number.
1 if we choose only 1.
2 if we choose only 2.
3 if we choose 1 and 2.

Example 2:

Input: nums = {1,2,3}
Output: {0,1,2,3,4,5,6}
Explanation: Seven distinct sum can be calculated
which are 0, 1, 2, 3, 4, 5 and 6.
0 if we do not choose any number.
1 if we choose only 1.
2 if we choose only 2.
3 if we choose only 3.
4 if we choose 1 and 3.
5 if we choose 2 and 3.
6 if we choose 1, 2 and 3.

 

Your Task:
You don't need to read or print anything. Your task is to complete the function DistinictSum() which takes nums as input parameter and returns a list containing the distinict sum in increasing order,
 

Expected Time Complexity: O(n * sum) where sum = sum of all elements of nums.
Expected Space Complexity: O(n * sum)
 

Constraints:
1 <= length of nums <= 102
1 <= nums[i] <= 102



class Solution
{
    public int[] DistinctSum(int[] nums)
    {
        // Code here
        int length = nums.length;
        int [][] dp = new int [length][10000]; // there are only 100 elements and max element will be 100
        Set<Integer> trackSum = new HashSet<>();
        findAllSum(dp, length, 0, 0, nums, trackSum);
        int [] result = new int [trackSum.size()];
        int index = 0;
        for (int num : trackSum) {
            result[index++] = num;
        }
        Arrays.sort(result);
        return result;
    }
    
    private void findAllSum(int [][] dp, int n, int index, int sum, int [] nums, Set<Integer> trackSum) {
        if (index >= n) {
            trackSum.add(sum);
            return;
        }
        if (dp[index][sum] != 0) {
            return;
        }
        findAllSum(dp, n, index + 1, sum + nums[index], nums, trackSum);
        findAllSum(dp, n, index + 1, sum, nums, trackSum);
        dp[index][sum] = 1; // 0, 1 means its marked or not marked
    }
}
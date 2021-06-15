You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

 

Example 1:


Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:

Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks.
 

Constraints:

1 <= matchsticks.length <= 15
0 <= matchsticks[i] <= 109




/*
The idea is that, we need to have total sum divdies by 4, so that we can divide the array into 2 parts with each having equal sum.
Now each of the stick can be put in any of the 4 side available check for any of the configuration that may form a square using the normal dfs recursion 

O(N logN + 4 ^ N) time complexity
O(N) space complexity. Please correct this if it is wrong
*/

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int length = matchsticks.length;
        if (length < 4)
            return false;
        int sum = 0;
        for (int sticks : matchsticks) {
            sum += sticks;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(matchsticks, 0, sum / 4, new int [4]);
    }
    
    public boolean dfs(int [] matchsticks, int index, int target, int [] squareSum) {
        if (index == matchsticks.length) {
            if (target == squareSum[0] && target == squareSum[1] && target == squareSum[2])
                return true;
            return false;
        }
        // current stick can be placed in any of the 4 sides
        for (int i=0; i<4; i++) {
            if (squareSum[i] + matchsticks[index] > target)
                continue;
            squareSum[i] += matchsticks[index];
            if(dfs(matchsticks, index+1, target, squareSum))
                return true;
            squareSum[i] -= matchsticks[index];
        }
        return false;
    }
    
    public void reverse(int [] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

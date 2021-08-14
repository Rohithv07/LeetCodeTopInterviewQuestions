You are given several boxes with different colors represented by different positive numbers.

You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.

Return the maximum points you can get.

 

Example 1:

Input: boxes = [1,3,2,2,2,3,4,3,1]
Output: 23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 points) 
----> [1, 3, 3, 3, 1] (1*1=1 points) 
----> [1, 1] (3*3=9 points) 
----> [] (2*2=4 points)
Example 2:

Input: boxes = [1,1,1]
Output: 9
Example 3:

Input: boxes = [1]
Output: 1
 

Constraints:

1 <= boxes.length <= 100
1 <= boxes[i] <= 100


class Solution {
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0)
            return 0;
        int length = boxes.length;
        int [][][] dp = new int [length][length][length];
        return memo(boxes, 0, length-1, 0, dp);
    }
    
    public int memo(int [] boxes, int i, int j, int k, int [][][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][k] > 0) {
            return dp[i][j][k];
        }
        int startingI = i;
        int startingK = k;
        for (; i+1<=j && boxes[i+1] == boxes[i]; i++, k++);
        int result = (k + 1) * (k + 1) + memo(boxes, i+1, j, 0, dp);
        for (int m=i+1; m<=j; m++) {
            if (boxes[i] == boxes[m]) {
                result = Math.max(result, memo(boxes, i+1, m-1, 0, dp) + memo(boxes, m, j, k+1, dp));
            }
        }
        dp[startingI][j][startingK] = result;
        return result;
    }
}

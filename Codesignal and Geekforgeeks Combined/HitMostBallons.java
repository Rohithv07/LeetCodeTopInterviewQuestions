You are given an infinite two-dimensional grid. There are N balloons placed at certain coordinates of the grid. You have an arrow with yourself, which you will be using to shoot the balloons. You can select any point on the grid as your starting point and any point on the grid as the target point. When you fire the arrow, all ballons lying on the shortest path between the starting point and target point will be burst. Given the coordinates of the N ballons in an array arr, your task is to find out the maximum number of balloons that you can fire in one arrow shot.

Example 1:

Input:
N = 3
arr[] = {{1, 2}, {2, 3}, {3, 4}}
Output:
3
Explanation:
If you position yourself at point (1,2)
and fire the arrow aiming at the point (3,4).
Then all the balloons will burst.
Example 2:

Input: 
N = 3
arr[] = {{2,2}, {0,0}, {1,2}} 
Output:
2
Explanation: 
If you position yourself at point (2,2)
and fire the arrow aiming at the point (0,0).
Then the two balloons present at the two points
will burst.
Your Task:
Complete the function mostBalloons() which takes the integers N and the array arr as the input parameters, and returns the maximum number of balloons that can be burst using one arrow.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
-109 ≤ arr[i][j] ≤ 109

class Solution {
    public int mostBalloons(int n, int points[][]) {
        if (points == null) return 0;
        int length = points.length;
        if (length <= 2) return length;
        int result = 0;
        for (int i = 0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<>();
            int count = 1;
            int same = 0;
            for (int j = 0;j<points.length;j++){
                //pick non matching points
                if(j != i){
                    //first point
                    int firstX = points[i][0];
                    int firstY = points[i][1];
                    
                    //second point
                    int secondX = points[j][0];
                    int secondY = points[j][1];
                    
                    //if both points are same, increment same points
                    if (firstX == secondX && firstY == secondY){ 
                        same++;
                        continue;
                    }
                    //if only x is different increment count
                    if (firstX == secondX) {
                        count++;                    
                        continue;
                    }
                    //for different points put in map the y/x
                    double k = (double)(secondY - firstY) / (double)(secondX - firstX);
                    map.put(k, map.getOrDefault(k, 1)+1);
                    //compute max with map value with number of same points
                    result = Math.max(result, map.get(k) + same);
                }
            }
            //update the result
            result = Math.max(result, count);
        }
        return result;
    }
}
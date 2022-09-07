// https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

// https://www.youtube.com/watch?v=AE39gJYuRog&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=8



/*
1. Identify the index
2. Do the stuffs on that index
3. Take out maximum or minimum as per the question

1. Identify the index : Here the question says, each day the ninja 
is going to perform some tasks for sure. So the day can be an index here. But it alone cannot do the job. We have one more thing to make sure. We cannot do the same activiy that we have done at the last. So we also need to add another index lastActivity which indicates the last activity we have done.

2&3. Do the stuffs on that index and take max : 
f(dayIndex, lastActivity) : this means, from 0 to day what is the maximum point the ninja have earned if the last done activity is lastActivity.

our base case will be ofcourse dayIndex == 0, at that case, we need to consider the maximum skipping the last done activity.

For all other cases, we justconsider all the three activity and skip tha last done activity, then take the maximum point.

This recursive approach will surely give time limit exceeded


0 - 0th activity
1 - 1st activity
2 - 2nd activity
3 - 3rd activity - which means we haven't done any activity and we are yet to start

*/



public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        return findMaximumPoints(n - 1, 3, points);
        
    }
    
    private static int findMaximumPoints(int day, int lastActivity, int [][] points) {
        if (day < 0) {
            return 0;
        }
        int maximumPoint = 0;
        if (day == 0) {
            for (int  task= 0; task < 3; task++) {
                if (task != lastActivity) {
                    maximumPoint = Math.max(maximumPoint, points[0][task]);
                }
            }
            return maximumPoint;
        }
        for (int task = 0; task < 3; task++) {
            if (task != lastActivity) {
                int currentPoint = points[day][task] + findMaximumPoints(day - 1, task, points);
                maximumPoint = Math.max(maximumPoint, currentPoint);
            }
        }
        return maximumPoint;
    }

}




/*
After drawing the recurrance relation for a sample example, we could see many overlapping subproblems, so our recursion can be converted to a memoization approach.

Just do dp[ind][ind] at the return statement and also do a check like dp[index][index] != -1

Here our index will be day and the lastActivity and dp will be of size n X 4 as there can be maximum of n elements and 4 activities
0 - 0th activity
1 - 1st activity
2 - 2nd activity
3 - 3rd activity - which means we haven't done any activity and we are yet to start


TC : O(N) * O(4) * O(3)
SC : O(N) * O(4) + O(Stack Space)

*/


public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [][] dp = new int [n][4];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
            dp[i][2] = -1;
            dp[i][3] = -1;
        }
        return findMaximumPoints(n - 1, 3, points, dp);
    }

    private static int findMaximumPoints(int day, int lastActivity, int [][] points, int [][] dp) {
        if (day < 0) {
            return 0;
        }
        int maximumPoints = 0;
        if (day == 0) {
            for (int task = 0; task < 3; task++) {
                if (task != lastActivity) {
                    maximumPoints = Math.max(maximumPoints, points[0][task]);
                }
            }
            return maximumPoints;
        }
        if (dp[day][lastActivity] != -1) {
            return dp[day][lastActivity];
        }
        for (int task = 0; task < 3; task++) {
            if (task != lastActivity) {
                int currentPoint = points[day][task] + findMaximumPoints(day - 1, task, points, dp);
                maximumPoints = Math.max(maximumPoints, currentPoint);
            }
        }
        return dp[day][lastActivity] = maximumPoints;
    }
}


/*

Now we can do the tabulation.
Its more like copy pasting the memoization code replacing the function with dp.
ie replacing f(day - 1, task, points, dp) with dp[day - 1][task]

TC : O(N * 4 * 3)
SC : O(N * 4)

*/


import java.util.*;

public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [][] dp = new int [n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        int currentPoint = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(currentPoint, dp[day][last]);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

}


/*

We can make one observation that, we only needed the previous days values. We don't want to know about any data other than the previous. No previous previus record, no previous previous previous record. Just the previous days record. So we just need dp[4] extra space to do this problem.

TC : O(N * 4 * 3)

SC : O(4) - optimised

*/



public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int [] dp = new int [4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            // just to preseve the previous days values
            int [] temp = new int [4];
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if (last != task) {
                        temp[last] = Math.max(temp[last], points[day][task] + dp[task]);
                    }
                }
            }
            // store the current days value and use it for the next day
            dp = temp;
        }
        return dp[3];
    }

}








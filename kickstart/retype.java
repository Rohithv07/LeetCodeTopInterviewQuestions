After spending many hours studying for programming competitions, you decided to take a rest and play video games. You are currently playing an adventure game called Quick Start.

This game has N levels, and you are currently on the K-th level. Unfortunately, you just realized that to beat the boss at the final level, you will need a special sword, which can be picked up at level S. You have already completed that level, but you forgot to pick up the sword at that level.

Now you want to pick up the sword and finish the game in the least amount of time possible, and for that you have two options:

Restart the game and complete all levels again, starting from level 1.
Move to previous levels until you reach level S, pick up the sword and complete all the remaining levels, starting from level S.
Every time you enter a level you have to exit it, either by completing it and going to the next level or by moving to a previous level or by finishing / exiting the game. Exiting any level takes 1 minute. That means, for example, that it took you L minutes to complete the first L levels.

Your task is to discover which option would result in the least amount of total time to finish the game (including the time you have already spent).

Input
The first line of the input gives the number of test cases, T. T test cases follow.

The first (and only) line of each test case contains three integers N, K and S: the number of levels in the game, the current level you are in, and the level where you have to pick up the sword, respectively.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the least amount of total time to finish the game.

Limits
Time limit: 20 seconds.
Memory limit: 1 GB.
1 ≤ T ≤ 100.
1 ≤ S < K < N.
Test Set 1
N ≤ 1000.
Test Set 2
N ≤ 109.
Sample

Input
 	
Output
 
2
10 5 2
10 7 6

  
Case #1: 15
Case #2: 12

  
In Sample Case #1, it took you 4 minutes to complete the first 4 levels and enter 5-th level. Restarting the game and completing all levels again would take 11 more minutes (1 minute to restart and 10 to complete 10 levels), which adds up to 15 minutes. The other option would be to move backwards until you reach level 2 (which would take 3 minutes), and then complete all the remaining levels (taking 9 more minutes), which would result in a total of 16 minutes.

In Sample Case #2, it took you 6 minutes to complete the first 6 levels and enter 7-th level. Moving backwards until reaching level 6 (one minute), and then completing all the remaining levels (5 minutes), would take a total of 12 minutes to finish the game.

import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i=1; i<=test; i++) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long s = sc.nextLong();
            long timeToReachK = k - 1;
            long diff = k - s;
            long remaining = n - s;
            long timeAfterExiting = k + n;
            long timeWithoutExiting = diff + timeToReachK + remaining + 1;
            long finalAnswer = Math.min(timeAfterExiting, timeWithoutExiting);
            System.out.println("Case #" + i + ": " + finalAnswer);
            
        }
    }
}

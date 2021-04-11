/*
You and your friend are playing a game. In this game, there are piles of pennies in front of you given by an array piles where piles[i] represents the total number of pennies in the ith pile. In this game, you and your friend take turns removing a pile from the beginning or end of piles. Once all the pennies are gone, the person who has gathered the most pennies wins. Given that you move first, return whether or not you can win assuming that you and your friend are both playing optimally.
Note: The total number of piles is even, the total number of pennies is odd, and there is always guaranteed to be a winner.

Ex: Given the following piles…

piles = [2, 1, 4, 4], return true.
Ex: Given the following piles…

piles = [2, 1, 4, 9, 3, 8], return true.

Leetcode : Stone Game
*/

import java.util.*;

public class PennyPicking {

	public static boolean stoneGame(int [] nums) {
		// an array to calculate prefix sum
		int length = nums.length;
		int [] sum = new int [length];
		// cache to do memoisation
		int [][] cache = new int [length][length];
		sum[0] = nums[0];
		for (int i=1; i<length; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
		int myPoint = findMyPoint(nums, sum, cache, 0, length - 1);
		return myPoint > sum[length - 1] - myPoint;
	}	

	public static int findMyPoint(int [] nums, int [] sum, int [][] cache, int start, int end) {
		if (start > end)
			return 0;
		if (cache[start][end] != 0)
			return cache[start][end];
		int currentSum = sum[end] - sum[start] + nums[start];
		int point = currentSum - Math.min(findMyPoint(nums, sum, cache, start + 1, end), findMyPoint(nums, sum, cache, start, end - 1));
		cache[start][end] = point;
		return point;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] nums = new int [n];
		for (int i=0; i<n; i++) {
			nums[i] = sc.nextInt();		
		}
		System.out.println(stoneGame(nums));
	}
}

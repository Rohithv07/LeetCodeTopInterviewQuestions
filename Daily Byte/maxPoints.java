This question is asked by Google. You are given a bag of coins, an initial energy of E, and want to maximize your number of points (which starts at zero). To gain a single point you can exchange coins[i] amount of energy (i.e. if I have 100 energy and a coin that has a value 50 I can exchange 50 energy to gain a point). If you do not have enough energy you can give away a point in exchange for an increase in energy by coins[i] amount (i.e. you give away a point and your energy is increased by the value of that coin: energy += coins[i]). Return the maximum number of points you can gain.
Note: Each coin may only be used once.

Ex: Given the following coins and starting energy…

coins = [100, 150, 200] and E = 150, return 1
coins = [100,200,300,400] and E = 200, return 2
coins = [300] and E = 200, return 0

// I considered the array is alreadt sorted
import java.util.*;
public class Solution {
	public int bagOfTokensScore(int[] tokens, int P) {
		if (tokens.length == 1 && tokens[0] > P)
		    return 0;
		Arrays.sort(tokens);
		int score = 0;
		int maxScore = 0;
		int left = 0;
		int right = tokens.length - 1;
		while (left <= right) {
		    if (P >= tokens[left]) {
			score ++;
			P -= tokens[left++];
			maxScore = Math.max(maxScore, score);
		    }
		    else if (score > 0) {
			score --;
			P += tokens[right--];
		    }
		    else
			return maxScore;
		}
		return maxScore;
    }
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] coins = new int [n];
		for (int i=0; i<n; i++)
			coins[i] = sc.nextInt();
		int energy = sc.nextInt();
		System.out.println(maxPoints(coins, energy));
	}
}

This question is asked by Google. You are given a bag of coins, an initial energy of E, and want to maximize your number of points (which starts at zero). To gain a single point you can exchange coins[i] amount of energy (i.e. if I have 100 energy and a coin that has a value 50 I can exchange 50 energy to gain a point). If you do not have enough energy you can give away a point in exchange for an increase in energy by coins[i] amount (i.e. you give away a point and your energy is increased by the value of that coin: energy += coins[i]). Return the maximum number of points you can gain.
Note: Each coin may only be used once.

Ex: Given the following coins and starting energy…

coins = [100, 150, 200] and E = 150, return 1
coins = [100,200,300,400] and E = 200, return 2
coins = [300] and E = 200, return 0

// I considered the array is alreadt sorted
import java.util.*;
public class Solution {
	public static int maxPoints(int [] coins, int energy) {
		int length = coins.length;
		if (coins.length == 1 && energy < coins[0])
			return 0;
		int points = 0;
		energy += coins[length-1];
		points -= 1;
		for (int i=0; i<coins.length; i++) {
			if (energy >= coins[i]) {
				energy -= coins[i];
				points += 1;
			}
			else
				return points;
		}
		return 0;

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

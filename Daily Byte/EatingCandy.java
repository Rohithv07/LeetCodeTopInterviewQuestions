/*
You are given a certain number of candies and an exchange rate. For every exchange number of candy wrappers that you trade in, you receive an additional candy. Return the maximum number of candies that you can eat.
Note: Each candy is wrapped in a candy wrapped.

Ex: Given the following candies and exchange…

candies = 3, exchange = 3, return 4 (each your three candies, exchange 3 wrappers, each additional candy).
Ex: Given the following candies and exchange…

candies = 3, exchange = 4, return 3.
*/

// candies += (candies - 1 / wrapper - 1)

import java.util.*;

public class EatingCandy {

	public static int numberOfCandies(int candies, int wrapperExchane) {
		if (candies < wrapperExchane) {
			return candies;
		}
		candies += ((candies - 1) / (wrapperExchane - 1));
		return candies;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int candies = sc.nextInt();
		int wrapperExchane = sc.nextInt();
		System.out.println(numberOfCandies(candies, wrapperExchane));
	}
}
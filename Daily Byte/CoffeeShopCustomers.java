/*
You walk into a coffee shop that serves all of the given customers. At the ith minute, customers[i] customers are in the shop. The barista is stressed at the ith minute if stressed[i] = 1 and calm otherwise. Customers that are in the shop while the barista is stressed are unhappy. Customers that are in the shop while the barista is not stressed are happy. The barista knows how to remain calm for a duration of minutes, but can only do so once. Return the maximum number of customers that can be happy.

Ex: Given the following customers, stressed, and duration…

customers = [3, 1, 2], stressed = [1, 0, 0], duration = 1, return 6 (the barista can remain calm for the first minute making all the customers happy 3 + 1 + 2 = 6).
Ex: Given the following customers, stressed, and duration…

customers = [5, 2, 4, 3], stressed = [1, 1, 0, 1], duration = 2, return 11 (5 + 2 + 4).
*/

import java.util.*;

public class CoffeeShopCustomers {

	public static int countHappy(int [] customers, int [] stressed, int duration, int n) {
		int countOne = 0;
		// for (int number : stressed) {
		// 	countOne += number;
		// }
		// int remaining = countOne - duration;
		int start = 0;
		int window = 0;
		for (int end = 0; end < customers.length; end++) {
			if (stressed[end] == 1) {
				countOne += 1;
			}
			if (countOne > duration) {
				while (customers[start] == 0)
			}
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] customers = new int [n];
		int [] stressed = new int [n];
		for (int i=0; i<n; i++) {
			customers[i] = sc.nextInt();
		}
		for (int i=0; i<n; i++) {
			stressed[i] = sc.nextInt();
		}
		int duration = sc.nextInt();
		System.out.println(countHappy(customers, stressed, duration, n));
	}
}
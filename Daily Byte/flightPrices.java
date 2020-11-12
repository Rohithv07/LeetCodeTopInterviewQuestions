This question is asked by Google. A company is booking flights to send its employees to its two satellite offices A and B. The cost of sending the I<sup>th</sup> employee to office A and office B is given by prices[i][0] and prices[i][1] respectively. Given that half the employees must be sent to office A and half the employees must be sent to office B, return the minimum cost the company must pay for all their employees’ flights.

Ex: Give the following prices…

prices = [[40,30],[300,200],[50,50],[30,60]], return 310
Fly the first personn to office B.
Fly the second person to office B.
Fly the third person to office A.
Fly the fourth person to office B.


// considering everytime the rows will be even only
import java.util.*;
public class Solution {
	public static int findPrice(int [][] flight) {
		Arrays.sort(flight, (a, b) -> a[0] - b[0]);
		int row = flight.length;
		int a = 0;
		int b = 0;
		int totalPrice = 0;
		int capacity = row / 2;
		for (int [] price: flight) {
			if (a == b && a != capacity && price[0] <= price[1]) {
				a += 1;
				totalPrice += price[0];
			}
			else if (a == b && b != capacity && price[1] <= price[0]) {
				b += 1;
				totalPrice += price[1];
			}
			else if (a == capacity && b != capacity) {
				b += 1;
				totalPrice += price[1];
			}
			else if (b == capacity && a != capacity) {
				a += 1;
				totalPrice += price[0];
			}
			else if (a != capacity && b != capacity) {
				int minimum = Math.min(price[0], price[1]);
				totalPrice += minimum;
				if (minimum == price[0])
					a += 1;
				else 
					b += 1;
			}
		}
		return a == b ? totalPrice : 0;

	}
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] flight = new int [n][2];
        for (int i=0; i<n; i++) {
            flight[i][0] = sc.nextInt();
            flight[i][1] = sc.nextInt();
        }
		System.out.println(findPrice(flight)); 
	}
}
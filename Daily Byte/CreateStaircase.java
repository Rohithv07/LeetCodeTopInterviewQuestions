/*
Given a value, N, you are asked to form a staircase. The number of elements in each row of the staircase must match the current row. Return the total number of full staircase rows you can create.

Ex: Given the following N...

N = 3 return 2.
*
* * (this staircase has two rows)
Ex: Given the following N...

N = 7 return 3.
*
* *
* * *
* (this row is not full)
*/

import java.util.*;

public class CreateStaircase {

	public static void printTheStair(int n) {
		if (n == 0)
			return;
		int count = 0;
		int row = 1;
		int total = 0;
		while (total < n) {
			while (count < row && total < n) {
				System.out.print("*" + " ");
				count++;
				total++;
			}
			row++;
			count = 0;
			System.out.println();
		}
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printTheStair(n);
	}
}
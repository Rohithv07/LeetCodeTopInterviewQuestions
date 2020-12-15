/*
This question is asked by Amazon. You are at a birthday party and are asked to distribute cake to your guests. Each guess is only satisfied if the size of the piece of cake they’re given, matches their appetite (i.e. is greater than or equal to their appetite). Given two arrays, appetite and cake where the ithelement of appetite represents the ith guest’s appetite, and the elements of cake represents the sizes of cake you have to distribute, return the maximum number of guests that you can satisfy.

Ex: Given the following arrays appetite and cake…

appetite = [1, 2, 3], cake = [1, 2, 3], return 3.
Ex: Given the following arrays appetite and cake…

appetite = [3, 4, 5], cake = [2], return 0.
*/

import java.util.*;

public class BirthdayCake {

	public static int numberOfGuest(int [] appetite, int [] cake) {
		int cakeLength = cake.length;
		int appetiteLength = appetite.length;
		int countGuest = 0;
		int index = 0;
		while (index < cakeLength && index < appetiteLength) {
			if (appetite[index] <= cake[index])
				countGuest += 1;
			index += 1;
		}
		return countGuest;
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int cakeLength = sc.nextInt();
		int appetiteLength = sc.nextInt();
		int [] cake = new int [cakeLength];
		int [] appetite = new int [appetiteLength];
		for (int i=0; i<cakeLength; i++)
			cake[i] = sc.nextInt();
		for (int i=0; i<appetiteLength; i++)
			appetite[i] = sc.nextInt();
		System.out.println(numberOfGuest(appetite, cake));
	}
}
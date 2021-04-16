/*
Given a sorted character array, letters, and a character, target, return the smallest character in letters that is strictly larger than target.
Note: Letters wrap around. If target is ’y’ and letters contains ’c’ and ’d’, return ’c’.
Ex: Given the following letters and target…

letters = ['a', 'b', 'c'], target = 'b', return 'c'.
Ex: Given the following letters and target…

letters = ['r', 'y'], target = 'z', return 'r'.
*/

import java.util.*;

public class NextLetter {

	public static char findTheNextLetter(char [] letters, char target, int n) {
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int middle = left + (right - left) / 2;
			if (letters[middle] > target)
				right = middle - 1;
			else
				left = middle + 1;
		}
		return letters.length == left ? letters[0] : letters[left];
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char [] letters = new char[n];
		for (int i=0; i<n; i++) {
			letters[i] = sc.next().charAt(0);
		}
		char target = sc.next().charAt(0);
		System.out.println(findTheNextLetter(letters, target, n));
	}
}

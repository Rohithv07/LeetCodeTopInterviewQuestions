This question is asked by Apple. You are serving people in a lunch line and need to ensure each person gets a “balanced” meal. A balanced meal is a meal where there exists the same number of food items as drink items. Someone is helping you prepare the meals and hands you food items (i.e. F) or a drink items (D) in the order specified by the items string. Return the maximum number of balanced meals you are able to create without being able to modify items.
Note: items will only contain F and D characters.

Ex: Given the following items…

items = "FDFDFD", return 3
the first "FD" creates the first balanced meal.
the second "FD" creates the second balanced meal.
the third "FD" creates the third balanced meal.
Ex: Given the following items…

items = "FDFFDFDD", return 2
"FD" creates the first balanced meal.
"FFDFDD" creates the second balanced meal.

import java.util.*;
public class Solution {
	public static int howManyBalancedMeal(String s) {
		int length = s.length();
		int item = 0;
		int balancedCount = 0;
		// if F, add 1 to the item and if D, subtract 1 and everytime whether we have a balanced meal or not check
		for (char ch: s.toCharArray()) {
			if (ch == 'F') {
				item += 1;
				if (item == 0)
					balancedCount += 1;
			}
			else {
				item -= 1;
				if (item == 0)
					balancedCount += 1;
			}
		}
		return balancedCount;
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(howManyBalancedMeal(s));
	}
}
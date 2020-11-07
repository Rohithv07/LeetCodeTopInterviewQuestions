This question is asked by Amazon. You’re running a popsicle stand where each popsicle costs $5. Each customer you encountered pays with either a $5 bill, a $10 bill, or a $20 bill and only buys a single popsicle. the customers that come to your stand come in the ordered given by the customers array where customers[i] represents the bill the ith customer pays with. Starting with $0, return whether or not you can serve all the given customers while also giving the correct amount of change.

Ex: Given the following customers…

customers = [5, 10], return true
collect $5 from the first customer, pay no change.
collet $10 from the second customer and give back $5 change.

Ex: Given the following customers…

customers = [10], return false
collect $10 from the first customer and we cannot give back change.

Ex: Given the following customers…

customers = [5,5,5,10,20], return true
collect $5 from the first 3 customers.
collet $10 from the fourth customer and give back $5 change.
collect $20 from the fifth customer and give back $10 change ($10 bill and $5 bill).

import java.util.*;
public class Solution {
	public static boolean canServe(int [] customers) {
		int length = customers.length;
		if (customers[0] == 10 || customers[0] == 20)
			return false;
		int availableBalance = 0;
		for (int i=0; i<length; i++) {
			int currentPaid = customers[i];
			if (currentPaid == 5) {
				availableBalance += currentPaid;
			}
			else if (currentPaid == 10 || currentPaid == 20) {
				currentPaid -= 5;
				availableBalance += 5;
				if (currentPaid > availableBalance)
					return false;
				availableBalance -= currentPaid;

			}
		}
		return true;
		
	}
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] customers = new int [n];
		for (int i=0; i<n; i++)
			customers[i] = sc.nextInt();
		System.out.println(canServe(customers));
	}
}

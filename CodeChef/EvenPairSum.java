You are given two positive integers A and B. Find the number of pairs of positive integers (X,Y) such that 1≤X≤A, 1≤Y≤B and X+Y is even.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains two space-separated integers A and B.
Output
For each test case, print a single line containing one integer ― the number of valid pairs.

Constraints
1≤T≤1,000
1≤A,B≤109
Subtasks
Subtask #1 (10 points): A,B≤10
Subtask #2 (10 points): A,B≤1,000
Subtask #3 (80 points): original constraints

Example Input
4
1 1
2 3
4 6
8 9
Example Output
1
3
12
36


import java.util.*;

class EvenPairSum {

	public static long countPair(long number1, long number2) {
		long totalEvenForNumber1 = number1 / 2;
		long totalOddForNumber1 = (number1 + 1) / 2;
		long totalEvenForNumber2 = number2 / 2;
		long totalOddForNumber2 = (number2 + 1) / 2;

		return (totalEvenForNumber1 * totalEvenForNumber2) + (totalOddForNumber1 * totalOddForNumber2); 
	}

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			long number1 = sc.nextLong();
			long number2 = sc.nextLong();
			System.out.println(countPair(number1, number2));
		}
	}
}
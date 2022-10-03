Find the sum of all the numbers between the range l and r. Here each number is represented by the sum of its prime factors. 
Note : For example, 6 is represented by 5 because 6 has two prime factors 2 and 3 and 2 + 3 = 5.

Example 1:

Input: l = 1, r = 2
Output: 3
Explanation: 1->1, 2->2 and 1+2=3.  

Example 2:

Input: l = 1, r = 6
Output: 18
Explanation: 1->1, 2->2, 3->3, 4->2
5->5, 6->2+3=5, 1+2+3+2+5+5 = 18. 

Your Task:  
You dont need to read input or print anything. Complete the function sumOfAll() which takes l and r as input parameter and returns sum all the numbers ( as represented ) in the given range both L and R included.

Expected Time Complexity: O(nloglogn)
Expected Auxiliary Space: O(n)

Constraints:
1 <= l <= r <=104



//User function Template for Java
class Solution
{
    public int sumOfAll(int l, int r) {

		int sum = 0;

		int i = l;

		for (; i <= 3 && i <= r; i++) {

			sum += i;

		}

		for (; i <= r; i++) {

			sum += findEvenPrimeSum(i);

		}

		return sum;

	}



	private int findEvenPrimeSum(int i) {

		int sum = 0;

		if (i % 2 == 0) {

			sum += 2;

		}

		while (i % 2 == 0) {

			i = i / 2;

		}

		for (int k = 3; k <= Math.sqrt(i); k += 2) {

			if (i % k == 0) {

				sum += k;

			}

			while (i % k == 0) {

				i = i / k;

			}

		}

		if (i > 2) {

			sum += i;

		}

		return sum;

	}
}
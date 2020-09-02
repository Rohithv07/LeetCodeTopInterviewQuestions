Given an array A of N positive integers. Find the sum of maximum sum increasing subsequence of the given array.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N(the size of array). The second line of each test case contains array elements.

Output:
For each test case print the required answer in new line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106
1 ≤ Ai ≤ 106

Example:
Input:
2
7
1 101 2 3 100 4 5
4
10 5 4 3

Output:
106
10

Explanation:
Testcase 1: All the increasing subsequences are : (1,101); (1,2,3,100); (1,2,3,4,5). Out of these (1, 2, 3, 100) has maximum sum,i.e., 106.

Solution:

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int maximumSum(int [] array, int n) {
        int [] dp = new int[n];
        for (int i=0; i<n; i++)
            dp[i] = array[i];
        int maximum = 0;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
            if (array[i] > array[j] && dp[i] < dp[j]+array[i])
                dp[i] = dp[j] + array[i];
            }
        }
        for (int i=0; i<dp.length; i++) {
            if (maximum < dp[i])
                maximum = dp[i];
        }
        return maximum;
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-- > 0) {
		    int n = sc.nextInt();
		    int [] array = new int[n];
		    for (int i=0; i<n; i++) {
		        array[i] = sc.nextInt();
		    }
		    System.out.println(maximumSum(array, n));
		}
	}
}

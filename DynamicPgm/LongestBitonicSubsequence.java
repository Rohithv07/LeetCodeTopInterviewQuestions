Given an array of positive integers. The task is to print the maximum length of Bitonic subsequence. 
a subsequenceof array is called Bitonic if it is first increasing, then decreasing.

Input:
First line contains T test cases. First line of every test case consists of N , denoting number of elements in an array. Second line of every test consists of elements in array.

Output:
For each testcase, in a new line, print the length of longest bitonic sequence.

Constraints:
1<=T<=100
1<=N<=100
1<=Ai<=200

Example:
Input:
2
5
1 2 5 3 2
8
1 11 2 10 4 5 2 1
Output:
5
6


Solution:

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int bitonic(int [] array) {
        int n = array.length;
        int [] dpIncreasing = new int [array.length];
        int [] dpDecreasing = new int [array.length];
        for (int i=0; i<array.length; i++) 
            dpIncreasing[i] = 1;
        for (int i=1; i<array.length; i++) {
            for (int j=0; j<i; j++) {
                if (array[i]>array[j] && dpIncreasing[i]<dpIncreasing[j]+1)
                    dpIncreasing[i] = dpIncreasing[j]+1;
            }
        }
        for (int i=0; i<array.length; i++)
            dpDecreasing[i] = 1;
        // Do the same as above but in reverse
        for (int i=n-2; i>=0; i--) {
            for (int j=n-1; j>i; j--) {
                if(array[i]>array[j] && dpDecreasing[i]<dpDecreasing[j]+1)
                    dpDecreasing[i] = dpDecreasing[j]+1;
            }
        }
        int maximum = dpIncreasing[0] + dpDecreasing[0] - 1;
        for (int i=0; i<array.length; i++) {
            if (maximum < dpIncreasing[i]+dpDecreasing[i]-1)
                maximum = dpIncreasing[i]+dpDecreasing[i]-1;
        }
        return maximum;
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
		    int n = sc.nextInt();
		    int [] inputArray = new int[n];
		    for (int i=0; i<n; i++) {
		        inputArray[i] = sc.nextInt();
		    }
		    System.out.println(bitonic(inputArray));
		}
	}
}

You have n barrels lined up in a row, numbered from left to right from one. Initially, the i-th barrel contains ai liters of water.

You can pour water from one barrel to another. In one act of pouring, you can choose two different barrels x and y (the x-th barrel shouldn't be empty) and pour any possible amount of water from barrel x to barrel y (possibly, all water). You may assume that barrels have infinite capacity, so you can pour any amount of water in each of them.

Calculate the maximum possible difference between the maximum and the minimum amount of water in the barrels, if you can pour water at most k times.

Some examples:

if you have four barrels, each containing 5 liters of water, and k=1, you may pour 5 liters from the second barrel into the fourth, so the amounts of water in the barrels are [5,0,5,10], and the difference between the maximum and the minimum is 10;
if all barrels are empty, you can't make any operation, so the difference between the maximum and the minimum amount is still 0.
Input
The first line contains one integer t (1≤t≤1000) — the number of test cases.

The first line of each test case contains two integers n and k (1≤k<n≤2⋅105) — the number of barrels and the number of pourings you can make.

The second line contains n integers a1,a2,…,an (0≤ai≤109), where ai is the initial amount of water the i-th barrel has.

It's guaranteed that the total sum of n over test cases doesn't exceed 2⋅105.

Output
For each test case, print the maximum possible difference between the maximum and the minimum amount of water in the barrels, if you can pour water at most k times.

Example
inputCopy
2
4 1
5 5 5 5
3 2
0 0 0
outputCopy
10
0



import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            Long [] array = new Long [n];
            for (int i=0; i<n; i++)
                array[i] = sc.nextLong();
            Arrays.sort(array);
            int steps = 0;
            long max = array[n-1];
            while (steps < k) {
                // update the maximum with the maximum element, next maximum, next maximum and so on
                max += array[n-2-steps];
                steps += 1;
            }
            System.out.println(max);
        }
    }
}
   

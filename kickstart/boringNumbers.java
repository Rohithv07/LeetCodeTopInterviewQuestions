Ron read a book about boring numbers. According to the book, a positive number is called boring if all of the digits at even positions in the number are even and all of the digits at odd positions are odd. The digits are enumerated from left to right starting from 1. For example, the number 1478 is boring as the odd positions include the digits {1, 7} which are odd and even positions include the digits {4, 8} which are even.

Given two numbers L and R, Ron wants to count how many numbers in the range [L, R] (L and R inclusive) are boring. Ron is unable to solve the problem, hence he needs your help.
Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line with two numbers L and R.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the count of boring numbers.

Limits
Time limit: 20 seconds.
Memory limit: 1 GB.
1 ≤ T ≤ 100.
Test Set 1
1 ≤ L ≤ R ≤ 103.
Test Set 2
1 ≤ L ≤ R ≤ 1018.
Sample

Input
 	
Output
 
3
5 15
120 125
779 783

  
Case #1: 6
Case #2: 3
Case #3: 2

  
In Sample Case #1, the numbers in the range are {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15} out of which {5, 7, 9, 10, 12, 14} are boring, hence the answer is 6.

In Sample Case #2, the numbers in the range are {120, 121, 122, 123, 124, 125} out of which {121, 123, 125} are boring, hence the answer is 3.

In Sample Case #3, the numbers in the range are {779, 780, 781, 782, 783} out of which {781, 783} are boring, hence the answer is 2.

import java.util.*;
public class Solution {
    public static long findBadNumber(long l, long r)  {
        long count = 0;
        for (long j=l; j<=r; j++) {
            long length = 0;
            long temp = j;
            while (temp > 0) {
                length += 1;
                temp = temp / 10;
            }
            boolean flag = false;
            temp = j;
            while (temp > 0) {
                long rem = temp % 10;
                if (length % 2 == 0 && rem % 2 == 0) {
                    length -= 1;
                    flag = true;
                    temp /= 10;
                }
                else if (length % 2 !=0 && rem % 2 != 0) {
                    length -= 1;
                    flag = true;
                    temp /= 10;
                }
                else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count += 1;
        }  
        return count;
    }
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i=1; i<=test; i++) {
            long L = sc.nextInt();
            long R = sc.nextInt();
            long count = findBadNumber(L, R);
            System.out.println("Case #" + i + ": " + count);
        }
    }
}

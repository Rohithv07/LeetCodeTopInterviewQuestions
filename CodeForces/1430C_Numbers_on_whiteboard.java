Numbers 1,2,3,…n (each integer from 1 to n once) are written on a board. In one operation you can erase any two numbers a and b from the board and write one integer a+b2 rounded up instead.

You should perform the given operation n−1 times and make the resulting number that will be left on the board as small as possible.

For example, if n=4, the following course of action is optimal:

choose a=4 and b=2, so the new number is 3, and the whiteboard contains [1,3,3];
choose a=3 and b=3, so the new number is 3, and the whiteboard contains [1,3];
choose a=1 and b=3, so the new number is 2, and the whiteboard contains [2].
It's easy to see that after n−1 operations, there will be left only one number. Your goal is to minimize it.

Input
The first line contains one integer t (1≤t≤1000) — the number of test cases.

The only line of each test case contains one integer n (2≤n≤2⋅105) — the number of integers written on the board initially.

It's guaranteed that the total sum of n over test cases doesn't exceed 2⋅105.

Output
For each test case, in the first line, print the minimum possible number left on the board after n−1 operations. Each of the next n−1 lines should contain two integers — numbers a and b chosen and erased in each operation.

Example
inputCopy
1
4
outputCopy
2
2 4
3 3
3 1


import java.util.*;
// here for any kind of input, the minimum number will be 2.
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test -- >0) {
            int n = sc.nextInt();
            int x = n - 1;
            int y = n;
            System.out.println("2");
            while (n-- > 1) {
                System.out.println(x + " " + y);
                y = (x + y + 1) / 2;
                x = n - 1;
            }
        }
    }
}

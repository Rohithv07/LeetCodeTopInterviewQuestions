You have a string s consisting of n characters. Each character is either 0 or 1.

You can perform operations on the string. Each operation consists of two steps:

select an integer i from 1 to the length of the string s, then delete the character si (the string length gets reduced by 1, the indices of characters to the right of the deleted one also get reduced by 1);
if the string s is not empty, delete the maximum length prefix consisting of the same characters (the indices of the remaining characters and the string length get reduced by the length of the deleted prefix).
Note that both steps are mandatory in each operation, and their order cannot be changed.

For example, if you have a string s= 111010, the first operation can be one of the following:

select i=1: we'll get 111010 → 11010 → 010;
select i=2: we'll get 111010 → 11010 → 010;
select i=3: we'll get 111010 → 11010 → 010;
select i=4: we'll get 111010 → 11110 → 0;
select i=5: we'll get 111010 → 11100 → 00;
select i=6: we'll get 111010 → 11101 → 01.
You finish performing operations when the string s becomes empty. What is the maximum number of operations you can perform?

Input
The first line contains a single integer t (1≤t≤1000) — the number of test cases.

The first line of each test case contains a single integer n (1≤n≤2⋅105) — the length of the string s.

The second line contains string s of n characters. Each character is either 0 or 1.

It's guaranteed that the total sum of n over test cases doesn't exceed 2⋅105.

Output
For each test case, print a single integer — the maximum number of operations you can perform.

Example
inputCopy
5
6
111010
1
0
1
1
2
11
6
101010
outputCopy
3
1
1
1
3
Note
In the first test case, you can, for example, select i=2 and get string 010 after the first operation. After that, you can select i=3 and get string 1. Finally, you can only select i=1 and get empty string.

import java.util.*;
public class Solution {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            char [] s = sc.next().toCharArray();
            if (s.length == 1) {
                System.out.println("1");
            }
            else {
                int count = 1;
                int consCount = 0;
                for (int i=0; i<n-1; i++) {
                    if (s[i] != s[i+1])
                        count += 1;
                    else {
                        consCount = Math.min(++consCount, count);
                    }
                }
                System.out.println(consCount +(count - consCount + 1) / 2);
            }
        }
    }
}

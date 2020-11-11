Guddu likes a girl that loves playing with numbers. She agreed to go on a date with Guddu, but only if he can solve the following problem:

An integer is round if it is greater than 0 and the sum of its digits in decimal representation is a multiple of 10. Find the N-th smallest round integer.

However, Guddu does not like playing with numbers at all and he is unable to solve this problem, so he begs you to solve it for him. In return, he will definitely give you a treat.

Input
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains a single integer N.
Output
For each test case, print a single line containing the N-th round integer. It is guaranteed that this number is smaller than 264.

Constraints
1≤T≤105
1≤N≤1018
Subtasks
Subtask #1 (30 points):

1≤T≤10
1≤N≤105
Subtask #2 (70 points): original constraints

Example Input
1
2
Example Output
28
Explanation
Example case 1: The smallest round integer is 19 and the second smallest is 28.


import java.util.*;

public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            long n = sc.nextLong();
            long temp = n;
            long sum = 0;
            if (temp > 0) {
                while (temp != 0) {
                    sum = sum + temp % 10;
                    temp /= 10;
                }
            }
            for (int i=0; i<=9; i++) {
                if ((sum + i) % 10 == 0) {
                    System.out.println(n+""+i);
                    break;
                }
            }
        }
    }
}

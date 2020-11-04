Chef has N dishes of different types arranged in a row: A1,A2,…,AN, where Ai denotes the type of the ith dish. He wants to choose as many dishes as possible from the given list but while satisfying two conditions:

He can choose only one type of dish.
No two chosen dishes should be adjacent to each other.
Chef wants to know which type of dish he should choose from, so that he can pick the maximum number of dishes.

Example:
Given N=9 and A=[1,2,2,1,2,1,1,1,1].
For type 1, Chef can choose at most four dishes. One of the ways to choose four dishes of type 1 is A1, A4, A7 and A9.
For type 2, Chef can choose at most two dishes. One way is to choose A3 and A5.
So in this case, Chef should go for type 1, in which he can pick more dishes.

Input:
The first line contains T, the number of test cases. Then the test cases follow.
For each test case, the first line contains a single integer N.
The second line contains N integers A1,A2,…,AN.
Output:
For each test case, print a single line containing one integer ― the type of the dish that Chef should choose from. If there are multiple answers, print the smallest one.

Constraints
1≤T≤103
1≤N≤103
1≤Ai≤103
Sum of N over all test cases doesn't exceed 104
Sample Input:
3
5
1 2 2 1 2
6
1 1 1 1 1 1
8
1 2 2 2 3 4 2 1
Sample Output:
1
1
2
Explanation:
Test case 1:
For both type 1 and type 2, Chef can pick at most two dishes. In the case of multiple answers, we pick the smallest one. Hence the answer will be 1.

Test case 2:
There are only dishes of type 1. So the answer is 1.

Test case 3:
For type 1, Chef can choose at most two dishes. For type 2, he can choose three dishes. For type 3 and type 4, Chef can choose the only dish available. Hence the maximum is in type 2 and so the answer is 2.


import java.util.*;
public class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int [] freq = new int [1001];
            Arrays.fill(freq, 0);
            int last = -1;
            boolean take = true;
            for (int i=0; i<n; i++) {
                int x = sc.nextInt();
                if (last == x)
                    take = !take;
                else
                    take = true;
                if (take)
                    freq[x] += 1;
                last = x;
            }
            int answer = 0;
            int max = 0;
            for (int i=1; i<=1000; i++) {
                if (freq[i] > max) {
                    answer = i;
                    max = freq[i];
                }
            }
            System.out.println(answer);
        }
    }
}

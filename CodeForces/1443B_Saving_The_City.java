
Bertown is a city with n buildings in a straight line.

The city's security service discovered that some buildings were mined. A map was compiled, which is a string of length n, where the i-th character is "1" if there is a mine under the building number i and "0" otherwise.

Bertown's best sapper knows how to activate mines so that the buildings above them are not damaged. When a mine under the building numbered x is activated, it explodes and activates two adjacent mines under the buildings numbered x−1 and x+1 (if there were no mines under the building, then nothing happens). Thus, it is enough to activate any one mine on a continuous segment of mines to activate all the mines of this segment. For manual activation of one mine, the sapper takes a coins. He can repeat this operation as many times as you want.

Also, a sapper can place a mine under a building if it wasn't there. For such an operation, he takes b coins. He can also repeat this operation as many times as you want.

The sapper can carry out operations in any order.

You want to blow up all the mines in the city to make it safe. Find the minimum number of coins that the sapper will have to pay so that after his actions there are no mines left in the city.

Input
The first line contains one positive integer t (1≤t≤105) — the number of test cases. Then t test cases follow.

Each test case begins with a line containing two integers a and b (1≤a,b≤1000) — the cost of activating and placing one mine, respectively.

The next line contains a map of mines in the city — a string consisting of zeros and ones.

The sum of the string lengths for all test cases does not exceed 105.

Output
For each test case, output one integer — the minimum number of coins that the sapper will have to pay.

Example
inputCopy
2
1 1
01000010
5 1
01101110
outputCopy
2
6
Note
In the second test case, if we place a mine under the fourth building and then activate it, then all mines on the field are activated. The cost of such operations is six, b=1 coin for placing a mine and a=5 coins for activating.


import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int answer = a;
            int x = -100000;
            char [] mines = (sc.next() + '0').toCharArray();
            for (int i=0; i<mines.length; i++) {
                if (mines[i] == '1') {
                    if (x > 0) 
                        answer += Math.min(a, x*b);
                    x = 0;
                }
                else
                    x += 1;
            }
            if (x < 0)
                System.out.println(0);
            else
                System.out.println(answer);
        }
    }
}

Given a number N.Find the maximum possible LCM that can be attained by any three numbers less than or equal to N.
Note- LCM stands for Lowest Common Multiple. Also, Numbers can be repeated.

Example 1:

Input:
N=9
Output:
504
Explanation:
504 is the maximum LCM that can be attained
by any triplet of numbers less than or equal 9.
The triplet which has this LCM is {7,8,9}.
Example 2:

Input:
N=7
Output:
210
Explanation:
210 is the maximum LCM that can be attained
by any triplet of numbers less than or equal 7.
The triplet which has this LCM is {5,6,7}.

Your Task:
You don't need to read input or print anything. Your task is to complete the function lcmTriplets() that takes a number N as input parameter and returns the maximum LCM that can be attained by any three numbers less than or equal to N.


Expected Time Complexity:O(logN)
Expected Auxillary Space:O(logN)


Constraints:
1<=N<=106 


class Solution
{
public:
#define ll long long
    ll giveMeLCM(ll a, ll b, ll c)
    {
        ll lcm = (a * b) / __gcd(a, b);
        return (lcm * c) / __gcd(lcm, c);
    }
    long long lcmTriplets(long long n)
    {
        if (n == 1)
            return 1;
        if(n==2)
            return 2;
        if (n & 1)
            return giveMeLCM(n, n - 1, n - 2);
        ll GCD = __gcd(n, n - 3);
        if (GCD == 1)
            return giveMeLCM(n, n - 1, n - 3);
        return giveMeLCM(n - 1, n - 2, n - 3);
    }
};
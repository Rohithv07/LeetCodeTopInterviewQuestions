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

This answer is copied for reference 


#include <algorithm>
#include <array>
#include <cassert>
#include <cstring>
#include <iostream>
#include <vector>
using namespace std;

template<typename A, typename B> ostream& operator<<(ostream &os, const pair<A, B> &p) { return os << '(' << p.first << ", " << p.second << ')'; }
template<typename T_container, typename T = typename enable_if<!is_same<T_container, string>::value, typename T_container::value_type>::type> ostream& operator<<(ostream &os, const T_container &v) { os << '{'; string sep; for (const T &x : v) os << sep << x, sep = ", "; return os << '}'; }

void dbg_out() { cerr << endl; }
template<typename Head, typename... Tail> void dbg_out(Head H, Tail... T) { cerr << ' ' << H; dbg_out(T...); }

#ifdef NEAL_DEBUG
#define dbg(...) cerr << "(" << #__VA_ARGS__ << "):", dbg_out(__VA_ARGS__)
#else
#define dbg(...)
#endif


int D;
string n_str;
int64_t dp[20][2];

int64_t recurse(int digit, bool match) {
    if (digit >= D)
        return 1;

    int64_t &ans = dp[digit][match];

    if (ans >= 0)
        return ans;

    ans = 0;

    for (int d = !(digit % 2); d < 10; d += 2)
        if (d > 0 || digit > 0)
            if (d <= n_str[digit] - '0' || !match)
                ans += recurse(digit + 1, match && d == n_str[digit] - '0');

    return ans;
}

int64_t solve(int64_t n) {
    if (n == 0)
        return 0;

    n_str = to_string(n);
    D = int(n_str.size());
    memset(dp, -1, sizeof(dp));
    int64_t ans = 0;

    for (int i = 0; i < D; i++)
        ans += recurse(i, i == 0);

    return ans;
}

void run_case(int test_case) {
    int64_t L, R;
    cin >> L >> R;
    int64_t answer = solve(R) - solve(L - 1);
    cout << "Case #" << test_case << ": " << answer << '\n';
}

int main() {
    int tests;
    cin >> tests;

    for (int tc = 1; tc <= tests; tc++) {
        run_case(tc);
        cout << flush;
    }
}

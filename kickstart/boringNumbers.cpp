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

#include <bits/stdc++.h>
using namespace std;

int main() {
    int test;
    std::cin >> test;
    while (test-- > 0) {
        int n;
        std::cin >> n;
        int w[n];
        for (int i=0; i<n; i++) {
            std::cin >> w[i];
        }
        int j[n];
        for (int i=0; i<n; i++) {
            std::cin >> j[i];
        }
        std::map<int, pair<int, int>> imap;
        for (int i=0; i<n; i++) {
            imap[w[i]] = {j[i], i};
        }
        int operations = 0;
        int currentJumps;
        for (auto i=imap.begin(); i!=imap.end(); i++) {
            if (i == imap.begin()) {
                currentJumps = (i -> second).second;
            }
            else {
                int j = (i -> second).second;
                while (currentJumps >= j) {
                    operations += 1;
                    j += ((i -> second).first);
                }
                currentJumps = j;
            }
        }
        std::cout<<operations<<"\n";
    }
	return 0;
}

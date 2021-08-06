// https://codeforces.com/blog/entry/90342

#include<bits/stdc++.h>

using namespace std;

int main() {
	int test;
	cin>>test;
	while (test-- > 0) {
		int n;
		cin>>n;
		map<int, int> map;
		long long res = 0;
		for (int i=0; i<n; i++) {
			int x;
			cin>>x;
			x -= i;
			res += map[x];
			map[x]++;
		}
		cout<<res<<endl;
	}
	return 0;
}
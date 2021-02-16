// track all the prime numbers upto 1e6 + 5

#include<bits/stdc++.h>
#define int long long int
#define fastio ios_base::sync_with_stdio(false);cin.tie(0);
using namespace std;

const int N = 1e6 + 5;
int result[N];

void sieveOfEras() {
	vector<int> trackPrime;
	bool prime[N];
	memset(prime, true, sizeof(prime));

	for (int i=2; i*i < N; i++) {
		if (prime[i] == true) {
			for (int j=i*i; j<N; j+=i) {
				prime[j] = false;
			}
		}
	}
	for (int i=2; i<N; i++) {
		if (prime[i]) {
			trackPrime.push_back(i);
		}
	}
	auto first = trackPrime.begin(); // The auto keyword specifies that the type of the variable that is being declared will be automatically deducted from its initializer
	int count = 0;
	for (int i=0; i<N; i++) {
		if (*first <= i) {
			count ++;
			first ++;
		}
		result[i] = count;
	}
}

signed main() {
	fastio;
	sieveOfEras();
	int test;
	cin>>test;
	while (test --) {
		int x;
		int y;
		cin>>x>>y;
		if(result[x] <= y)
            cout<<"Chef"<<"\n";
        else
            cout<<"Divyam"<<"\n";
	}
	return 0;
}
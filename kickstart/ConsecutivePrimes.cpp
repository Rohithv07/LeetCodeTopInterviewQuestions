#include <bits/stdc++.h>
#include <cmath>
using namespace std;

//Function to check if a given number is Prime or not
bool test(long long int n){
    if (n <= 1) return false;
    else if (n <= 3) return true;
    else if (n % 2 == 0 || n % 3 == 0)return false;
    for (long long int i = 5; i * i <= n; i = i + 6){
        if (n % i == 0 || n % (i + 2) == 0)return false;
  	}
    return true;
}
int main() {
	int t;cin >> t;
	for(int q=1;q<t+1;++q) {
		long long int n;cin>>n;
		long long int root = sqrt(n);
		long long int a1 = root;
		long long int a2 = a1+1;
		while(test(a1)!=true){
			a1--;
		}
		while(test(a2)!=true){
			a2++;
		}
		while(a1*a2 > n){
			a2 = a1;
			a1--;
			while(test(a1)!=true)a1--;
		}
		cout << "Case #" << q << ": " << a1*a2 << "\n";
	}
}
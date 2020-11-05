Oleg's favorite subjects are History and Math, and his favorite branch of mathematics is division.

To improve his division skills, Oleg came up with t pairs of integers pi and qi and for each pair decided to find the greatest integer xi, such that:

pi is divisible by xi;
xi is not divisible by qi.
Oleg is really good at division and managed to find all the answers quickly, how about you?
Input
The first line contains an integer t (1≤t≤50) — the number of pairs.

Each of the following t lines contains two integers pi and qi (1≤pi≤1018; 2≤qi≤109) — the i-th pair of integers.

Output
Print t integers: the i-th integer is the largest xi such that pi is divisible by xi, but xi is not divisible by qi.

One can show that there is always at least one value of xi satisfying the divisibility conditions for the given constraints.

Example
inputCopy
3
10 4
12 6
179 822
outputCopy
10
4
179
Note
For the first pair, where p1=10 and q1=4, the answer is x1=10, since it is the greatest divisor of 10 and 10 is not divisible by 4.

For the second pair, where p2=12 and q2=6, note that

12 is not a valid x2, since 12 is divisible by q2=6;
6 is not valid x2 as well: 6 is also divisible by q2=6.
The next available divisor of p2=12 is 4, which is the answer, since 4 is not divisible by 6.

#include<bits/stdc++.h>
using namespace std;
long long p,q,n,i,t;
long long Test(long long i)
{
	if(i==1)
		return 1;
	long long t=p;
	while(t%q==0)
		t/=i;
	return t;
}
int main()
{
	cin>>t;
	while(t--)
	{
		cin>>p>>q;
		if(p%q==0)
		{
			long long ans=1;
			for(i=1;i*i<=q;++i)
				if(q%i==0)
				{
					ans=max(ans,Test(i));
					ans=max(ans,Test(q/i));
				}
			cout<<ans<<endl;
		}
		else
			cout<<p<<endl;
	}
}




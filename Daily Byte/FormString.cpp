/*
Given two strings, source and target, return the minimum number of subsequences of source that can be used to form target.
Note: If it is impossible to use subsequences of source to form target, return -1.
Ex: Given the following source and target…

source = "abc", target = "def", return -1.
Ex: Given the following source and target…

source = "abcdef", target = "abcadaef", return 3.
*/



// C++ program to find the Minimum number
// of subsequences required to convert
// one string to another

#include <bits/stdc++.h>
using namespace std;

// Function to find the no of subsequences
int minSubsequnces(string A, string B)
{
	vector<int> v[26];
	int minIndex = -1, cnt = 1, j = 0;
	int flag = 0;

	for (int i = 0; i < A.length(); i++) {

		// Push the values of indexes of each character
		int p = (int)A[i] - 97;
		v[p].push_back(i);
	}

	while (j < B.length()) {
		int p = (int)B[j] - 97;

		// Find the next index available in the array
		int k = upper_bound(v[p].begin(),
							v[p].end(), minIndex)
				- v[p].begin();

		// If Character is not in string A
		if (v[p].size() == 0) {
			flag = 1;
			break;
		}

		// Check if the next index is not equal to the
		// size of array which means there is no index
		// greater than minIndex in the array
		if (k != v[p].size()) {

			// Update value of minIndex with this index
			minIndex = v[p][k];
			j = j + 1;
		}
		else {

			// Update the value of counter
			// and minIndex for next operation
			cnt = cnt + 1;
			minIndex = -1;
		}
	}
	if (flag == 1) {
		return -1;
	}
	return cnt;
}

// Driver Code
int main()
{
	string A1 = "abcdef";
	string B1 = "abcadaef";
	cout << minSubsequnces(A1, B1) << endl;
	return 0;
}


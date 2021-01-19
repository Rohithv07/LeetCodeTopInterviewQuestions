Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).

NOTE: Required Time Complexity O(n2).

Input:
The first line of input consists number of the testcases. The following T lines consist of a string each.

Output:
In each separate line print the longest palindrome of the string given in the respective test case.

Constraints:
1 ≤ T ≤ 100
1 ≤ Str Length ≤ 104

Example:
Input:
1
aaaabbaa

Output:
aabbaa

Explanation:
Testcase 1: The longest palindrome string present in the given string is "aabbaa".






#include <iostream>
using namespace std;

int main() {
	//code
	int testcases;
	cin>>testcases;
	for (int i=1; i<=testcases; i++) {
    	string s;
    	int bestLength = 0;
    	cin>>s;
    	int n = s.length();
    	string bestString = "";
    	for (int mid=0; mid<n; mid++) {
    	    for (int x=0; mid-x>=0 && mid+x<n; x++) {
    	        if (s[mid-x] != s[mid+x])
    	            break;
    	        int length = 2 * x + 1;
    	        if (length > bestLength) {
    	            bestLength = length;
    	            bestString = s.substr(mid-x, length);
    	        }
    	    }
    	}
    	for (int mid=0; mid<n; mid++) {
    	    for (int x=0; mid-x+1>=0 && mid+x<n; x++) {
    	        if (s[mid-x+1] != s[mid+x])
    	            break;
    	        int length = 2 * x;
    	        if (length > bestLength) {
    	            bestLength = length;
    	            bestString = s.substr(mid-x+1, length);
    	        }
    	    }
    	}
    	cout<<bestString<<"\n";
	}
	
return 0;	
}

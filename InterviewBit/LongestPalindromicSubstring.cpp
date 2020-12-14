Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"


string Solution::longestPalindrome(string s) {
    string best_s = "";
    int n = s.length();
    int best_length = 0;
    for (int mid=0; mid<n; mid++) {
        for (int x=0; mid-x>=0 && mid+x<n; x++) {
            if (s[mid-x] != s[mid+x])
                break;
            int length = 2 * x + 1;
            if (length > best_length) {
                best_length = length;
                best_s = s.substr(mid-x, length);
            }
        }
    }
    for (int mid=0; mid<n-1; mid++) {
        for (int x=1; mid-x+1 >=0 && mid+x<n; x++) {
            if (s[mid-x+1] != s[mid+x])
                break;
            int length = 2 * x;
            if (length > best_length) {
                best_length = length;
                best_s = s.substr(mid-x+1, length);
            }
        }
    }
    return best_s;
}


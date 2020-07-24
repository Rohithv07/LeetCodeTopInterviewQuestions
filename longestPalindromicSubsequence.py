Find the longest subsequence palindrome in a given array a. The longest subsequence palindrome of array a is a subsequence of indices i1 < i2 < ... < ik, where ai1ai2...aik is a palindrome.

Example

For a = [1, 2, 4, 1], the output should be
longestSubsequencePalindrome(a) = 3.

The longest subsequence palindrome here is either 1, 2, 1 or 1, 4, 1, both of which have a length of 3.

For a = [1, 2, 3], the output should be
longestSubsequencePalindrome(a) = 1.


Solution:

def longestSubsequencePalindrome(a):
    length_a = len(a)
    
    L = [[0 for x in range(length_a)] for x in range(length_a)]
    
    for i in range(length_a):
        L[i][i] = 1
        
    for cl in range(2, length_a+1):
        for i in range(length_a-cl+1):
            j = i + cl - 1
            if a[i] == a[j] and cl == 2:
                L[i][j] = 2
            elif a[i] == a[j]:
                L[i][j] = L[i + 1][j - 1] + 2 
            else:
                L[i][j] = max(L[i+1][j], L[i][j-1])
                
    return L[0][length_a-1]

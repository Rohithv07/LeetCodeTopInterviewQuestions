Given a string S of lowercase english characters. Rearrange characters of the given string such that the vowels and consonants occupy alternate positions and the string so formed should be lexicographically (alphabetically) smallest. 
Note: Vowels are 'a', 'e', 'i', 'o' and 'u'. 

Example 1:

Input:
S = "aeroplane"
Output: alanepero
Explanation: alanepero  
The vowels and cosonants are arranged 
alternatively with vowels shown in bold.
Also, there's no lexicographically smaller
string possible with required conditions.
Example 2:

Input: 
S = "mississippi"
Output: -1
Explanation: The number of vowels is 4 
whereas the number of consonants is 7.
Hence, there's no way to arrange the
vowels and consonants alternatively.

Your Task:
You don't need to read input or print anything. Your task is to complete the function rearrange() which takes the string S and its size N as inputs and returns the modified string as stated in the description. If such a modification is not possible, return the string "-1".


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(2*26).


Constraints:
1 <= N <= 10^6
'a' <= S[ i ] <= 'z'


class Solution:
    def rearrange(self, S, N):
        # code here
       u=[]
       v=[]
       for i in range(len(S)):
           if S[i]=='a' or S[i]=='e' or S[i]=='i' or S[i]=='o' or S[i]=='u':
               u.append(S[i])
           else:
               v.append(S[i])
       u=sorted(u)
       v=sorted(v)
       if abs(len(u)-len(v))>1:
           return -1
       else:
           s=max(len(u),len(v))
           if len(u)!=len(v):
               if s==len(u):
                   e=""
                   for j in range(len(v)):
                       e=e+u[j]
                       e=e+v[j]
                   if len(v)<len(u):
                       e=e+u[-1]
                   return e
               if s==len(v):
                   k=""
                   for n in range(len(u)):
                       k=k+v[n]
                       k=k+u[n]
                   if len(u)<len(v):
                       k=k+v[-1]
                   return k
           if len(u)==len(v):
               r=min(u[0],v[0])
               t=""
               if r==v[0]:
                   for p in range(len(u)):
                       t=t+v[p]
                       t=t+u[p]
               else:
                   for x in range(len(v)):
                       t=t+u[x]
                       t=t+v[x]
               return t
        
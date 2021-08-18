You are given two arrays A[] and B[], each of size N . Let's consider an integer X is the count of all different pairs of Ai and Bj, such that Ai XOR Bj is present in any of the two arrays. Return "Yes" (case-sensitive) if X is even, else return "No".

 

Example 1:

Input:
N =  3
A[] = {1, 5, 7}
B[] = {2, 4, 8}
Output:
Yes
Explanation:
XOR(1,2)=3
XOR(1,4) = 5 is present in A[]
XOR(1,8) = 9
XOR(5,2) = 7 is present in A[]
XOR(5,4) = 1 is present in A[]
XOR(5,8) = 13
XOR(7,2) = 5 is present in A[]
XOR(7,4) = 3
XOR(7,8)=15
Out of all these XOR operations, 
5,7,1,5 are present, so count of X = 4 
which is even. Hence the output is "Yes".
Example 2:

Input:
N =  2
A[] = {1, 5}
B[] = {2, 4}
Output:
Yes
Explanation:
XOR(1,2) = 3
XOR(1,4) = 5 is present in A[]
XOR(5,2)=7
XOR(5,4)=1 is present in A[]
Out of all these XOR operations,
1,5 are present,
So count of X = 2 which is even.
Hence the output is "Yes".
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function yesXorNo() which takes an Integer N and two arrays A[] and B[] of size N as input and returns "Yes" if the count of X is even, else "No".

 

Expected Time Complexity: O(1)
Expected Auxiliary Space: O(1)

 

Constraints:
1 <= N <= 105
1 <= A[i],B[i] <= 109



class Solution {
    static String yesXorNo(int N, Long[] A, Long[] B) {
        return "Yes";
    }
}
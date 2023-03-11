You are given an array of N elements and num queries, In each query you are given three numbers L,R and K and you have to tell, how many indexes are there in between L and R(L<=i<=R) such that the frequency of a[i] from index i to n-1 is k.

Note: 0-based indexing

Example 1:

Input:
N=5
num=3
A={1,1,3,4,3}
Q={{0,2,2},{0,2,1},{0,4,2}}
Output:
2 1 2
Explanation:
For query 1: 0 2 2
L=0,R=2,K=2
let, L<=i<=R
For i=0: frequency of a[i] i.e. 1 from i to n-1 is 2.
For i=1: frequency of a[i] i.e. 1 from i to n-1 is 1.
For i=2: frequency of a[i] i.e. 3 from i to n-1 is 2.
Hence we have two elements from index 0 to 2 
whose frequency from i to n-1 is 2.

For query 2: 0 2 1
L=0,R=2,K=1
As we can see from the above query that there is 
only a single element in 0 to 2 whose frequency 
from i to n-1 is 1.

For query 3: 0 4 2
The answer will be 2 because of the index 0 and 2.
Example 2:

Input:
N=5
num=2
A={1,1,1,1,1}
Q={{0,4,2},{0,4,1}}
Output:
1 1 
Explanation: 
For query 1: 0 4 2 
L=0,R=4,K=2 
let, L<=i<=R 
For i=0: frequency of a[i] i.e. 1 from i to n-1 is 5. 
For i=1: frequency of a[i] i.e. 1 from i to n-1 is 4. 
For i=2: frequency of a[i] i.e. 1 from i to n-1 is 3.
For i=3: frequency of a[i] i.e. 1 from i to n-1 is 2.
For i=4: frequency of a[i] i.e. 1 from i to n-1 is 1. 
Hence we have one elements from index 0 to 4 whose frequency from i to n-1 is 2. 

Similarly For query 2: 
there is only 1 element in 0 to 4 whose frequency from i to n-1 is 1.
Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Your Task:
You don't need to read input or print anything. Your task is to complete the function solveQueries() which take two variable N and num representing the length of the original array and number of queries and two arrays as input, A and Q representing the original array and an array of queries(2-D array with 3 columns of L,R and K respectively), and returns the array of length num with the solution to each query.
 

Constraints:
1 <= N <= 103
0 <= Q < 103
1 <= A[i] <= 105




class Solution {
    public static ArrayList<Integer> solveQueries(int N, int num, int[] A, int[][] Q) {
        
         ArrayList<Integer> ans=new ArrayList<>();
         
        int frequency[][]=new int[N][N+1];
        
        for(int i=0;i<N;i++){
            int cnt=0;
            for(int j=i;j<N;j++){
                if(A[i]==A[j]){
                    cnt++;
                }
            }
            frequency[i][cnt]++;
        }
        
        for(int i=0;i<N+1;i++){
            for(int j=1;j<N;j++){
                frequency[j][i]+=frequency[j-1][i];
            }
        }
        
        
        for(int i=0;i<num;i++){
            int L=Q[i][0];
            int R=Q[i][1];
            int K=Q[i][2];
            ans.add((L==0?frequency[R][K]:frequency[R][K]-frequency[L-1][K]));
        }
        
        return ans;
    }
}
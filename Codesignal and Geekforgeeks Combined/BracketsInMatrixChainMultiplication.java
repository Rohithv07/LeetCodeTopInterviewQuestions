Given an array p[] of length n used to denote the dimensions of a series of matrices such that dimension of i'th matrix is p[i] * p[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications such that you need to perform minimum number of multiplications. There are many options to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same.


Example 1:

Input: 
n = 5
p[] = {1, 2, 3, 4, 5}
Output: (((AB)C)D)
Explaination: The total number of 
multiplications are (1*2*3) + (1*3*4) 
+ (1*4*5) = 6 + 12 + 20 = 38.
 

Example 2:

Input: 
n = 3
p = {3, 3, 3}
Output: (AB)
Explaination: The total number of 
multiplications are (3*3*3) = 27.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function matrixChainOrder() which takes n and p[] as input parameters and returns the string with the proper order of parenthesis for n-1 matrices. Use uppercase alphabets to denote each matrix.


Expected Time Complexity: O(n3)
Expected Auxiliary Space: O(n2)


Constraints:
2 ≤ n ≤ 26 
1 ≤ p[i] ≤ 500 






class Solution{
    public static class Pair{
        String order;
        int val;
        Pair(String order,int val){
            this.order = order;
            this.val = val;
        }
    }
    static String matrixChainOrder(int p[], int n){
        // code here
        // int ans = matrixChainOrderUtil(p,n,1,n-1);
        Pair[][] dp = new Pair[n+1][n+1];
        return matrixChainOrderUtil(p,n,1,n-1,dp).order;
        
    }
    
    static Pair matrixChainOrderUtil(int[] p,int n,int i,int j,Pair[][] dp){
        if(i == j){
            return new Pair(""+(char)(i-1+'A'),0);
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int minCost = Integer.MAX_VALUE;
        String ans = "";
        for(int partition=i; partition<j; ++partition){
            Pair p1 = matrixChainOrderUtil(p,n,i,partition,dp);
            Pair p2 = matrixChainOrderUtil(p,n,partition+1,j,dp);
            int temp = p1.val+p2.val+(p[i-1]*p[partition]*p[j]);
            // minCost = Math.min(minCost,temp);
            if(temp<minCost){
                minCost = temp;
                ans = p1.order+p2.order;
            }
            
        }
        dp[i][j] = new Pair("("+ans+")",minCost);
        return dp[i][j];
    }
}
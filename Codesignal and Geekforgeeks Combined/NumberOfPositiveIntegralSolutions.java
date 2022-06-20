You are given an equation of the form x1+x2+...+xN=K. You need to find the total number of positive integral solutions of this equation.
 

Example 1:

Input: s = a+b=5
Output: 4
Explanation: (4,1) , (1,4) , (2,3) , (3,2)

Example 2:

Input: s = a+b=1
Output: 0
Explanation: No solution exist.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function posIntSol() which takes a string as input and returns number of solutions.
 

Expected Time Complexity : O(Length of given string)
Expected Auxiliary Space : O(1)
 

Constraints:
1 <= K <= 25
2 <= N <= 10



class Solution
{
   long posIntSol(String str)
   {
       int target=0;
       int n=0;
       int pc=0;
       int eti=-1;
       for(int i=0;i<str.length();i++)
       {
           char ch=str.charAt(i);
           if(ch=='+')pc++;
           if(ch=='=')
           {
               eti=i;
               break;
           }
       }
       n=Integer.parseInt(str.substring(eti+1));
       java.math.BigInteger ans= nCr(n-1,pc);
       return ans.longValue();
   }
   public static java.math.BigInteger nCr(int n,int r)
   {
       java.math.BigInteger a=fact(n);
       java.math.BigInteger b=fact(r);
       java.math.BigInteger c=fact(n-r);
       
       return a.divide(b.multiply(c));
   }
   public static java.math.BigInteger fact(int n)
   {
       if(n==0)
       {
           return java.math.BigInteger.ZERO;
       }
       java.math.BigInteger b=new java.math.BigInteger("1");
       for(int i=2;i<=n;i++)
       {
           b=b.multiply(java.math.BigInteger.valueOf(i));
       }
       return b;
   }
}
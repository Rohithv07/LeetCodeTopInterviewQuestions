Given a sequence of non-negative integers, find the subsequence of length 3 having maximum product, with the elements of the subsequence being in increasing order.

 

Example 1:

â€‹Input:
n = 8
arr[ ] = {6, 7, 8, 1, 2, 3, 9, 10}
Output:
8 9 10
Explanation: 3 increasing elements of 
the given arrays are 8,9 and 10 which 
forms the subsequence of size 3 with 
maximum product.

â€‹Example 2:

Input:
n = 4
arr[ ] = {3, 4, 2, 1} 
Output:
Not Present 
 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function maxProductSubsequence() that takes an array arr, sizeOfArray n, and return the subsequence of size 3 having the maximum product, numbers of subsequence being in increasing order. If no such sequence exists, return "-1". The driver code takes care of the printing.


Expected Time Complexity: O(N*LOG(N)).
Expected Auxiliary Space: O(N).



Constraints:
1 <= N <= 105
1 <= Arr[i] <= 105




class Solution{
    
   
    public static ArrayList<Integer> maxProductSubsequence (int arr[], int n) {
       long ans = 0; ArrayList<Integer> ar = new ArrayList<>();
       if(arr.length<3){
           ar.add(-1);
           return ar;
       }
      
       TreeSet<Integer> ts = new TreeSet<>();
       ts.add(arr[0]);
      long b = 0;
       for(int i =2;i<arr.length;i++) b=Math.max(b,arr[i]);
           for(int i =1;i<arr.length-1;i++){
               if(arr[i]==b){
                   b=0;
                   for(int j =i+1;j<arr.length;j++) b=Math.max(b,arr[j]);
               }
               long a=-1;
               if(ts.first()<arr[i]) a = ts.floor(arr[i]-1);
               if(b>arr[i] && a >-1){
                    long t = a*b*(long)arr[i];
                    if(t>ans){
                        ans=t;
                        ar.clear();
                        ar.add((int)a);
                        ar.add(arr[i]);
                        ar.add((int)b);
                    }
               }  
                        ts.add(arr[i]);
           } 
           if(ar.size()==0) ar.add(-1);
           return ar;
   } 
    
    
}


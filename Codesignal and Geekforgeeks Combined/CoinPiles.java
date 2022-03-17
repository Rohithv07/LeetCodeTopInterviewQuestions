There are N piles of coins each containing  Ai (1<=i<=N) coins. Find the minimum number of coins to be removed such that the absolute difference of coins in any two piles is at most K.
Note: You can also remove a pile by removing all the coins of that pile.


Example 1:

Input:
N = 4, K = 0
arr[] = {2, 2, 2, 2}
Output:
0
Explanation:
For any two piles the difference in the
number of coins is <=0. So no need to
remove any coins. 
Example 2:
Input:
N = 6, K = 3
arr[] = {1, 5, 1, 2, 5, 1} 
Output :
2
Explanation:
If we remove one coin each from both
the piles containing 5 coins , then
for any two piles the absolute difference
in the number of coins is <=3. 


Your Task:  
You don't need to read input or print anything. Your task is to complete the function minSteps() which takes 2 integers N, and K and an array A of size N as input and returns the minimum number of coins that need to be removed.


Expected Time Complexity: O(N*logN)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105
0 ≤ K ≤ 104
1 ≤ A[i] ≤ 103


class Solution
{
    private static int upperBound(int arr[], int x)
    {
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low + (high - low) / 2;
            
            if(arr[mid]<=x)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        
        return low;
        
        
    }
    
    
    static int minSteps(int[] A, int N, int K)
    {
        Arrays.sort(A);
        
        int prefix[] = new int[N];
        
        prefix[0] = A[0];
        
        for(int i=1; i<N; i++)
        {
            prefix[i] = prefix[i-1] + A[i];
        }
        
        int ans = Integer.MAX_VALUE;
        int prev = 0;
        for(int i=0; i<N; i++)
        {
            int c = 1;
            while(i+1<N && A[i]==A[i+1])
            {
                c++;
                i++;
                continue;
            }
            
            int permissible = A[i] + K;
            
            int idx = upperBound(A, permissible);
            
            int actualsum = prefix[N-1] - prefix[idx-1];
            
            int reduce = (N-idx)*permissible;
            
            actualsum -= reduce;
            
            ans = Math.min(ans, actualsum+prev);
            
            prev += A[i]*c;
            
        }
        
        return ans;
        
    }
}
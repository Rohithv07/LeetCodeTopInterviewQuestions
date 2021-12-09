Given an array arr[ ] of positive integers, the task is to find the maximum XOR value of the elements from all the possible subsets.

Example 1:

Input: N = 3, arr[] = {2, 4, 5}
Output: 7
Explanation: Subset {2, 5} has maximum xor
Example 2:

Input: N = 1, arr[] = {1}
Output: 1
Explanation: Subset {1} has maximum xor

Your Task:  
You don't need to read input or print anything. Complete the function maxXor() which takes N and array arr as input parameter and returns the maximum xor value.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N, arr[i] ≤ 105



class Solution
{
	public int maxXor(int arr[], int n)  
	{  
	    //We use gaussian elimination method.
	    
	    int index = 0;
	    
	    for(int i=31; i>=0; i--){
	        
	        int maxelement = Integer.MIN_VALUE;
	        int maxindex = index;
	        
	        //We find the largest number with set bit at ith position.
	        for(int j=index; j<arr.length;j++){
	            
	            int setbit = (arr[j]>>i) & 1;
	            
	            if(setbit!=0 && maxelement<arr[j]){
	                maxelement = arr[j];
	                maxindex = j;
	            }
	        }
	        
	        //If there is no maxelement.
	        if(maxelement==Integer.MIN_VALUE){
	            continue;
	        }
	        
	        //Replace max element with index
	        int temp = arr[index];
	        arr[index] = arr[maxindex];
	        arr[maxindex] = temp;
	        
	        //replace maxindex with index
	        maxindex = index;
	        
	        //xor all elements with maxelement that have set bit at ith position.
	        for(int j=0; j<n;j++){
	            
	            int setbit = (arr[j]>>i) & 1;
	            
	            if(setbit!=0 && j!=maxindex){
	                arr[j] = arr[j]^arr[maxindex];
	            }
	        }
	        
	        index++;
	        
	    }
	    int res = 0;
	    
	    for(int i: arr){
	        
	        res = res^i;
	    }
	    
	    return res;
	    
	    
	    
	    
	    
	}  
}
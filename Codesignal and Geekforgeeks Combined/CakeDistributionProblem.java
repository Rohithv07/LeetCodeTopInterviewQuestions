// https://practice.geeksforgeeks.org/contest/interview-series-47/problems/



//User function Template for Java

class Solution{
	int maxSweetness(int [] sweetness, int n, int k) {
	    // Write your code here.
	    int low = 1;
	    int high = (int)(1e5);
	   // int low = Arrays.stream(sweetness).max().getAsInt();
	   // int high = Arrays.stream(sweetness).sum();
	    int result = -1;
	    while (low <= high) {
	        int middle = low + (high - low) / 2;
	        if (canDistribute(sweetness, k, middle)) {
	            result = middle;
	            low = middle + 1;
	        }
	        else {
	            high = middle - 1;
	        }
	    }
	    return result;
	}
	
	boolean canDistribute(int [] sweetness, int k, int target) {
	    int total = 0;
	    int count = 0;
	    for (int num : sweetness) {
	        total += (num);
	        if (total >= target) {
	            count++;
	            total = 0;
	            if (count >= k + 1) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
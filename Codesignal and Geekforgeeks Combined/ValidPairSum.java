class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
	    // Your code goes here
	    if (a == null || a.length <= 1) {
	        return 0;
	    }
	    Arrays.sort(a); // nlogn
	    long countOfPairSum = 0;
	    int i = 0;
	    while (i < n) {
	        int j = i + 1;
	        int k = n - 1;
	        int current = 0;
	        // binary search
	        while (j <= k) {
	            int middle = j + (k - j) / 2;
	            if (a[middle] + a[i] > 0) {
	                current = middle;
	                k = middle - 1;
	            }
	            else {
	                j = middle + 1;
	            }
	        }
	        if (current != 0) {
	            countOfPairSum += n - current;
	        }
	        i++;
	    }
	    return countOfPairSum;
	}
} 



// another method

class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
	    // Your code goes here
	    if (a == null || n <= 1) {
	        return 0;
	    }
	    long countOfPairSum = 0;
	    Arrays.sort(a);
	    int left = 0;
	    int right = n - 1;
	    while (left < right) {
	        int value1 = a[left];
	        int value2 = a[right];
	        if (value1 + value2 > 0) {
	            countOfPairSum += right - left;
	            right--;
	        }
	        else {
	            left++;
	        }
	    }
	    return countOfPairSum;
	}
} 

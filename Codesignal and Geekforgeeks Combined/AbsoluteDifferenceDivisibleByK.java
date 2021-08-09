class Solution {
	static long countPairs(int n, int[] arr, int k) {
		// code here
		if (arr == null || n == 0)
		    return 0;
	    long answer = 0;
	    for (int i=0; i<n; i++) {
	        arr[i] = (arr[i] + k) % k;
	    }
	    long [] countOccurance = new long [k];
	    for (int i=0; i<n; i++) {
	        countOccurance[arr[i]] += 1;
	    }
	    for (int i=0; i<k; i++) {
	        answer += (countOccurance[i] * (countOccurance[i] - 1)) / 2;
	    }
	    return answer;
	}
}
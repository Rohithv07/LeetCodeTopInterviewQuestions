// https://practice.geeksforgeeks.org/contest/interview-series-47/problems/


//User function Template for Java

class Solution{
	int rightmostNonZeroDigit(int n, int [] arr) {
		//Write your code here
		if (n == 1 && arr[0] == 0) {
		    return -1;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
		    while (arr[i] > 0 && arr[i] % 5 == 0) {
		        arr[i] /= 5;
		        count++;
		    }
		}
		for (int i = 0; i < n; i++) {
		    while (count != 0 && arr[i] > 0 && arr[i] % 2 == 0) {
		        arr[i] /= 2;
		        count--;
		    }
		}
		int result = 1;
		for (int i = 0; i < n; i++) {
		    result = (result * arr[i] % 10) % 10;
		}
		if (count != 0) {
		    result = (result * 5) % 10;
		}
		return result == 0 ? -1 : result;
	}
}
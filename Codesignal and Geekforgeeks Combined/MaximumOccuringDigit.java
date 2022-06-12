// https://practice.geeksforgeeks.org/contest/interview-series-54/problems/

//User function Template for Java

class Solution{
    static int maxoccourence(int[] arr,int n,int k){
        // code here
        Map<Integer, Integer> occurance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currentNumber = arr[i];
            int currentOccur = findDigit(currentNumber, k);
            occurance.put(currentNumber, currentOccur);
        }
        int result = Integer.MAX_VALUE;
        int occur = -1;
        for (Integer key : occurance.keySet()) {
            int current = occurance.get(key);
            if (current >= occur) {
                result = current == occur ? Math.min(result, key) : key;
                occur = current;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    static int findDigit(int num, int k) {
        int count = 0;
        while (num > 0) {
            int rem = num % 10;
            if (rem == k) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
    
}
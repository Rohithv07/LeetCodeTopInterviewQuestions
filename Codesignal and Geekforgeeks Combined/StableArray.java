// idea is correct but a little implementation problem at line 82

// https://www.youtube.com/watch?v=F4E2SIS2sPc

class Solution {
    public static int stableArray(int n, int[] a) {
        // code here
        // if (n <= 2) {
        //     return 0;
        // }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int [] freq = new int [map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            freq[index++] = map.get(key);
        }
        Arrays.sort(freq);
        int low = freq[0];
        int high = freq[map.size() - 1];
        int result = n + 1;
        int j = 0;
        for (int x : freq) {
            // find the right most index of x where freq>=x
            int indexX = findIndex(x, freq) - freq[0];
            //System.out.println(indexX);
            //indexX -= freq[0];
            int elements = freq.length - indexX;
            result = Math.min(result, n - (elements * x));
        }
        return result;
    }
    
    private static int findIndex(int key, int [] freq) {
        int low = 0;
        int high = freq.length - 1;
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (freq[middle] <= key) {
                result = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return result;
    }
}
        


// can be done without applying the binary search which also gets accepted



// https://www.youtube.com/watch?v=F4E2SIS2sPc

class Solution {
    public static int stableArray(int n, int[] a) {
        // code here
        // if (n <= 2) {
        //     return 0;
        // }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int [] freq = new int [map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            freq[index++] = map.get(key);
        }
        Arrays.sort(freq);
        int result = n + 1;
        int j = 0;
        for (int i = 0; i < freq.length; i++) {
            int elements = freq.length - i;
            result = Math.min(result, n - (elements * freq[i]));
        }
        return result;
    }
    
    private static int findIndex(int key, int [] freq) {
        int low = 0;
        int high = freq.length - 1;
        int result = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (freq[middle] <= key) {
                result = middle;
                low = middle + 1;
            }
            else {
                high = middle - 1;
            }
        }
        return result;
    }
}
        

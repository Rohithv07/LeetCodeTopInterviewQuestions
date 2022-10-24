
// https://practice.geeksforgeeks.org/contest/weekly-interview-series-72/problems/#

// https://www.youtube.com/watch?v=owALwrH6x_Y&list=RDCMUCXQnpama_0lAzj_4MAdZ5vw&index=9

class Solution {
    
    private static List<Long> allNumbers;
    private static boolean isComputed = false;
    
    public static int totalNumbers(long n) {
        // code here
        if (!isComputed) {
            allNumbers = new ArrayList<>();
            int m = (1 << 12);
            TreeSet<Long> distinct = new TreeSet<>();
            for (int mask = 0; mask < m; mask++) {
                for (int x = 0; x < 10; x++) {
                    for (int y = 0; y < 10; y++) {
                        int currentMask = mask;
                        long currentNum = 0l;
                        long pow = 1l;
                        while (currentMask > 0) {
                            if ((currentMask & 1) == 1) {
                                currentNum += (pow * x); 
                            }
                            else {
                                currentNum += (pow * y);
                            }
                            pow *= 10L;
                            currentMask >>= 1;
                        }
                        distinct.add(currentNum);
                    }
                }
            }
            for (long val : distinct) {
                allNumbers.add(val);
            }
        }
        isComputed = true;
        // for (int i = 0; i < 20; i++) {
        //     System.out.print(allNumbers.get(i) + " ");
        // }
        // System.out.println();
        return binarySearch(allNumbers, (n + 1l));
    }
    
    private static int binarySearch(List<Long> allNumbers, long n) {
        int left = 0;
        int right = allNumbers.size() - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (allNumbers.get(middle) == (long)n) {
                return middle;
            }
            if (allNumbers.get(middle) > (long)n) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }
        return left;
    }
}
        

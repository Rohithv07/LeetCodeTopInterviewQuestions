// https://practice.geeksforgeeks.org/contest/interview-series-63/problems/#

// https://www.youtube.com/watch?v=zg43_5GU03w




/*
1. find the count of consecutive equals elements present in the given string.
2. Traverse through the string and check whether the consecutive count is already 0.
If thats the case, we can already return the days as there are no consecutive elements prsent.
3. Else we need to check if a[i - 1] == a[i] && a[i] == a[i + 1] cases.
aaa -> here the consective count is aa and aa => 2
So when the condition meets, we can decrease the consecutive count by 2 when
we are putting ? on the first index and it becomes a?a.
4. Continue this process till fully traversing or getting the count as 0.


*/


class Solution {
    public static int getMinimumDays(int n, String s, int[] p) {
        // code here
        if (n == 1) {
            return 0;
        }
        int minDays = 0;
        char [] letters = s.toCharArray();
        int countOfEqualConsecutive = findCount(s, n);
        //System.out.println(countOfEqualConsecutive);
        for (int i = 0; i < p.length; i++) {
            int index = p[i];
            if (countOfEqualConsecutive <= 0) {
                return minDays;
            }
            //  if (letters[index] == '?') {
            //     continue;
            // }
            minDays++;
            if (index == 0) {
                if (letters[index] == letters[index + 1]) {
                    countOfEqualConsecutive--;
                }
                letters[index] = '?';
            }
            else if (index == n - 1) {
                if (letters[index - 1] == letters[index]) {
                    countOfEqualConsecutive--;
                }
                letters[index] = '?';
            }
            else {
                if (letters[index - 1] == letters[index] && letters[index] == letters[index + 1]) {
                    countOfEqualConsecutive -= 2;
                }
                else if (letters[index - 1] == letters[index]) {
                    countOfEqualConsecutive--;
                }
                else if (letters[index] == letters[index + 1]) {
                    countOfEqualConsecutive--;
                }
                letters[index] = '?';
            }
        }
        return minDays;
    }
    
    private static int findCount(String s, int n) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}
        

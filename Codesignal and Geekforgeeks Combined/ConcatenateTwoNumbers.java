// https://practice.geeksforgeeks.org/contest/interview-series-phonepe/instructions/#

//User function Template for Java
class Solution 
{ 
    long countPairs(int n, int x, int numbers[]) 
    { 
        // code here
        String converted = Integer.toString(x);
        Map<String, Integer> map = new HashMap<>();
        for (int number : numbers) {
            String s = Integer.toString(number);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        long count = 0;
        for (int i=0; i<converted.length(); i++) {
            String s1 = converted.substring(0, i + 1);
            String s2 = converted.substring(i + 1);
            long count1 = map.getOrDefault(s1, 0);
            long count2 = map.getOrDefault(s2, 0);
            if (s1.equals(s2)) {
                count += (count1 * (count2 - 1));
            }
            else {
                count += (count1 * count2);
            }
        }
        return count;
    }
} 
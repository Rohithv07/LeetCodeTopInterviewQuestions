// https://practice.geeksforgeeks.org/contest/interview-series-46/problems/


//User function Template for Java
class Solution 
{ 
    int countSubstring(String s) 
    { 
        // code here
        if (s == null || s.length() < 2) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                sum += 1;
            }
            else {
                sum -= 1;
            }
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
} 

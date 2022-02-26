Given a string S consisting of the characters 0, 1 and 2. Your task is to find the length of the smallest substring of string S that contains all the three characters 0, 1 and 2. If no such substring exists, then return -1.

Example 1:

Input:
S = "01212"
Output:
3
Explanation:
The substring 012 is the smallest substring
that contains the characters 0, 1 and 2.
Example 2:

Input: 
S = "12121"
Output:
-1
Explanation: 
As the character 0 is not present in the
string S, therefor no substring containing
all the three characters 0, 1 and 2
exists. Hence, the answer is -1 in this case.
Your Task:
Complete the function smallestSubstring() which takes the string S as input, and returns the length of the smallest substring of string S that contains all the three characters 0, 1 and 2.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ |S| ≤ 105
All the characters of String S lies in the set {'0', '1', '2'}

class Solution {
    public int smallestSubstring(String s) {
        // Code here
        if (s == null || s.length() == 0 || s.length() < 3) {
            return -1;
        }
        Map<Character, Integer> substringMap = new HashMap<>();
        // 012 we2ye8dusud
        substringMap.put('0', 1);
        substringMap.put('1', 1);
        substringMap.put('2', 1);
        int counterSize = 3; // map.size()
        int minimumWindowSize = Integer.MAX_VALUE;
        int startPointer = 0;
        int endPointer = 0;
        int length = s.length();
        while (endPointer < length) {
            char currentEndPointerChar = s.charAt(endPointer);
            if (substringMap.containsKey(currentEndPointerChar)) {
                substringMap.put(currentEndPointerChar, 
                substringMap.get(currentEndPointerChar) - 1);
                if (substringMap.get(currentEndPointerChar) == 0) {
                    counterSize--;
                }
            }
            endPointer++;
            while (counterSize == 0) {
                char currentStartPointerChar = s.charAt(startPointer);
                if (substringMap.containsKey(currentStartPointerChar)) {
                    substringMap.put(currentStartPointerChar, 
                    substringMap.get(currentStartPointerChar) + 1);
                    if (substringMap.get(currentStartPointerChar) > 0) {
                        counterSize++;
                    }
                }
                if (endPointer - startPointer < minimumWindowSize) {
                    minimumWindowSize = endPointer - startPointer;
                }
                startPointer++;
            }
        }
        return minimumWindowSize == Integer.MAX_VALUE ? -1 : minimumWindowSize;
    }
}

Given two strings S and P. Find the smallest window in the string S consisting of all the characters(including duplicates) of the string P.  Return "-1" in case there is no such window present. In case there are multiple such windows of same length, return the one with the least starting index. 

Example 1:

Input:
S = "timetopractice"
P = "toc"
Output: 
toprac
Explanation: "toprac" is the smallest
substring in which "toc" can be found.
Example 2:

Input:
S = "zoomlazapzo"
P = "oza"
Output: 
apzo
Explanation: "apzo" is the smallest 
substring in which "oza" can be found.
Your Task:
You don't need to read input or print anything. Your task is to complete the function smallestWindow() which takes two string S and P as input paramters and returns the smallest window in string S having all the characters of the string P. In case there are multiple such windows of same length, return the one with the least starting index. 

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(1)

Constraints: 
1 ≤ |S|, |P| ≤ 105



class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        if (s == null || s.length() == -1)
            return "-1";
        if (s.length() < p.length())
            return "-1";
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : p.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        int start = 0;
        int end = 0;
        int head = 0;
        int length = Integer.MAX_VALUE; // min window size
        int counter = count.size();
        while (end < s.length()) {
            char currentEnd = s.charAt(end);
            if (count.containsKey(currentEnd)) {
                count.put(currentEnd, count.get(currentEnd) - 1);
                if (count.get(currentEnd) == 0) {
                    counter --;
                }
            }
            end++;
            while (counter == 0) {
                char currentStart = s.charAt(start);
                if (count.containsKey(currentStart)) {
                    count.put(currentStart, count.get(currentStart) + 1);
                    if (count.get(currentStart) > 0) {
                        counter++;
                    }
                }
                if (end - start < length) {
                    length = end - start;
                    head = start;
                }
                start++;
            }
        }
        return length == Integer.MAX_VALUE ? "-1" : s.substring(head, head + length);
    }
}
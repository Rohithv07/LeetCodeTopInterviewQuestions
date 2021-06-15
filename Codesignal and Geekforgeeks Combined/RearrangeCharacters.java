Given a string S with repeated characters. The task is to rearrange characters in a string such that no two adjacent characters are the same. 

Note: The string has only lowercase English alphabets and it can have multiple solutions. Return any one of them.

Example 1:

Input : 
str = "geeksforgeeks"
Output: 1
Explanation:
All the repeated characters of the 
given string can be rearranged so 
that no adjacent characters in the 
string is equal. Any correct 
rearrangement will show a output of 1.
Example 2:

Input : 
str = "bbbbb"
Output: 0
Explanation : 
Repeated characters in the string cannot 
be rearranged such that there should not 
be any adjacent repeated character.
Your task :
You don't have to read input or print anything. Your task is to complete the function rearrangeString() which takes the string as input and returns the modified string. If the string cannot be modified return "-1".
 
Expected Time Complexity : O(NlogN), N = length of String
Expected Auxiliary Space : O(number of english alphabets) // we can also use a count array of size 26 instead of map
 
Constraints : 
1 <= length of string <= 104



class Solution
{
	public static String rearrangeCharacters(String str) {
	
		//code here
		if (str == null || str.length() == 0)
		    return "-1";
		Map<Character, Integer> count = new HashMap<>();
		for (char ch : str.toCharArray()) {
		    count.put(ch, count.getOrDefault(ch, 0) + 1);
		}
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(count.get(b), count.get(a)));
		pq.addAll(count.keySet());
		StringBuilder sb = new StringBuilder();
		while (pq.size() > 1) {
		    char max1 = pq.poll();
		    char max2 = pq.poll();
		    sb.append(max1).append(max2);
		    count.put(max1, count.get(max1) - 1);
		    count.put(max2, count.get(max2) - 1);
		    if (count.get(max1) > 0) {
		        pq.add(max1);
		    }
		    if (count.get(max2) > 0) {
		        pq.add(max2);
		    }
		}
		if (!pq.isEmpty()) {
		    char remaining = pq.poll();
		    if (count.get(remaining) > 1) {
		        return "-1";
		    }
		    sb.append(remaining);
		}
		return sb.toString();
	}
}

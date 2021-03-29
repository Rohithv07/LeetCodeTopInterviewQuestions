Given a string s and a string p, return all the starting indices of p’s anagrams within s.
Note: Both strings will contain at least one character and will only contain lowercase alphabetical characters.

Ex: Given the following s and p…

s = "abcbabc", p = "abc", return [0, 2, 4].
Ex: Given the following s and p…

s = "abc", p = "def", return [].





// 1 solution
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int length1 = s.length();
        int length2 = p.length();
        int [] count = new int [26];
        for (char ch : p.toCharArray()) {
            count[ch - 'a'] += 1;
        }
        for (int i=0; i<=length1 - length2; i++) {
            String current = s.substring(i, i + length2);
            int [] tempCount = new int [26];
            for (char ch : current.toCharArray()) {
                tempCount[ch - 'a'] += 1;
            }
            boolean flag = true;
            for (int j=0; j<26; j++) {
                if (count[j] != tempCount[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                result.add(i);
        }
        return result;
    }
}

// 2 solution
public class Solution {
    public List<Integer> findAnagrams(String s, String t) {
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        
        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;
        
        
        while(end < s.length()){
            char c = s.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;
            
            while(counter == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin == t.length()){
                    result.add(begin);
                }
                begin++;
            }
            
        }
        return result;
    }
}
